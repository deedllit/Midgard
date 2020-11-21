package com.deedllit.midgard.common.block.muspelheim;

import com.deedllit.midgard.common.block.YggdrasilFarmBlock;

import net.minecraft.block.Blocks;
import net.minecraft.tags.FluidTags;

public class MuspelheimFarmlandBlock extends YggdrasilFarmBlock {
	
	public MuspelheimFarmlandBlock(Properties builder) {
		super(builder, FluidTags.WATER, Blocks.BIRCH_WOOD.getDefaultState());
	}
			
}
