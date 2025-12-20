package com.brandrobkus.sunbreaking.entity.custom;

import com.brandrobkus.sunbreaking.entity.ModEntities;
import com.brandrobkus.sunbreaking.item.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class HammerExplosiveChunkEntity extends ThrownItemEntity {

    public HammerExplosiveChunkEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public HammerExplosiveChunkEntity(LivingEntity livingEntity, World world) {
        super(ModEntities.HAMMER_EXPLOSIVE_CHUNK, livingEntity, world);
    }

    @Override
    public void tick() {
        super.tick();
        this.getWorld().addParticle(ParticleTypes.WHITE_ASH, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        this.getWorld().addParticle(ParticleTypes.SMALL_FLAME, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        this.getWorld().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        this.getWorld().addParticle(ParticleTypes.LARGE_SMOKE, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        this.getWorld().addParticle(ParticleTypes.LAVA, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
    }

    @Override
    protected void onBlockHit(BlockHitResult hit) {
        if (!this.getWorld().isClient) {
            triggerExplosion();
            this.discard();
        }
        super.onBlockHit(hit);
    }

    @Override
    protected void onEntityHit(EntityHitResult hit){
        if (!this.getWorld().isClient) {
            triggerExplosion();
            this.discard();
        }
        super.onEntityHit(hit);

    }

    private float explosionRadius = 1.5f;

    public void setExplosionRadius(float radius) {
        this.explosionRadius = radius;
    }

    private void triggerExplosion() {
        if (!this.getWorld().isClient()) {
            BlockPos pos = this.getBlockPos();

            this.getWorld().createExplosion(
                    this,
                    pos.getX(),
                    pos.getY(),
                    pos.getZ(),
                    this.explosionRadius,
                    false,
                    World.ExplosionSourceType.NONE
            );
        }
    }


    @Override
    protected void initDataTracker() {
        super.initDataTracker();
    }

    @Override
    protected Item getDefaultItem() {
        return Items.FIRE_CHARGE;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }
}
