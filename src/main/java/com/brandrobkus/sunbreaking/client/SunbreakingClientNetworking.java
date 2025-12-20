package com.brandrobkus.sunbreaking.client;

import com.brandrobkus.sunbreaking.util.gui.PlayerSuperAccessor;
import com.brandrobkus.sunbreaking.network.ModNetworking;
import com.brandrobkus.sunbreaking.util.gui.SunbreakingMeterComponent;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;

public class SunbreakingClientNetworking {

    public static void register() {
        ClientPlayNetworking.registerGlobalReceiver(ModNetworking.GEAR_SYNC, (client, handler, buf, responseSender) -> {
            float superValue = buf.readFloat();
            float gearValue = buf.readFloat();
            float invisibilityCooldown = buf.readFloat();

            client.execute(() -> {
                if (client.player != null) {
                    SunbreakingMeterComponent comp = PlayerSuperAccessor.get(client.player);
                    comp.setSuper(superValue);
                    comp.setGear(gearValue);
                    comp.setGear(invisibilityCooldown);
                }
            });
        });
    }
}
