package com.brandrobkus.sunbreaking.item;

import com.brandrobkus.sunbreaking.Sunbreaking;
import com.brandrobkus.sunbreaking.item.custom.*;
import com.brandrobkus.sunbreaking.item.custom.aspects.AspectItem;
import com.brandrobkus.sunbreaking.item.weapons.*;
import com.brandrobkus.sunbreaking.item.weapons.fragments.FragmentItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;

public class ModItems {

    public static final Item HAMMER_OF_SOL = registerItem("hammer_of_sol",
            new SolHammerItem(ModToolMaterials.SOLAR, 4, -2.8F, new Item.Settings()));
    /*public static final Item BLAZING_HAMMER = registerItem("blazing_hammer_of_sol",
            new SolHammerItem(ModToolMaterials.SOLAR, 4, -2.8F, new Item.Settings()));
    public static final Item HELLBENT_HAMMER = registerItem("hellbent_hammer_of_sol",
            new SolHammerItem(ModToolMaterials.SOLAR, 4, -2.8F, new Item.Settings()));
    public static final Item FLAT_HAMMER = registerItem("2d_hammer_of_sol",
            new SolHammerItem(ModToolMaterials.SOLAR, 4, -2.8F, new Item.Settings()));

     */

    public static final Item FRAGMENT_OF_COMBUSTION = registerItem("fragment_of_combustion",
            new FragmentItem(new FabricItemSettings().maxCount(6)));
    public static final Item FRAGMENT_OF_BLISTERING = registerItem("fragment_of_blistering",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_ASHES = registerItem("fragment_of_ashes",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_SEARING = registerItem("fragment_of_searing",
            new FragmentItem(new FabricItemSettings().maxCount(4)));

    public static final Item WOODEN_HAMMER = registerItem("wooden_hammer",
            new BaseHammerItem(ToolMaterials.WOOD, 4, -2.8F, new Item.Settings()));
    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new BaseHammerItem(ToolMaterials.STONE, 4, -2.8F, new Item.Settings()));
    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new BaseHammerItem(ToolMaterials.IRON, 4, -2.8F, new Item.Settings()));
    public static final Item GOLDEN_HAMMER = registerItem("golden_hammer",
            new BaseHammerItem(ToolMaterials.GOLD, 4, -2.8F, new Item.Settings()));
    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new BaseHammerItem(ToolMaterials.DIAMOND, 4, -2.8F, new Item.Settings()));
    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new BaseHammerItem(ToolMaterials.NETHERITE, 4, -2.8F, new Item.Settings()));

    public static final Item SOLAR_LIGHT = registerItem("solar_light",
            new Item(new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item DIMINISHED_SOLAR_LIGHT = registerItem("diminished_solar_light",
            new Item(new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item SOLAR_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "solar_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.solar_upgrade_template.title"),
                    Text.translatable("item.sunbreaking.solar_upgrade_template.base_slot").formatted(Formatting.GOLD),
                    Text.translatable("item.sunbreaking.solar_upgrade_template.addition_slot"),
                    Text.translatable("item.sunbreaking.solar_upgrade_template.apply"),
                    Text.translatable("item.sunbreaking.solar_upgrade_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));

    /*
    public static final Item HAMMER_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "hammer_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.hammer_appearance_template.title").formatted(Formatting.GOLD),
                    Text.translatable("item.sunbreaking.hammer_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.hammer_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.hammer_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.hammer_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item BLAZING_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "blazing_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.blazing_appearance_template.title").formatted(Formatting.GOLD),
                    Text.translatable("item.sunbreaking.blazing_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.blazing_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.blazing_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.blazing_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item HELLBENT_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "hellbent_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.hellbent_appearance_template.title").formatted(Formatting.GOLD),
                    Text.translatable("item.sunbreaking.hellbent_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.hellbent_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.hellbent_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.hellbent_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item FLAT_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "flat_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.flat_appearance_template.title").formatted(Formatting.GOLD),
                    Text.translatable("item.sunbreaking.flat_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.flat_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.flat_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.flat_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));

     */

    public static final Item SUNBREAKERS_HELMET = registerItem("sunbreakers_helmet",
            new ModSolarArmorItem(ModArmorMaterials.SOLAR, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item SUNBREAKERS_CUIRASS = registerItem("sunbreakers_cuirass",
            new ModSolarArmorItem(ModArmorMaterials.SOLAR, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item SUNBREAKERS_GREAVES = registerItem("sunbreakers_greaves",
            new ModSolarArmorItem(ModArmorMaterials.SOLAR, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item SUNBREAKERS_BOOTS = registerItem("sunbreakers_boots",
            new ModSolarArmorItem(ModArmorMaterials.SOLAR, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item ASPECT_OF_TEMPERING = registerItem("aspect_of_tempering",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_RADIANCE = registerItem("aspect_of_radiance",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_SOLACE = registerItem("aspect_of_solace",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_RESOLVE = registerItem("aspect_of_resolve",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_BENEVOLENCE = registerItem("aspect_of_benevolence",
            new AspectItem(new FabricItemSettings().maxCount(1)));

    public static final Item SHADOWSHOT_BOW = registerItem("shadowshot_bow",
            new ShadowshotBowItem(new FabricItemSettings().maxDamage(500)));
    /*public static final Item WOODCARVED_SHADOWSHOT_BOW = registerItem("woodcarved_shadowshot_bow",
            new ShadowshotBowItem(new FabricItemSettings().maxDamage(500)));
    public static final Item VANILLA_SHADOWSHOT_BOW = registerItem("vanilla_shadowshot_bow",
            new ShadowshotBowItem(new FabricItemSettings().maxDamage(500)));
    public static final Item ENDER_SHADOWSHOT_BOW = registerItem("ender_shadowshot_bow",
            new ShadowshotBowItem(new FabricItemSettings().maxDamage(500)));

     */

    public static final Item FRAGMENT_OF_EXPULSION = registerItem("fragment_of_expulsion",
            new FragmentItem(new FabricItemSettings().maxCount(4)));
    public static final Item FRAGMENT_OF_INSTABILITY = registerItem("fragment_of_instability",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_CESSATION = registerItem("fragment_of_cessation",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_VIGILANCE = registerItem("fragment_of_vigilance",
            new FragmentItem(new FabricItemSettings().maxCount(4)));

    /*public static final Item SHADOWSHOT_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "shadowshot_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.shadowshot_appearance_template.title").formatted(Formatting.DARK_PURPLE),
                    Text.translatable("item.sunbreaking.shadowshot_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.shadowshot_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.shadowshot_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.shadowshot_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item WOODCARVED_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "woodcarved_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.woodcarved_appearance_template.title").formatted(Formatting.DARK_PURPLE),
                    Text.translatable("item.sunbreaking.woodcarved_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.woodcarved_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.woodcarved_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.woodcarved_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item VANILLA_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "vanilla_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.vanilla_appearance_template.title").formatted(Formatting.DARK_PURPLE),
                    Text.translatable("item.sunbreaking.vanilla_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.vanilla_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.vanilla_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.vanilla_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));
    public static final Item ENDER_APPEARANCE_SMITHING_TEMPLATE = registerItem(
            "ender_appearance_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.ender_appearance_template.title").formatted(Formatting.DARK_PURPLE),
                    Text.translatable("item.sunbreaking.ender_appearance_template.base_slot"),
                    Text.translatable("item.sunbreaking.ender_appearance_template.addition_slot"),
                    Text.translatable("item.sunbreaking.ender_appearance_template.apply"),
                    Text.translatable("item.sunbreaking.ender_appearance_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot"))));

     */

    public static final Item SHADOWSHOT_ARROW = registerItem("shadowshot_arrow",
            new ShadowshotArrowItem(new FabricItemSettings()));

    public static final Item VOID_LIGHT = registerItem("void_light", new Item(new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item FLEETING_VOID_LIGHT = registerItem("fleeting_void_light", new Item(new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item VOID_LIGHT_SHARD = registerItem("void_light_shard", new Item(new FabricItemSettings()));
    public static final Item VOID_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "void_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.void_upgrade_template.title"),
                    Text.translatable("item.sunbreaking.void_upgrade_template.base_slot").formatted(Formatting.DARK_PURPLE),
                    Text.translatable("item.sunbreaking.void_upgrade_template.addition_slot"),
                    Text.translatable("item.sunbreaking.void_upgrade_template.apply"),
                    Text.translatable("item.sunbreaking.void_upgrade_template.base"),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/addition_slot_bow")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot_void"))));

    public static final Item NIGHTSTALKERS_MASK = registerItem("nightstalkers_mask",
            new ModVoidArmorItem(ModArmorMaterials.VOID, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item NIGHTSTALKERS_JACKET = registerItem("nightstalkers_jacket",
            new ModVoidArmorItem(ModArmorMaterials.VOID, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item NIGHTSTALKERS_PANTS = registerItem("nightstalkers_pants",
            new ModVoidArmorItem(ModArmorMaterials.VOID, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item NIGHTSTALKERS_STRIDES = registerItem("nightstalkers_strides",
            new ModVoidArmorItem(ModArmorMaterials.VOID, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item ASPECT_OF_OBSCURITY = registerItem("aspect_of_obscurity",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_EXECUTION = registerItem("aspect_of_execution",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_DILATION = registerItem("aspect_of_dilation",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_RENEWAL = registerItem("aspect_of_renewal",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_HARVEST = registerItem("aspect_of_harvest",
            new AspectItem(new FabricItemSettings().maxCount(1)));

    public static final Item SMOKE_BOMB = registerItem("smoke_bomb",
            new SmokeBombItem(new FabricItemSettings().maxCount(16)));

    public static final Item STORMCALLERS_BOND = registerItem("stormcallers_bond",
            new BondItem(new FabricItemSettings().maxCount(1)));

    public static final Item FRAGMENT_OF_SHOCK = registerItem("fragment_of_shock",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_VOLTS = registerItem("fragment_of_volts",
            new FragmentItem(new FabricItemSettings().maxCount(2)));
    public static final Item FRAGMENT_OF_FEEDBACK = registerItem("fragment_of_feedback",
            new FragmentItem(new FabricItemSettings().maxCount(1)));
    public static final Item FRAGMENT_OF_BEACONS = registerItem("fragment_of_beacons",
            new FragmentItem(new FabricItemSettings().maxCount(4)));
    public static final Item STORM_BALL = registerItem("storm_ball",
            new StormBallItem(new FabricItemSettings()));

    public static final Item ARC_LIGHT = registerItem("arc_light",
            new Item(new FabricItemSettings().maxCount(16).fireproof()));
    public static final Item FLICKERING_ARC_LIGHT = registerItem("flickering_arc_light",
            new Item(new FabricItemSettings().maxCount(16).fireproof()));

    public static final Item ARC_UPGRADE_SMITHING_TEMPLATE = registerItem(
            "arc_upgrade_smithing_template",
            new SmithingTemplateItem(
                    Text.translatable("item.sunbreaking.arc_upgrade_template.title"),
                    Text.translatable("item.sunbreaking.arc_upgrade_template.base_slot").formatted(Formatting.AQUA),
                    Text.translatable("item.sunbreaking.arc_upgrade_template.addition_slot"),
                    Text.translatable("item.sunbreaking.arc_upgrade_template.apply"),
                    Text.translatable("item.sunbreaking.arc_upgrade_template.base"),
                    List.of(new Identifier("minecraft", "item/empty_armor_slot_helmet")),
                    List.of(new Identifier(Sunbreaking.MOD_ID, "item/base_slot_arc"))));

    public static final Item STORMCALLERS_HEADDRESS = registerItem("stormcallers_headdress",
            new ModArcArmorItem(ModArmorMaterials.ARC, ArmorItem.Type.HELMET, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item STORMCALLERS_ROBES = registerItem("stormcallers_robes",
            new ModArcArmorItem(ModArmorMaterials.ARC, ArmorItem.Type.CHESTPLATE, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item STORMCALLERS_PANTS = registerItem("stormcallers_pants",
            new ModArcArmorItem(ModArmorMaterials.ARC, ArmorItem.Type.LEGGINGS, new FabricItemSettings().maxCount(1).fireproof()));
    public static final Item STORMCALLERS_STEPS = registerItem("stormcallers_steps",
            new ModArcArmorItem(ModArmorMaterials.ARC, ArmorItem.Type.BOOTS, new FabricItemSettings().maxCount(1).fireproof()));

    public static final Item ASPECT_OF_SURGE = registerItem("aspect_of_surge",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_BRILLIANCE = registerItem("aspect_of_brilliance",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_RESISTANCE = registerItem("aspect_of_resistance",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_RECHARGE = registerItem("aspect_of_recharge",
            new AspectItem(new FabricItemSettings().maxCount(1)));
    public static final Item ASPECT_OF_FREQUENCY = registerItem("aspect_of_frequency",
            new AspectItem(new FabricItemSettings().maxCount(1)));

    public static final Item WOODEN_GLAIVE = registerItem("wooden_glaive",
            new GlaiveItem(ToolMaterials.WOOD, 4, -2.8F, new Item.Settings()));
    public static final Item STONE_GLAIVE = registerItem("stone_glaive",
            new GlaiveItem(ToolMaterials.STONE, 4, -2.8F, new Item.Settings()));
    public static final Item IRON_GLAIVE = registerItem("iron_glaive",
            new GlaiveItem(ToolMaterials.IRON, 4, -2.8F, new Item.Settings()));
    public static final Item GOLD_GLAIVE = registerItem("gold_glaive",
            new GlaiveItem(ToolMaterials.GOLD, 4, -2.8F, new Item.Settings()));
    public static final Item DIAMOND_GLAIVE = registerItem("diamond_glaive",
            new GlaiveItem(ToolMaterials.DIAMOND, 4, -2.8F, new Item.Settings()));
    public static final Item NETHERITE_GLAIVE = registerItem("netherite_glaive",
            new GlaiveItem(ToolMaterials.NETHERITE, 4, -2.8F, new Item.Settings().fireproof()));

    public static final Set<Item> REGISTERED_ASPECTS = Set.of(
            ModItems.ASPECT_OF_TEMPERING,
            ModItems.ASPECT_OF_RADIANCE,
            ModItems.ASPECT_OF_SOLACE,
            ModItems.ASPECT_OF_RESOLVE,
            ModItems.ASPECT_OF_BENEVOLENCE,

            ModItems.ASPECT_OF_DILATION,
            ModItems.ASPECT_OF_EXECUTION,
            ModItems.ASPECT_OF_OBSCURITY,
            ModItems.ASPECT_OF_RENEWAL,
            ModItems.ASPECT_OF_HARVEST,

            ModItems.ASPECT_OF_BRILLIANCE,
            ModItems.ASPECT_OF_SURGE,
            ModItems.ASPECT_OF_RESISTANCE,
            ModItems.ASPECT_OF_RECHARGE,
            ModItems.ASPECT_OF_FREQUENCY
    );

    public static final Set<Item> REGISTERED_FRAGMENTS = Set.of(
            ModItems.FRAGMENT_OF_COMBUSTION,
            ModItems.FRAGMENT_OF_BLISTERING,
            ModItems.FRAGMENT_OF_ASHES,
            ModItems.FRAGMENT_OF_SEARING,

            ModItems.FRAGMENT_OF_EXPULSION,
            ModItems.FRAGMENT_OF_INSTABILITY,
            ModItems.FRAGMENT_OF_CESSATION,
            ModItems.FRAGMENT_OF_VIGILANCE,

            ModItems.FRAGMENT_OF_SHOCK,
            ModItems.FRAGMENT_OF_VOLTS,
            ModItems.FRAGMENT_OF_FEEDBACK,
            ModItems.FRAGMENT_OF_BEACONS
    );

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Sunbreaking.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Sunbreaking.LOGGER.info("Registering Mod Items for " + Sunbreaking.MOD_ID);
    }
}
