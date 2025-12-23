package com.brandrobkus.sunbreaking.event;

import com.brandrobkus.sunbreaking.entity.custom.BaseHammerProjectileEntity;
import com.brandrobkus.sunbreaking.entity.custom.FirelessLightningEntity;
import com.brandrobkus.sunbreaking.entity.custom.ShadowshotArrowEntity;
import com.brandrobkus.sunbreaking.entity.custom.SolHammerProjectileEntity;
import com.brandrobkus.sunbreaking.item.ModItems;
import com.brandrobkus.sunbreaking.item.custom.ModArcArmorItem;
import com.brandrobkus.sunbreaking.item.custom.ModSolarArmorItem;
import com.brandrobkus.sunbreaking.item.custom.ModVoidArmorItem;
import com.brandrobkus.sunbreaking.network.ModNetworking;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import com.brandrobkus.sunbreaking.util.gui.SunbreakingMeterComponent;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.network.ServerPlayerEntity;

public class DamageTracker {

    private DamageTracker() {}

    public static void onDamageApplied(
            LivingEntity target,
            DamageSource source,
            float damage
    ) {
        if (damage <= 0f) return;
        if (!(source.getAttacker() instanceof ServerPlayerEntity player)) return;
        if (player.getWorld().isClient()) return;
        ItemStack chestplate = player.getInventory().getArmorStack(2);

        boolean isArrow =
                source.getSource() instanceof ArrowEntity ||
                        source.getSource() instanceof SpectralArrowEntity ||
                        source.getSource() instanceof ShadowshotArrowEntity;

        boolean isExplosion =
                source.isIn(DamageTypeTags.IS_EXPLOSION) ||
                        source.getSource() instanceof BaseHammerProjectileEntity ||
                        source.getSource() instanceof SolHammerProjectileEntity;

        boolean isLightning =
                source.isIn(DamageTypeTags.IS_LIGHTNING) ||
                        source.getSource() instanceof FirelessLightningEntity;

        if (isArrow) {
            if (!ModVoidArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_HARVEST)) return;
        }
        if (isExplosion) {
            if (!ModSolarArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_BENEVOLENCE)) return;
        }
        if (isLightning) {
            if (!ModArcArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_FREQUENCY)) return;
        }

        if (source.getSource() instanceof PersistentProjectileEntity && !isArrow && !isExplosion) return;
        if (source.getSource() instanceof PotionEntity) return;

        SunbreakingMeterComponent comp = PlayerSuperAccessor.get(player);

        if(ModVoidArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_HARVEST)){
            comp.addSuper(damage/2f);
            comp.addGear(damage);
        } else if (ModSolarArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_BENEVOLENCE)){
            comp.addSuper(damage * 0.66f);
            comp.addGear(damage * 1.33f);
        } else if (ModArcArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_FREQUENCY) && isLightning){
            comp.addSuper(damage/4f);
            comp.addGear(damage/2f);
        } else if (ModArcArmorItem.hasItemInBundle(chestplate, ModItems.ASPECT_OF_FREQUENCY)){
            comp.addSuper(damage * 0.66f);
            comp.addGear(damage * 1.33f);
        }
        else {
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

