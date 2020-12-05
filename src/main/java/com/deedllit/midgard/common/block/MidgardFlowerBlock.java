package com.deedllit.midgard.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.potion.Effect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.PlantType;

public class MidgardFlowerBlock extends FlowerBlock { 
	
	private PlantType biomeType ; 
	private Block [] allowedOn ; 

	
	public MidgardFlowerBlock(PlantType type, Block allowedOn, Effect effectIn, int effectDuration, Properties properties) {
		this(type, new Block[] {allowedOn}, effectIn, effectDuration, properties);
	}
	
	public MidgardFlowerBlock(PlantType type, Block [] allowedOn, Effect effectIn, int effectDuration, Properties properties) {
		super(effectIn, effectDuration, properties);

		this.allowedOn = allowedOn ; 
		this.biomeType = type ;  
	}
	
	/*
	@Override
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return isAllowed(state, worldIn, pos) ; 
	}
*/

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return this.biomeType ; 
	}
	
	public boolean isAllowed(BlockState state, IBlockReader worldIn, BlockPos pos) {
			
		
		if (worldIn.getBlockState(pos.up()).getBlock() != Blocks.AIR)
			return false ; 
		
		
		for (Block b : allowedOn) {
			
			if(state.getBlock() == b)
				return true ; 
			
		}
		
		return false ; 
	}
	
}
