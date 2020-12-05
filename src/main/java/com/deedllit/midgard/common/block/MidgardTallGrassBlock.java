package com.deedllit.midgard.common.block;

import java.util.Random;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TallGrassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.PlantType;

public abstract class MidgardTallGrassBlock extends TallGrassBlock {
	
	private PlantType biomeType ; 
	private Block [] allowedOn ; 
	
	public MidgardTallGrassBlock(PlantType type, Block [] allowedOn, Properties properties) {
		super(properties);		

		this.allowedOn = allowedOn ; 
		this.setPlantType(type);
	}
	
	public PlantType getPlantType() {
		return this.biomeType ; 
	}
	

	@Override
	public PlantType getPlantType(IBlockReader world, BlockPos pos) {
		return this.getPlantType(); 
	}
	
	public void setPlantType(PlantType type) {
		this.biomeType = type ;  		
	}
	
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return true;
	}

	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	/*
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		
		return isAllowed(state, worldIn, pos) ; 
		
	}
	 */
	
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
