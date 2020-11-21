package com.deedllit.mythologycraft.util;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.IWorldReader;

public class PlacementHelper {

	public static boolean isInList(BlockState state, List<Block> blocks) {
		
		for(Block b : blocks){
			
			if(state == b.getDefaultState())			
			//if(state.isIn(b))
				return true ; 
		}
		
		return false  ; 
	}
	
	public static boolean blockIsInList(Block thisBlock, List<Block> blocks) {
		
		for(Block b : blocks){
			if(b == thisBlock)
				return true ; 
		}
		
		return false  ; 
	}
	
	public static int blocksDeep(BlockItemUseContext context) {
		
		int deep = 0 ; 
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		BlockPos pos = context.getPos() ; 
		FluidState fluidState ; 

		while(true) {
			blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() + deep, pos.getZ());
			fluidState = (FluidState) context.getWorld().getFluidState(blockpos$mutableblockpos);
			if (fluidState.isTagged(FluidTags.WATER) && fluidState.getLevel() == 8)
				deep++ ; 
			else 
				return deep; 
		}
		
	}

	public static int blocksDeep(IWorldReader worldIn, BlockPos pos, Block liquid) {

		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		int deep = 0 ; 
			
		while(true) {
			blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() + deep, pos.getZ());

			
			if(worldIn.getBlockState(blockpos$mutableblockpos).getBlock() == liquid || 
					worldIn.getBlockState(blockpos$mutableblockpos).getMaterial() == net.minecraft.block.material.Material.WATER ||
					worldIn.getBlockState(blockpos$mutableblockpos).isSolidSide(worldIn, blockpos$mutableblockpos, Direction.UP)) 
					
			//if(worldIn.getBlockState(blockpos$mutableblockpos).getMaterial() == net.minecraft.block.material.Material.WATER) 
			//if(worldIn.getBlockState(blockpos$mutableblockpos).isSolidSide(worldIn, blockpos$mutableblockpos, Direction.UP)) 
				deep++ ;
			 else 
				return deep ; 
			
			
		}
		
	}
	
	public static int blocksUntilSurface(IWorldReader worldIn, BlockPos pos, Block liquid, Block surface) {
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		int deep = 0 ; 
		int waterHeight = PlacementHelper.blocksDeep(worldIn, pos, liquid) ; 
		
		
		
		//is next is surface  ? 
		if(waterHeight > 0 )  {
			blockpos$mutableblockpos.setPos(pos.getX(), pos.getY() + deep + waterHeight , pos.getZ());
			if(worldIn.getBlockState(blockpos$mutableblockpos).getBlock() == surface)
				return waterHeight ; 
		}
		
		return -1 ;
				
	}
	
}
