package com.brandrobkus.sunbreaking.block;

import com.brandrobkus.sunbreaking.Sunbreaking;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block TRAVELER_SHARD = registerBlock("traveler_shard",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(1.5F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));
    public static final Block WEATHERED_TRAVELER_SHARD = registerBlock("weathered_traveler_shard",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.WHITE_GRAY).strength(1.5F).sounds(BlockSoundGroup.STONE).requiresTool()));
    public static final Block ARC_SURGED_TRAVELER_SHARD = registerBlock("arc_surged_traveler_shard",
            new ArcSurgedTravelerShard(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(2.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));
    public static final Block SMALL_ARC_REMNANT = registerBlock("small_arc_remnant",
            new AmethystClusterBlock(6, 4, AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance((state) -> 1).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MEDIUM_ARC_REMNANT = registerBlock("medium_arc_remnant",
            new AmethystClusterBlock(7, 3, AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance((state) -> 4).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LARGE_ARC_REMNANT = registerBlock("large_arc_remnant",
            new AmethystClusterBlock(5, 3, AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance((state) -> 7).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block ARC_BURST = registerBlock("arc_burst",
            new AmethystClusterBlock(7, 3, AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).solid().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5F).luminance((state) -> 10).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block VOID_SURGED_TRAVELER_SHARD = registerBlock("void_surged_traveler_shard",
            new VoidSurgedTravelerShard(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(2.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));
    public static final Block SMALL_VOID_REMNANT = registerBlock("small_void_remnant",
            new AmethystClusterBlock(4, 4, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance((state) -> 1).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MEDIUM_VOID_REMNANT = registerBlock("medium_void_remnant",
            new AmethystClusterBlock(4, 3, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance((state) -> 4).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LARGE_VOID_REMNANT = registerBlock("large_void_remnant",
            new AmethystClusterBlock(5, 3, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance((state) -> 7).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block VOID_BURST = registerBlock("void_burst",
            new AmethystClusterBlock(7, 3, AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).solid().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5F).luminance((state) -> 10).pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block SOLAR_SURGED_TRAVELER_SHARD = registerBlock("solar_surged_traveler_shard",
            new SolarSurgedTravelerShard(AbstractBlock.Settings.create().mapColor(MapColor.WHITE).strength(2.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK).requiresTool()));
    public static final Block SMALL_SOLAR_REMNANT = registerBlock("small_solar_remnant",
            new AmethystClusterBlock(6, 4, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance((state) -> 1).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block MEDIUM_SOLAR_REMNANT = registerBlock("medium_solar_remnant",
            new AmethystClusterBlock(8, 3, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance((state) -> 4).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LARGE_SOLAR_REMNANT = registerBlock("large_solar_remnant",
            new AmethystClusterBlock(9, 3, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).nonOpaque().ticksRandomly().strength(1.5F).sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance((state) -> 7).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block SOLAR_BURST = registerBlock("solar_burst",
            new AmethystClusterBlock(13, 3, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.5F).luminance((state) -> 10).pistonBehavior(PistonBehavior.DESTROY)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Sunbreaking.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(Sunbreaking.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        Sunbreaking.LOGGER.info("Registering ModBlocks for " + Sunbreaking.MOD_ID);
    }
}
