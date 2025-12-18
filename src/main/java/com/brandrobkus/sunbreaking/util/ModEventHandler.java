package com.brandrobkus.sunbreaking.util;

import com.brandrobkus.sunbreaking.item.custom.ModVoidArmorItem;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;

public class ModEventHandler {
    public static void register() {
        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (player instanceof PlayerEntity) {
                if (ModVoidArmorItem.hasFullSuitOfArmorOn(player)) {
                    ModVoidArmorItem.onEntityHit(player);
                }
            }
            return ActionResult.PASS;
        });
    }
}
