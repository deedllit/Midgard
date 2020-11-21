package com.deedllit.mythologycraft.common.block;

import java.util.List;
import java.util.Random;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

public class MythologycraftExtendableBottomCorp extends MythologycraftExtendableCorp {

	public int minSize ; 
	public int maxSize ; 
	
	public MythologycraftExtendableBottomCorp(int minSize, int maxSize, Properties builder, List<Block> canBePlacedOn) {
		super(builder, canBePlacedOn);
	}
	
	
	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {		
		super.grow(worldIn, rand, pos, state);

		BlockState upperBlock = worldIn.getBlockState(pos.up());
		
		if( this.getAge(state) <= this.getMaxAge() - 1) {
			Midgard.LOGGER.info("Self growing");
			super.grow(worldIn, pos, state);
		} else {
			if(upperBlock.getBlock() == Blocks.AIR && this.getTopBlock() != null) {
				Midgard.LOGGER.info("Can grow top");
				super.grow(worldIn, pos, state);
			} else if(upperBlock.getBlock() ==  this.getTopBlock() && ((MythologycraftExtendableCorp) upperBlock.getBlock()).isMaxAge(upperBlock)) {
				Midgard.LOGGER.info("Top max");
				//super.grow(worldIn, pos, state);				
			}
		}
			
		

		
		
		//return this.getAge(state) <= this.getMaxAge() - 1 ? true : upperBlock.getBlock() == Blocks.AIR ? true : upperBlock.getBlock() == this.getTopBlock() && !((YggdrasilExtendableCorp) upperBlock.getBlock()).isMaxAge(upperBlock);
		
	}
	
	
	/*
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		Midgard.LOGGER.info("MythologycraftExtendableBottomCorp - canGrow");
		
		//ServerWorld world = (ServerWorld) worldIn ; 
		
    	if (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR)
    	{
    		
    		//worldIn.setBlockState(pos.up(), BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState());
            //worldIn.setBlockState(pos, this.withAge(this.getMaxAge()), 2);
            
    	}
    	
		return super.canGrow(worldIn, pos, state, isClient);
	}
	*/
}
