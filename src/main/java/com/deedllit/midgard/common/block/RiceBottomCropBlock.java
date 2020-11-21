package com.deedllit.midgard.common.block;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.mythologycraft.common.block.MythologycraftWaterBottomCropsBlock;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class RiceBottomCropBlock extends MythologycraftWaterBottomCropsBlock {
	public RiceBottomCropBlock(Properties properties, int minDeep, int maxDeep, int minSize, int maxSize, Block[] blocks ) {
		super(minDeep, maxDeep, minSize, maxSize, properties, blocks);
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true ; 
	}
	
	
	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		
		return super.canSustainPlant(state, world, pos, facing, plantable);
	}
		
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {		
		//Not max age
		if( !this.isMaxAge(state) ) {
			return true ; 			
		}
		

		//Max age
    	if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
    		return true ;             
    	}
    	
    	return false ; 
	}	
	
		
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light

		if (worldIn.getLightSubtracted(pos, 0) >= 9) {

			boolean doTick = false;
			float f = getGrowthChance(this, worldIn, pos);
			if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,
					rand.nextInt((int) (25.0F / f) + 1) == 0)) {
				doTick = true;
			}

			int i = this.getAge(state);
			if (i < this.getMaxAge()) {
				// grow bottom
				
				if(doTick) {
					worldIn.setBlockState(pos, this.withAge(i + 1), 2);
					net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);					
				}
				
			} else {
				// grow top
				if(doTick) {
					if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR) {
						

						/*
						Midgard.LOGGER.info( "Bottom - grow top " );	

						BlockState top = BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState() ; 						
						net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up(), top);					
						 */
	
						BlockState top = BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState() ; 												
			            worldIn.setBlockState(pos.up(), top.cycle(AGE));
			            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos.up(), state);
						
						
						//worldIn.setBlockState(pos.up(), BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState(), 2);						
					}
				}
			}
		}
	}
	


	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(AGE, 0);
	}
	
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		Midgard.LOGGER.info("RiceBottomCropBlock - onBlockHarvested");
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		Midgard.LOGGER.info("RiceBottomCropBlock - grow");

		int d = 0 ; 
		
		if(this.getAge(state) != this.getMaxAge()) {
			Midgard.LOGGER.info("RiceBottomCropBlock - grow bottom");
			int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
			int j = this.getMaxAge();			
			if (i > j) {
				d = j - i ;
				i = j;
			}
			
			worldIn.setBlockState(pos, this.withAge(i), 2);			
		}
		
		if(d > 0) {
			Midgard.LOGGER.info("RiceBottomCropBlock - grow top");
			if(worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()) {
				worldIn.setBlockState(pos.up(),  BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState());							
			}
			
		}
	
	}
	
}
