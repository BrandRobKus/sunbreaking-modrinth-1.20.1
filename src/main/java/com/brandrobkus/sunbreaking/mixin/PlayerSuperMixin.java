package com.brandrobkus.sunbreaking.mixin;

import com.brandrobkus.sunbreaking.util.gui.SunbreakingMeterComponent;
import com.brandrobkus.sunbreaking.util.gui.PlayerSuperHolder;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class PlayerSuperMixin implements PlayerSuperHolder {

    private final SunbreakingMeterComponent sunbreakingSuper = new SunbreakingMeterComponent();

    @Override
    public SunbreakingMeterComponent sunbreaking_getSuper() {
        return sunbreakingSuper;
    }
}
