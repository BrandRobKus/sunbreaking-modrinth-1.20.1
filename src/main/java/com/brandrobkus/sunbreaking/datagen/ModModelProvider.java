package com.brandrobkus.sunbreaking.datagen;


import com.brandrobkus.sunbreaking.block.ModBlocks;
import com.brandrobkus.sunbreaking.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TRAVELER_SHARD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_TRAVELER_SHARD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOLAR_SURGED_TRAVELER_SHARD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ARC_SURGED_TRAVELER_SHARD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VOID_SURGED_TRAVELER_SHARD);

        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_SOLAR_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_SOLAR_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_SOLAR_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SOLAR_BURST);

        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_ARC_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_ARC_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_ARC_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.ARC_BURST);

        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_VOID_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_VOID_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_VOID_REMNANT);
        blockStateModelGenerator.registerAmethyst(ModBlocks.VOID_BURST);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.STORM_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIMINISHED_SOLAR_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLEETING_VOID_LIGHT, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLICKERING_ARC_LIGHT, Models.GENERATED);

        itemModelGenerator.register(ModItems.ASPECT_OF_TEMPERING, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_RADIANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_SOLACE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_RESOLVE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_BENEVOLENCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.ASPECT_OF_OBSCURITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_EXECUTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_DILATION, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_RENEWAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_HARVEST, Models.GENERATED);

        itemModelGenerator.register(ModItems.ASPECT_OF_SURGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_BRILLIANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_RESISTANCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_RECHARGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ASPECT_OF_FREQUENCY, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRAGMENT_OF_COMBUSTION, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_BLISTERING, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_ASHES, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_SEARING, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRAGMENT_OF_EXPULSION, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_CESSATION, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_INSTABILITY, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_VIGILANCE, Models.GENERATED);

        itemModelGenerator.register(ModItems.FRAGMENT_OF_SHOCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_VOLTS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_FEEDBACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRAGMENT_OF_BEACONS, Models.GENERATED);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SUNBREAKERS_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SUNBREAKERS_CUIRASS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SUNBREAKERS_GREAVES));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.SUNBREAKERS_BOOTS));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NIGHTSTALKERS_MASK));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NIGHTSTALKERS_JACKET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NIGHTSTALKERS_PANTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.NIGHTSTALKERS_STRIDES));

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STORMCALLERS_HEADDRESS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STORMCALLERS_ROBES));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STORMCALLERS_PANTS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.STORMCALLERS_STEPS));
    }
}
