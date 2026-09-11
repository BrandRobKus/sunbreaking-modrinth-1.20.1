package com.brandrobkus.sunbreaking.block;

import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class VoidSurgedTravelerShard extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    public VoidSurgedTravelerShard(Settings settings) {
        super(settings);
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_VOID_REMNANT;
            } else if (blockState.isOf(ModBlocks.SMALL_VOID_REMNANT) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_VOID_REMNANT;
            } else if (blockState.isOf(ModBlocks.MEDIUM_VOID_REMNANT) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_VOID_REMNANT;
            } else if (blockState.isOf(ModBlocks.LARGE_VOID_REMNANT) && blockState.get(AmethystClusterBlock.FACING) == direction) {
                block = ModBlocks.VOID_BURST;
            }

            if (block != null) {
                BlockState blockState2 = (block.getDefaultState().with(AmethystClusterBlock.FACING, direction)).with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }

        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
