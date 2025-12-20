package com.brandrobkus.sunbreaking.enchantment;

import com.brandrobkus.sunbreaking.Sunbreaking;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {

    public static final Enchantment RECALL = new HammerRecallEnchantment();
    public static final Enchantment BULK = new HammerBulkEnchantment();
    public static final Enchantment BLUDGEONING = new HammerBludgeoningEnchantment();

    public static void registerModEnchantments(){
        Registry.register(Registries.ENCHANTMENT, new Identifier(Sunbreaking.MOD_ID, "recall"), RECALL);
        Registry.register(Registries.ENCHANTMENT, new Identifier(Sunbreaking.MOD_ID, "bulk"), BULK);
        Registry.register(Registries.ENCHANTMENT, new Identifier(Sunbreaking.MOD_ID, "bludgeoning"), BLUDGEONING);
    }
}
