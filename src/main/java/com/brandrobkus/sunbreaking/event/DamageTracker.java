package com.brandrobkus.sunbreaking.event;

import com.brandrobkus.sunbreaking.network.ModNetworking;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import com.brandrobkus.sunbreaking.util.gui.SunbreakingMeterComponent;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;

public final class DamageTracker {

    private DamageTracker() {}

    public static void onDamageApplied(
            LivingEntity target,
            DamageSource source,
            float damage
    ) {
        if (damage <= 0f) return;
        if (!(source.getAttacker() instanceof ServerPlayerEntity player)) return;
        if (player.getWorld().isClient()) return;

        SunbreakingMeterComponent comp = PlayerSuperAccessor.get(player);

        if (source.getSource() instanceof PersistentProjectileEntity) {
            comp.addSuper(damage * 0.5f);
            comp.addGear(damage);
        } else {
            comp.addSuper(damage);
            comp.addGear(damage * 2f);
        }

        sync(player, comp);
    }

    private static void sync(
            ServerPlayerEntity player,
            SunbreakingMeterComponent comp
    ) {
        PacketByteBuf buf = PacketByteBufs.create();
        buf.writeFloat(comp.getSuper());
        buf.writeFloat(comp.getGear());
        ServerPlayNetworking.send(player, ModNetworking.GEAR_SYNC, buf);
    }
}
