package com.brandrobkus.sunbreaking.item.weapons;

import com.brandrobkus.sunbreaking.entity.custom.StormBallEntity;
import com.brandrobkus.sunbreaking.entity.custom.StormBallPrecisionEntity;
import com.brandrobkus.sunbreaking.item.ModItems;
import com.brandrobkus.sunbreaking.item.weapons.fragments.FragmentHelper;
import com.brandrobkus.sunbreaking.network.ItemEffectToggleable;
import com.brandrobkus.sunbreaking.sound.ModSounds;
import com.brandrobkus.sunbreaking.util.ModTags;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import net.minecraft.client.item.BundleTooltipData;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.item.TooltipData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.*;
import java.util.stream.Stream;

public class BondItem extends Item implements ItemEffectToggleable {

    private static final int MAX_STORAGE = 128;
    public static final String PRECISION_KEY = "PrecisionMode";
    private static final Set<UUID> playersOnCooldown = new HashSet<>();

    public BondItem(Settings settings) {
        super(settings.maxDamage(300));
    }

    public static boolean isPrecisionMode(ItemStack stack) {
        return stack.getOrCreateNbt().getBoolean(PRECISION_KEY);
    }

    public float getArcSuperCost(ItemStack stack) {
        boolean shock = FragmentHelper.hasFragment(stack, ModItems.FRAGMENT_OF_SHOCK);
        int volts = FragmentHelper.getFragmentCount(stack, ModItems.FRAGMENT_OF_VOLTS);

        if (shock && isPrecisionMode(stack)) {
            return 12.5f + 12.5f * volts;
        } else {
            return 37.5f + 25f * volts;
        }
    }

    @Override
    public void onToggleEffect(ItemStack stack, PlayerEntity player) {
        if (!FragmentHelper.hasFragment(stack, ModItems.FRAGMENT_OF_SHOCK)) {
            if (player.getWorld().isClient) {
                player.playSound(ModSounds.COOLDOWN_INDICATOR, 1,1);
            }
            return;
        }

        if (!player.getWorld().isClient) {
            NbtCompound nbt = stack.getOrCreateNbt();
            boolean newValue = !nbt.getBoolean(PRECISION_KEY);
            nbt.putBoolean(PRECISION_KEY, newValue);
        }
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);

        if (user.getMainHandStack().getItem() != this && user.getOffHandStack().getItem() != this) {
            stack.getOrCreateNbt().putBoolean(PRECISION_KEY, false);
        }

        if (playersOnCooldown.contains(user.getUuid())) {
            return TypedActionResult.fail(stack);
        }

        boolean shock = FragmentHelper.hasFragment(stack, ModItems.FRAGMENT_OF_SHOCK);
        int volts = FragmentHelper.getFragmentCount(stack, ModItems.FRAGMENT_OF_VOLTS);
        boolean precision = isPrecisionMode(stack);

        float totalCost = (precision && shock)
                ? 12.5f + 12.5f * volts
                : 37.5f + 25f * volts;

        if (!user.isCreative() && PlayerSuperAccessor.get(user).getSuper() < totalCost) {
            user.playSound(ModSounds.COOLDOWN_INDICATOR, 1.0F, 1.0F);
            user.getItemCooldownManager().set(this, 15);
            playersOnCooldown.add(user.getUuid());
            return TypedActionResult.fail(stack);
        }

        PlayerSuperAccessor.get(user).addSuper(-totalCost);

        if (!world.isClient) {
            int throwsCount = 1 + volts;

            for (int i = 0; i < throwsCount; i++) {
                ThrownItemEntity ball;

                if (precision && shock) {
                    ball = new StormBallPrecisionEntity(user, world);
                } else {
                    StormBallEntity regularBall = new StormBallEntity(user, world);
                    regularBall.setFragmentData(shock, volts);
                    ball = regularBall;
                }

                float speed = switch (i) {
                    case 1 -> 0.66f;
                    case 2 -> 1.33f;
                    default -> 1.0f;
                };

                ball.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, speed, 1.0F);
                world.spawnEntity(ball);
            }

            world.playSound(null, user.getBlockPos(), ModSounds.STORM_BALL, SoundCategory.PLAYERS, 1.5F, 1.0F);

            if (!user.getAbilities().creativeMode) {
                stack.damage(1, user, p -> p.sendToolBreakStatus(hand));
                user.getItemCooldownManager().set(this, 20);
                playersOnCooldown.add(user.getUuid());
            }
        }

        return TypedActionResult.success(stack, world.isClient());
    }

    public static void tick(World world) {
        if (!world.isClient) {
            playersOnCooldown.removeIf(playerId -> {
                ServerPlayerEntity player = (ServerPlayerEntity) world.getPlayerByUuid(playerId);
                return player == null;
            });
        }
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    // ========================= BUNDLE STORAGE =========================
    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        if (clickType != ClickType.RIGHT) {
            return false;
        } else {
            ItemStack itemStack = slot.getStack();
            if (itemStack.isEmpty()) {
                this.playRemoveOneSound(player);
                removeFirstStack(stack).ifPresent(removedStack -> addToBundle(stack, slot.insertStack(removedStack)));
            } else if (itemStack.isIn(ModTags.Items.ARC_FRAGMENTS)) {
                int amount = (MAX_STORAGE - getBundleOccupancy(stack)) / getItemOccupancy(itemStack);
                int added = addToBundle(stack, slot.takeStackRange(itemStack.getCount(), amount, player));
                if (added > 0) {
                    this.playInsertSound(player);
                }
            }

            return true;
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.RIGHT && slot.canTakePartial(player)) {
            if (otherStack.isEmpty()) {
                removeFirstStack(stack).ifPresent(itemStack -> {
                    this.playRemoveOneSound(player);
                    cursorStackReference.set(itemStack);
                });
            } else if (otherStack.isIn(ModTags.Items.ARC_FRAGMENTS)) {
                int i = addToBundle(stack, otherStack);
                if (i > 0) {
                    this.playInsertSound(player);
                    otherStack.decrement(i);
                }
            }
            else {
                player.playSound(ModSounds.COOLDOWN_INDICATOR, 0.5F, 1.0F);
            }
            return true;
        }
        return false;

    }

    // ========================= BUNDLE LOGIC =========================
    private static int getUniqueFragmentCount(NbtList items) {
        return (int) items.stream()
                .filter(NbtCompound.class::isInstance)
                .map(NbtCompound.class::cast)
                .map(ItemStack::fromNbt)
                .map(ItemStack::getItem)
                .distinct()
                .count();
    }

    private static int addToBundle(ItemStack bundle, ItemStack stack) {
        if (stack.isEmpty()
                || !stack.getItem().canBeNested()
                || !stack.isIn(ModTags.Items.ARC_FRAGMENTS)) {
            return 0;
        }

        NbtCompound nbt = bundle.getOrCreateNbt();
        if (!nbt.contains("Items")) {
            nbt.put("Items", new NbtList());
        }

        NbtList items = nbt.getList("Items", NbtElement.COMPOUND_TYPE);

        int currentOccupancy = getBundleOccupancy(bundle);
        int itemOccupancy = getItemOccupancy(stack);
        int maxAddable = (MAX_STORAGE - currentOccupancy) / itemOccupancy;

        if (maxAddable <= 0) {
            return 0;
        }

        Optional<NbtCompound> mergeTarget = canMergeStack(stack, items);

        if (mergeTarget.isPresent()) {
            NbtCompound existingNbt = mergeTarget.get();
            ItemStack existingStack = ItemStack.fromNbt(existingNbt);

            int spaceLeft = existingStack.getMaxCount() - existingStack.getCount();
            if (spaceLeft <= 0) {
                return 0;
            }

            int toAdd = Math.min(stack.getCount(), Math.min(spaceLeft, maxAddable));
            if (toAdd <= 0) {
                return 0;
            }

            existingStack.increment(toAdd);
            existingStack.writeNbt(existingNbt);

            items.remove(existingNbt);
            items.add(0, existingNbt);

            return toAdd;
        }

        int uniqueCount = getUniqueFragmentCount(items);
        if (uniqueCount >= 2) {
            return 0;
        }

        int toAdd = Math.min(stack.getCount(), maxAddable);
        toAdd = Math.min(toAdd, stack.getMaxCount());

        if (toAdd <= 0) {
            return 0;
        }

        ItemStack copy = stack.copyWithCount(toAdd);
        NbtCompound itemNbt = new NbtCompound();
        copy.writeNbt(itemNbt);

        items.add(0, itemNbt);
        return toAdd;
    }

    private static Optional<NbtCompound> canMergeStack(ItemStack stack, NbtList items) {
        return stack.isOf(Items.BUNDLE)
                ? Optional.empty()
                : items.stream()
                .filter(NbtCompound.class::isInstance)
                .map(NbtCompound.class::cast)
                .filter(item -> ItemStack.canCombine(ItemStack.fromNbt(item), stack))
                .findFirst();
    }

    private static int getItemOccupancy(ItemStack stack) {
        if (stack.isOf(Items.BUNDLE)) {
            return 4 + getBundleOccupancy(stack);
        } else {
            if ((stack.isOf(Items.BEEHIVE) || stack.isOf(Items.BEE_NEST)) && stack.hasNbt()) {
                NbtCompound nbtCompound = BlockItem.getBlockEntityNbt(stack);
                if (nbtCompound != null && !nbtCompound.getList("Bees", NbtElement.COMPOUND_TYPE).isEmpty()) {
                    return 64;
                }
            }

            return 64 / stack.getMaxCount();
        }
    }

    private static int getBundleOccupancy(ItemStack stack) {
        return getBundledStacks(stack).mapToInt(itemStack -> getItemOccupancy(itemStack) * itemStack.getCount()).sum();
    }

    private static Optional<ItemStack> removeFirstStack(ItemStack stack) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        if (!nbtCompound.contains("Items")) {
            return Optional.empty();
        } else {
            NbtList nbtList = nbtCompound.getList("Items", NbtElement.COMPOUND_TYPE);
            if (nbtList.isEmpty()) {
                return Optional.empty();
            } else {
                int i = 0;
                NbtCompound nbtCompound2 = nbtList.getCompound(0);
                ItemStack itemStack = ItemStack.fromNbt(nbtCompound2);
                nbtList.remove(0);
                if (nbtList.isEmpty()) {
                    stack.removeSubNbt("Items");
                }

                return Optional.of(itemStack);
            }
        }
    }

    private static Stream<ItemStack> getBundledStacks(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        if (nbtCompound == null) {
            return Stream.empty();
        } else {
            NbtList nbtList = nbtCompound.getList("Items", NbtElement.COMPOUND_TYPE);
            return nbtList.stream().map(NbtCompound.class::cast).map(ItemStack::fromNbt);
        }
    }

    public static List<Text> getBundledItemNames(ItemStack bundle) {
        return getBundledStacks(bundle)
                .map(ItemStack::getName)
                .toList();
    }

    // ========================= TOOLTIP =========================
    private static String toRoman(int number) {
        if (number <= 0) return "";

        int[] values = {5, 4, 1};
        String[] numerals = {"V", "IV", "I"};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }

    @Override
    public Optional<TooltipData> getTooltipData(ItemStack stack) {
        DefaultedList<ItemStack> defaultedList = DefaultedList.of();
        getBundledStacks(stack).forEach(defaultedList::add);
        return Optional.of(new BundleTooltipData(defaultedList, getBundleOccupancy(stack)));
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {

        Map<Item, Integer> fragmentCounts = new LinkedHashMap<>();

        getBundledStacks(stack).forEach(fragmentStack -> {
            fragmentCounts.merge(
                    fragmentStack.getItem(),
                    fragmentStack.getCount(),
                    Integer::sum
            );
        });

        if (!fragmentCounts.isEmpty()) {
            tooltip.add(Text.literal("Contents:").formatted(Formatting.YELLOW));

            fragmentCounts.forEach((item, count) -> {
                Text name = item.getName();
                if (count > 1) {
                    name = Text.literal(name.getString() + " - " + toRoman(count));
                }

                tooltip.add(
                        Text.literal("- ")
                                .append(name)
                                .formatted(Formatting.AQUA)
                );
            });
        }
        if (fragmentCounts.isEmpty()) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.requires_sunbreaker_fragment.tooltip").formatted(Formatting.AQUA));
            tooltip.add(Text.translatable("tooltip.sunbreaking.requires_stormcaller_fragment.tooltip_1").formatted(Formatting.AQUA));
        }
    }
    // ========================= ENTITY EVENTS =========================
    @Override
    public void onItemEntityDestroyed(ItemEntity entity) {
        ItemUsage.spawnItemContents(entity, getBundledStacks(entity.getStack()));
    }

    // ========================= SOUNDS =========================
    private void playRemoveOneSound(Entity entity) {
        entity.playSound(ModSounds.ASPECT_REMOVE, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(ModSounds.ASPECT_EQUIP, 0.8F, 0.8F + entity.getWorld().getRandom().nextFloat() * 0.4F);
    }
}