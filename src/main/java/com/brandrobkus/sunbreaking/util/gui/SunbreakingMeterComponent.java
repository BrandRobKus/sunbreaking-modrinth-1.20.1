package com.brandrobkus.sunbreaking.util.gui;

public class SunbreakingMeterComponent {
    private float superValue = 0f;
    private float gearValue = 0f;
    private float invisibilityCooldown = 0f;

    public void addSuper(float amount) {
        superValue += amount;
        if (superValue > 100f) superValue = 100f;
        if (superValue < 0f) superValue = 0f;
    }

    public void addGear(float amount) {
        gearValue += amount;
        if (gearValue > 100f) gearValue = 100f;
        if (gearValue < 0f) gearValue = 0f;
    }

    public void addInvisibilityCooldown(float amount) {
        invisibilityCooldown += amount;
        if (invisibilityCooldown > 100f) invisibilityCooldown = 100f;
        if (invisibilityCooldown < 0f) invisibilityCooldown = 0f;
    }

    public float getSuper() { return superValue; }
    public float getGear()  { return gearValue; }
    public float getInvisibilityCooldown()  { return invisibilityCooldown; }

    public void setSuper(float value) {
        superValue = Math.max(0, Math.min(value, 100));
    }
    public void setGear(float value) {
        gearValue = Math.max(0, Math.min(value, 100));
    }
    public void setInvisibilityCooldown(float value) {
        invisibilityCooldown = Math.max(0, Math.min(value, 100));
    }

    private int resolveTicks = 0;
    public int getResolveTicks() {
        return resolveTicks;
    }
    public void setResolveTicks(int ticks) {
        this.resolveTicks = ticks;
    }

    private int renewedTicks = 0;
    public int getRenewedTicks() {
        return renewedTicks;
    }
    public void setRenewedTicks(int ticks) {
        this.renewedTicks = ticks;
    }

    private int rechargeTicks = 0;
    public int getRechargeTicks() {
        return rechargeTicks;
    }
    public void setRechargeTicks(int ticks) {
        this.rechargeTicks = ticks;
    }

}
