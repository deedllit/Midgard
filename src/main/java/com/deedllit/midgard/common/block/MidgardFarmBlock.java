package com.deedllit.midgard.common.block;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FarmlandBlock;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.Tag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class MidgardFarmBlock extends FarmlandBlock {

	private static Tag<Fluid> fluidTag ; 
	private static BlockState turnIntoBlock ; 
	
	public MidgardFarmBlock(Properties builder, Tag<Fluid> fluid, BlockState turnInto) {
		super(builder);
		MidgardFarmBlock.fluidTag = fluid ; 
		MidgardFarmBlock.turnIntoBlock = turnInto ; 
	}

	private static boolean hasLiquid(IWorldReader worldIn, BlockPos pos) {
		for(BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
			if (worldIn.getFluidState(blockpos).isTagged(fluidTag)) {
				return true;
			}
		}
			
		return false ; 
	}
	
	@Override 
	public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
		if (!worldIn.isRemote && net.minecraftforge.common.ForgeHooks.onFarmlandTrample(worldIn, pos, Blocks.DIRT.getDefaultState(), fallDistance, entityIn)) { // Forge: Move logic to Entity#canTrample
			turnToDirt(worldIn.getBlockState(pos), worldIn, pos);
			}

		super.onFallenUpon(worldIn, pos, entityIn, fallDistance);
	}
	
	public static void turnToDirt(BlockState state, World worldIn, BlockPos pos) {
		worldIn.setBlockState(pos, nudgeEntitiesWithNewState(state, MidgardFarmBlock.turnIntoBlock, worldIn, pos));
	}
	
	private boolean hasCrops(IBlockReader worldIn, BlockPos pos) {
		BlockState state = worldIn.getBlockState(pos.up());
		return state.getBlock() instanceof net.minecraftforge.common.IPlantable && canSustainPlant(state, worldIn, pos, Direction.UP, (net.minecraftforge.common.IPlantable)state.getBlock());
	}
	
	@Override 
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		if (!state.isValidPosition(worldIn, pos)) {
			turnToDirt(state, worldIn, pos);
		} else {
			int i = state.get(MOISTURE);
			if (!hasLiquid(worldIn, pos) && !worldIn.isRainingAt(pos.up())) {
				if (i > 0) {
					worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(i - 1)), 2);
				} else if (!hasCrops(worldIn, pos)) { 
					turnToDirt(state, worldIn, pos);
				}
			}  else if (i < 7) {
				worldIn.setBlockState(pos, state.with(MOISTURE, Integer.valueOf(7)), 2);
			}
		}
	}
	
	
}
