package com.brandrobkus.sunbreaking.util;

import com.brandrobkus.sunbreaking.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.TagEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier JUNGLE_TEMPLE_ID =
            new Identifier("minecraft", "chests/jungle_temple");
    private static final Identifier DESERT_PYRAMID_ID =
            new Identifier("minecraft", "chests/desert_pyramid");
    private static final Identifier WOODLAND_MANSION =
            new Identifier("minecraft", "chests/woodland_mansion");
    private static final Identifier BASTION_TREASURE =
            new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier BASTION_OTHER =
            new Identifier("minecraft", "chests/bastion_treasure");
    private static final Identifier NETHER_BRIDGE =
            new Identifier("minecraft", "chests/nether_bridge");
    private static final Identifier RUINED_PORTAL =
            new Identifier("minecraft", "chests/ruined_portal");
    private static final Identifier ANCIENT_CITY =
            new Identifier("minecraft", "chests/ancient_city");
    private static final Identifier END_CITY_TREASURE =
            new Identifier("minecraft", "chests/end_city_treasure");
    public static final Identifier STRONGHOLD_CORRIDOR =
            new Identifier("minecraft", "chests/stronghold_corridor");
    public static final Identifier STRONGHOLD_CROSSING =
            new Identifier("minecraft", "chests/stronghold_crossing");

    public static void modifyLootTables(){
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, identifier, builder, lootTableSource) -> {

            if(JUNGLE_TEMPLE_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.STONE_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(JUNGLE_TEMPLE_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(DESERT_PYRAMID_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.IRON_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(DESERT_PYRAMID_ID.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.IRON_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.DIMINISHED_SOLAR_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FLEETING_VOID_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(WOODLAND_MANSION.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FLICKERING_ARC_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_CORRIDOR.equals(identifier) || STRONGHOLD_CROSSING.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.IRON_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_CORRIDOR.equals(identifier) || STRONGHOLD_CROSSING.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_CORRIDOR.equals(identifier) || STRONGHOLD_CROSSING.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.DIMINISHED_SOLAR_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_CORRIDOR.equals(identifier) || STRONGHOLD_CROSSING.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FLEETING_VOID_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(STRONGHOLD_CORRIDOR.equals(identifier) || STRONGHOLD_CROSSING.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.05f))
                        .with(ItemEntry.builder(ModItems.FLICKERING_ARC_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(BASTION_OTHER.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ModItems.GOLDEN_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            /*if(BASTION_OTHER.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.BLAZING_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(BASTION_OTHER.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.HELLBENT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(BASTION_OTHER.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.FLAT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

             */

            if(BASTION_TREASURE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.45f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(BASTION_TREASURE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.DIMINISHED_SOLAR_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            //solar aspects
            {
                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_BENEVOLENCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_BENEVOLENCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_RESOLVE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_TEMPERING))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_RADIANCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

            //solar fragments
            {
                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_ASHES))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_COMBUSTION))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_BLISTERING))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (BASTION_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_SEARING))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

            /*if(NETHER_BRIDGE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.BLAZING_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(NETHER_BRIDGE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.HELLBENT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(NETHER_BRIDGE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.FLAT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

             */

            if(RUINED_PORTAL.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.GOLD_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(RUINED_PORTAL.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.GOLDEN_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            /*if(RUINED_PORTAL.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.BLAZING_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(RUINED_PORTAL.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.HELLBENT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(RUINED_PORTAL.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.025f))
                        .with(ItemEntry.builder(ModItems.FLAT_APPEARANCE_SMITHING_TEMPLATE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

             */

            if(ANCIENT_CITY.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(ANCIENT_CITY.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(ANCIENT_CITY.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.33f))
                        .with(ItemEntry.builder(ModItems.IRON_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(ANCIENT_CITY.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.FLICKERING_ARC_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            //arc aspects
            {
                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_BRILLIANCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_SURGE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_RESISTANCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_RECHARGE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_FREQUENCY))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

            //arc fragments
            {
                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_FEEDBACK))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_BEACONS))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_SHOCK))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if (ANCIENT_CITY.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_VOLTS))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

            if(END_CITY_TREASURE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.35f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_GLAIVE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(END_CITY_TREASURE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.DIAMOND_HAMMER))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            if(END_CITY_TREASURE.equals(identifier)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.15f))
                        .with(ItemEntry.builder(ModItems.FLEETING_VOID_LIGHT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                builder.pool(poolBuilder.build());
            }

            //void aspects
            {
                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_DILATION))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_EXECUTION))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_OBSCURITY))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_RENEWAL))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.ASPECT_OF_HARVEST))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

            //void fragments
            {
                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_CESSATION))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_EXPULSION))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_INSTABILITY))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }

                if(END_CITY_TREASURE.equals(identifier)) {
                    LootPool.Builder poolBuilder = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1))
                            .conditionally(RandomChanceLootCondition.builder(0.1f))
                            .with(ItemEntry.builder(ModItems.FRAGMENT_OF_VIGILANCE))
                            .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                    builder.pool(poolBuilder.build());
                }
            }

        }));
    }
}
