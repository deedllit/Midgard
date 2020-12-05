package com.deedllit.midgard.common.block.midgard;

import com.deedllit.midgard.common.block.MidgardTallGrassBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class YggdrasilGrass extends MidgardTallGrassBlock {

	
	public YggdrasilGrass(PlantType type, Block [] allowedOn, Properties properties) {
		super(type, allowedOn, properties);		
	}
	
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return isAllowed(state, worldIn, pos) ; 
	}
}
