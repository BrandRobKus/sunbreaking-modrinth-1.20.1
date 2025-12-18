package com.brandrobkus.sunbreaking.network;

import com.brandrobkus.sunbreaking.item.weapons.BondItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public interface ItemEffectToggleable {
    void onToggleEffect(ItemStack stack, PlayerEntity player);

    default boolean isEffectActive(ItemStack stack) {
        return stack.getOrCreateNbt().getBoolean(BondItem.PRECISION_KEY);
    }
}
