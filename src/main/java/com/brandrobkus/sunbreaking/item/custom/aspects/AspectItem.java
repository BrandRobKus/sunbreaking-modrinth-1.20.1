package com.brandrobkus.sunbreaking.item.custom.aspects;

import com.brandrobkus.sunbreaking.client.ModKeyBindings;
import com.brandrobkus.sunbreaking.item.ModItems;
import com.brandrobkus.sunbreaking.item.weapons.fragments.FragmentItem;
import com.brandrobkus.sunbreaking.util.ModTags;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import net.minecraft.text.Text;

import java.util.List;

public class AspectItem extends Item {
    public AspectItem(Settings settings) {
        super(settings);
    }

    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(stack.isIn(ModTags.Items.SOLAR_ASPECTS)){
            tooltip.add(Text.translatable("tooltip.sunbreaking.sunbreaker_aspect.tooltip").formatted(Formatting.GOLD));
            tooltip.add(Text.translatable("tooltip.sunbreaking.blank_spot.tooltip"));
        }
        if(stack.isIn(ModTags.Items.VOID_ASPECTS)){
            tooltip.add(Text.translatable("tooltip.sunbreaking.nightstalker_aspect.tooltip").formatted(Formatting.DARK_PURPLE));
            tooltip.add(Text.translatable("tooltip.sunbreaking.blank_spot.tooltip"));
        }
        if(stack.isIn(ModTags.Items.ARC_ASPECTS)){
            tooltip.add(Text.translatable("tooltip.sunbreaking.stormcaller_aspect.tooltip").formatted(Formatting.AQUA));
            tooltip.add(Text.translatable("tooltip.sunbreaking.blank_spot.tooltip"));
        }

        if (stack.isOf(ModItems.ASPECT_OF_TEMPERING)) {
            String keyName = ModKeyBindings.TOGGLE_ARMOR_EFFECT.getBoundKeyLocalizedText().getString();
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_tempering.tooltip", keyName));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_tempering.tooltip_1"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_tempering.tooltip_2"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_tempering.tooltip_3").formatted(Formatting.RED));
        }
        if (stack.isOf(ModItems.ASPECT_OF_RADIANCE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_radiance.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_radiance.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_SOLACE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_solace.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_solace.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_RESOLVE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_resolve.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_resolve.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_BENEVOLENCE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_benevolence.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_benevolence.tooltip_1"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_3").formatted(Formatting.RED));
        }

        if (stack.isOf(ModItems.ASPECT_OF_OBSCURITY)) {
            String keyName = ModKeyBindings.TOGGLE_ARMOR_EFFECT.getBoundKeyLocalizedText().getString();
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip", keyName));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_5"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_0"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_1"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_2"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_3").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_obscurity.tooltip_4").formatted(Formatting.RED));
        }
        if (stack.isOf(ModItems.ASPECT_OF_EXECUTION)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_execution.tooltip"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_DILATION)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_dilation.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_dilation.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_RENEWAL)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_renewal.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_renewal.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_HARVEST)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_1"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_3").formatted(Formatting.RED));
        }
        if (stack.isOf(ModItems.ASPECT_OF_SURGE)) {
            String keyName = ModKeyBindings.TOGGLE_ARMOR_EFFECT.getBoundKeyLocalizedText().getString();
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_surge.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_surge.tooltip_1", keyName));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_surge.tooltip_4"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_surge.tooltip_5"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_surge.tooltip_6").formatted(Formatting.RED));
        }
        if (stack.isOf(ModItems.ASPECT_OF_BRILLIANCE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_brilliance.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_brilliance.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_RESISTANCE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_ions.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_ions.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_RECHARGE)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_recharge.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_recharge.tooltip_1"));
        }
        if (stack.isOf(ModItems.ASPECT_OF_FREQUENCY)) {
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_frequency.tooltip"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_frequency.tooltip_1"));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.sunbreaking.aspect_of_harvest.tooltip_3").formatted(Formatting.RED));
        }

        else if (stack.getItem() instanceof FragmentItem
                && !ModItems.REGISTERED_ASPECTS.contains(stack.getItem())) {

            tooltip.add(Text.translatable("tooltip.sunbreaking.unregistered_aspect.tooltip")
                    .formatted(Formatting.YELLOW));
            tooltip.add(Text.translatable("tooltip.sunbreaking.unregistered_aspect.tooltip_1")
                    .formatted(Formatting.YELLOW));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }
}
