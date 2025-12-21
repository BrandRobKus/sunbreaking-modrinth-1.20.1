package com.brandrobkus.sunbreaking.mixin;

import com.brandrobkus.sunbreaking.entity.ModEntities;
import com.brandrobkus.sunbreaking.entity.custom.FirelessLightningEntity;
import com.brandrobkus.sunbreaking.entity.custom.SkyFirelessLightningEntity;
import com.brandrobkus.sunbreaking.item.ModItems;
import com.brandrobkus.sunbreaking.item.custom.ModArcArmorItem;
import com.brandrobkus.sunbreaking.item.custom.aspects.NightstalkingAspectHandler;
import com.brandrobkus.sunbreaking.item.custom.aspects.StormcallingAspectHandler;
import com.brandrobkus.sunbreaking.item.custom.aspects.SunbreakingAspectHandler;
import com.brandrobkus.sunbreaking.item.weapons.GlaiveItem;
import com.brandrobkus.sunbreaking.network.ModNetworking;
import com.brandrobkus.sunbreaking.util.ServerScheduler;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

    @Inject(method = "onKilledOther", at = @At("HEAD"))
    private void onKilledOther(ServerWorld world, LivingEntity victim, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        SunbreakingAspectHandler.handleKill(world, player, victim);
        NightstalkingAspectHandler.handleKill(world, player, victim);
        StormcallingAspectHandler.handleKill(world, player, victim, false);
    }
    @Inject(method = "attack", at = @At("HEAD"))
    private void onAttack(Entity target, CallbackInfo ci) {
        if (!(target instanceof LivingEntity livingTarget)) return;

        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.getWorld().isClient()) return;

        ItemStack chest = player.getInventory().getArmorStack(2);
        if (!(chest.getItem() instanceof ModArcArmorItem arcArmor)) return;

        NbtCompound nbt = chest.getOrCreateNbt();

        boolean speedActive = nbt.getBoolean(ModArcArmorItem.SPEED_ACTIVE);
        boolean hasSurge = ModArcArmorItem.hasItemInBundle(chest, ModItems.ASPECT_OF_SURGE);

        if (!speedActive || !hasSurge) return;

        nbt.putBoolean(ModArcArmorItem.SPEED_ACTIVE, false);
        nbt.putInt(ModArcArmorItem.SPRINT_TIME, 0);

        ServerWorld world = (ServerWorld) player.getWorld();
        LivingEntity trackedTarget = livingTarget;
        player.removeStatusEffect(StatusEffects.SPEED);

        ServerScheduler.schedule(15, () -> {
            if (world.isClient()) return;
            if (trackedTarget == null || trackedTarget.isRemoved() || trackedTarget.isDead()) return;

            double x = trackedTarget.getX();
            double y = trackedTarget.getY();
            double z = trackedTarget.getZ();

            FirelessLightningEntity lightning = ModEntities.FIRELESS_LIGHTNING.create(world);
            if (lightning != null) {
                lightning.refreshPositionAfterTeleport(x, y, z);
                if (player instanceof ServerPlayerEntity serverPlayer) {
                    lightning.setOwner(serverPlayer);
                }
                world.spawnEntity(lightning);
            }
            if (!(player instanceof ServerPlayerEntity serverPlayer)) return;
            PlayerSuperAccessor.get(player).addSuper(-12.5f);
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeFloat(PlayerSuperAccessor.get(player).getSuper());
            buf.writeFloat(PlayerSuperAccessor.get(player).getGear());
            ServerPlayNetworking.send(serverPlayer, ModNetworking.GEAR_SYNC, buf);
        });
    }
}
