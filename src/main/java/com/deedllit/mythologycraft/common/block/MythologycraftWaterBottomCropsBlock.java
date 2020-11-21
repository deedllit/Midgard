package com.deedllit.mythologycraft.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.deedllit.midgard.Midgard;
import com.deedllit.mythologycraft.util.PlacementHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.IWaterLoggable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class MythologycraftWaterBottomCropsBlock extends MythologycraftExtendableBottomCorp implements ILiquidContainer  {

	private int minDeep ;
	private int maxDeep ; 
	private Block liquid = Blocks.WATER ; 
	
	public MythologycraftWaterBottomCropsBlock(int minDeep, int maxDeep, int minSize, int maxSize, Properties properties, List<Block> canBePlacedOn) {
		super(minSize, maxSize, properties.notSolid(), canBePlacedOn);		

		this.minDeep = minDeep ; 
		this.maxDeep = maxDeep ; 
	}
	
	public MythologycraftWaterBottomCropsBlock(int minDeep, int maxDeep, int minSize, int maxSize, Properties properties, Block [] canBePlacedOn) {
		this(minDeep, maxDeep, minSize, maxSize, properties, Arrays.asList(canBePlacedOn));		
	}
	
	public MythologycraftWaterBottomCropsBlock(Properties properties) {
		this(1, 1, 1, 1, properties, new Block[] {Blocks.SAND, Blocks.DIRT});
	}

	public int getMinDeep() {
		return this.minDeep ; 
	}
	
	public int getMaxDeep() {
		return this.maxDeep ; 
	}

	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		int thisDeep = PlacementHelper.blocksDeep(context) ;
		if(thisDeep >= this.minDeep && thisDeep <= this.maxDeep) 
			return super.getStateForPlacement(context) ;
		
		return null ; 
	}
	
	
	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {			
		//BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
				
				
		//valid bottom
		//blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() - 1, pos.getZ());
		if (!PlacementHelper.blockIsInList(worldIn.getBlockState(pos.down()).getBlock(), this.getPlacableOn()))  {
			return false ; 
		}
		
		Midgard.LOGGER.info("IS VALID");
					
		return true ; 
		
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return true;
	}
	
	/*
	 * ILiquidContainer
	 */
	
	public FluidState getFluidState(BlockState state) {
		return (FluidState) Fluids.WATER.getStillFluidState(false);
	}

	public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
		return false;
	}

	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
		return false;
	}

	@Override
	public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, IFluidState fluidStateIn) {
		return false;
	}
	
}
