package com.brandrobkus.sunbreaking.entity.custom;

import com.brandrobkus.sunbreaking.entity.ModEntities;
import com.brandrobkus.sunbreaking.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StormBallPrecisionEntity extends ThrownItemEntity {

    public StormBallPrecisionEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public StormBallPrecisionEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.PRECISION_STORM_BALL, livingEntity, world);
    }

    @Override
    public void tick() {
        super.tick();
        this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);

    }

    @Override
    protected void onBlockHit(BlockHitResult hit) {
        if (!this.getWorld().isClient) {
            BlockPos pos = this.getBlockPos();
            FirelessLightningEntity lightning = new FirelessLightningEntity(ModEntities.FIRELESS_LIGHTNING, getWorld());
            lightning.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
            if (this.getOwner() instanceof ServerPlayerEntity player) {
                lightning.setOwner(player);
            }
            getWorld().spawnEntity(lightning);
            this.discard();
        }
        super.onBlockHit(hit);
    }

    @Override
    protected void onEntityHit(EntityHitResult hit){
        if (!this.getWorld().isClient) {
            BlockPos pos = this.getBlockPos();
            FirelessLightningEntity lightning = new FirelessLightningEntity(ModEntities.FIRELESS_LIGHTNING, getWorld());
            lightning.refreshPositionAndAngles(pos.getX(), pos.getY(), pos.getZ(), 0, 0);
            if (this.getOwner() instanceof ServerPlayerEntity player) {
                lightning.setOwner(player);
            }
            getWorld().spawnEntity(lightning);
            this.discard();
        }
        super.onEntityHit(hit);

    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.STORM_BALL;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
