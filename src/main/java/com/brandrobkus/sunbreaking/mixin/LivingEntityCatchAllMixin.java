package com.brandrobkus.sunbreaking.mixin;

import com.brandrobkus.sunbreaking.enchantment.ModEnchantments;
import com.brandrobkus.sunbreaking.entity.custom.FirelessLightningEntity;
import com.brandrobkus.sunbreaking.entity.custom.ShadowshotArrowEntity;
import com.brandrobkus.sunbreaking.command.fireteam.FireteamManager;
import com.brandrobkus.sunbreaking.entity.custom.SolHammerProjectileEntity;
import com.brandrobkus.sunbreaking.event.DamageTracker;
import com.brandrobkus.sunbreaking.item.ModItems;
import com.brandrobkus.sunbreaking.item.custom.ModArcArmorItem;
import com.brandrobkus.sunbreaking.item.custom.ModSolarArmorItem;
import com.brandrobkus.sunbreaking.item.custom.ModVoidArmorItem;
import com.brandrobkus.sunbreaking.item.weapons.BaseHammerItem;
import com.brandrobkus.sunbreaking.item.weapons.BondItem;
import com.brandrobkus.sunbreaking.item.weapons.SolHammerItem;
import com.brandrobkus.sunbreaking.item.weapons.fragments.FragmentHelper;
import com.brandrobkus.sunbreaking.util.BondGlowTracked;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityCatchAllMixin implements BondGlowTracked {

    @Inject(method = "onDeath", at = @At("HEAD"))
    private void onDeathInject(DamageSource source, CallbackInfo ci) {
        LivingEntity victim = (LivingEntity) (Object) this;

        if (victim.getWorld().isClient()) return;

        Entity attacker = source.getAttacker();
        Entity immediate = source.getSource();

        PlayerEntity creditedPlayer = null;

        if (immediate instanceof FirelessLightningEntity lightning) {
            creditedPlayer = lightning.getOwnerPlayer();
        } else if (attacker instanceof PlayerEntity player) {
            creditedPlayer = player;
        }

        if (!(attacker instanceof PlayerEntity player)) return;

        if (immediate instanceof PersistentProjectileEntity projectile) {

            boolean isArrowKill =
                    projectile instanceof ArrowEntity ||
                            projectile instanceof SpectralArrowEntity ||
                            projectile instanceof ShadowshotArrowEntity;

            if (isArrowKill) {
                handleArrowKill(player);
                return;
            }
        }

        boolean isLightning = source.getSource() instanceof FirelessLightningEntity;

        if (immediate instanceof SolHammerProjectileEntity) {
            handleHammerKill(player);
        }

        if (isLightning) {
            handleBondKill(player);
        }

        if (creditedPlayer != null) {

            ItemStack main = creditedPlayer.getMainHandStack();
            ItemStack off = creditedPlayer.getOffHandStack();

            ItemStack bond =
                    main.getItem() instanceof BondItem ? main :
                            off.getItem() instanceof BondItem ? off :
                                    ItemStack.EMPTY;

            if (!bond.isEmpty()
                    && FragmentHelper.hasFragment(bond, ModItems.FRAGMENT_OF_BEACONS)
                    && ((BondGlowTracked) victim).isBondGlowing()) {

                PlayerSuperAccessor.get(creditedPlayer).addSuper(12f);
            }
        }

    }

    private void handleArrowKill(PlayerEntity player) {
        if (!hasFullNightstalkerSet(player)) return;

        ItemStack chest = player.getInventory().getArmorStack(2);
        if (!(chest.getItem() instanceof ModVoidArmorItem voidChest)) return;

        boolean hasRenewal =
                voidChest.hasItemInBundle(chest, ModItems.ASPECT_OF_RENEWAL);

        if (!hasRenewal) return;

        PlayerSuperAccessor.get(player).setRenewedTicks(100);
    }

    private boolean hasFullNightstalkerSet(PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getItem() instanceof ModVoidArmorItem &&
                player.getInventory().getArmorStack(1).getItem() instanceof ModVoidArmorItem &&
                player.getInventory().getArmorStack(2).getItem() instanceof ModVoidArmorItem &&
                player.getInventory().getArmorStack(3).getItem() instanceof ModVoidArmorItem;
    }

    private void handleHammerKill(PlayerEntity player) {
        if (!hasFullSunbreakerSet(player)) return;

        ItemStack chest = player.getInventory().getArmorStack(2);
        if (!(chest.getItem() instanceof ModSolarArmorItem solarChest)) return;

        boolean hasResolve =
                solarChest.hasItemInBundle(chest, ModItems.ASPECT_OF_RESOLVE);

        if (!hasResolve) return;

        System.out.println("Applying Aspect of Resolve!");

        PlayerSuperAccessor.get(player).setResolveTicks(140);
    }

    private boolean hasFullSunbreakerSet(PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getItem() instanceof ModSolarArmorItem &&
                player.getInventory().getArmorStack(1).getItem() instanceof ModSolarArmorItem &&
                player.getInventory().getArmorStack(2).getItem() instanceof ModSolarArmorItem &&
                player.getInventory().getArmorStack(3).getItem() instanceof ModSolarArmorItem;
    }

    private void handleBondKill(PlayerEntity player) {
        if (!hasFullStormcallerSet(player)) return;

        ItemStack chest = player.getInventory().getArmorStack(2);
        if (!(chest.getItem() instanceof ModArcArmorItem arcChest)) return;

        boolean hasRecharge =
                arcChest.hasItemInBundle(chest, ModItems.ASPECT_OF_RECHARGE);

        if (!hasRecharge) return;

        PlayerSuperAccessor.get(player).setRenewedTicks(140);
    }

    private boolean hasFullStormcallerSet(PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getItem() instanceof ModArcArmorItem &&
                player.getInventory().getArmorStack(1).getItem() instanceof ModArcArmorItem &&
                player.getInventory().getArmorStack(2).getItem() instanceof ModArcArmorItem &&
                player.getInventory().getArmorStack(3).getItem() instanceof ModArcArmorItem;
    }

    @Inject(method = "damage", at = @At("HEAD"), cancellable = true)
    private void fireteamCheck(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir) {
        Entity attackerEntity = source.getAttacker();

        if (attackerEntity == null) return;

        ServerPlayerEntity shooter = null;

        if (attackerEntity instanceof ServerPlayerEntity serverPlayer) {
            shooter = serverPlayer;
        } else if (attackerEntity instanceof ProjectileEntity projectile) {
            if (projectile.getOwner() instanceof ServerPlayerEntity owner) {
                shooter = owner;
            }
        }

        if (shooter != null && (Object)this instanceof ServerPlayerEntity victim) {
            if (FireteamManager.areTeammates(shooter, victim)) {
                cir.setReturnValue(false);
            }
        }
    }


    private static final float BULK_SHIELD_DISABLE_CHANCE = 1.0f / 3.0f;

    @Inject(method = "takeShieldHit", at = @At("HEAD"))
    private void bulkMode(LivingEntity attacker, CallbackInfo ci) {

        if (!(attacker instanceof PlayerEntity player)) return;

        ItemStack stack = player.getMainHandStack();

        if (!(stack.getItem() instanceof BaseHammerItem
                || stack.getItem() instanceof SolHammerItem)) return;

        int bulkLevel = EnchantmentHelper.getLevel(ModEnchantments.BULK, stack);
        if (bulkLevel <= 0) return;

        LivingEntity target = (LivingEntity)(Object)this;

        if (target.getWorld().random.nextFloat() >= BULK_SHIELD_DISABLE_CHANCE) return;

        if (target instanceof PlayerEntity targetPlayer) {
            targetPlayer.disableShield(true);
        }
    }

    @Unique
    private boolean isBondGlowing;

    @Unique
    private int bondGlowTicks;

    @Inject(method = "tick", at = @At("HEAD"))
    private void tickBondGlow(CallbackInfo ci) {
        if (bondGlowTicks > 0) {
            bondGlowTicks--;
            if (bondGlowTicks == 0) {
                isBondGlowing = false;
            }
        }
    }

    @Override
    public void setBondGlow(int ticks) {
        isBondGlowing = true;
        bondGlowTicks = ticks;
    }

    @Override
    public boolean isBondGlowing() {
        return isBondGlowing;
    }

    @Inject(
            method = "damage",
            at = @At("RETURN")
    )
    private void afterDamage(
            DamageSource source,
            float amount,
            CallbackInfoReturnable<Boolean> cir
    ) {
        if (!cir.getReturnValue()) return;

        boolean isArrow = false;
        LivingEntity self = (LivingEntity) (Object) this;
        if (self.getWorld().isClient()) return;
        DamageTracker.onDamageApplied(self, source, amount);
    }
}
