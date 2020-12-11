package com.deedllit.midgard.common.block.fruits;

import com.deedllit.midgard.init.BlockInit;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CocoaBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

public class BananaFruitBlock extends CocoaBlock {

	public BananaFruitBlock(Properties builder) {
		super(builder);
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
      Block block = worldIn.getBlockState(pos.offset(state.get(HORIZONTAL_FACING))).getBlock();
      
      return block == BlockInit.BANANA_LOG.get() ; 
	}
	
}
