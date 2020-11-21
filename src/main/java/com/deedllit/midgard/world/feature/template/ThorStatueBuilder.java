package com.deedllit.midgard.world.feature.template;

import java.util.Random;

import com.deedllit.midgard.util.holder.BlockStatePosHolder;
import com.deedllit.midgard.util.holder.PreBuildBlockStateHolder;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;

public class ThorStatueBuilder {

	   private static final BlockStateMatcher IS_GRASS = BlockStateMatcher.forBlock(Blocks.GRASS_BLOCK);
	   
	   private PreBuildBlockStateHolder blockStateHolder ; 
	   private final BlockState[] base = {Blocks.STONE_BRICKS.getDefaultState(), Blocks.STONE_BRICK_STAIRS.getDefaultState()};
	   private final BlockState[] base_stairs = {Blocks.STONE_BRICK_STAIRS.getDefaultState(), Blocks.COBBLESTONE_STAIRS.getDefaultState()};

	
	private boolean checkPos(IWorld worldIn, BlockPos pos, long x, long y, long z, BlockState newBlock, boolean needBeEmtpy) {
		if(needBeEmtpy) {
			if(worldIn.getBlockState(pos.add(x , y , z)) != Blocks.AIR.getDefaultState())  {
				return false  ;   
				}			   
			}
		   
		blockStateHolder.add(x, y, z, newBlock);
		return true ;
		}
	
	public boolean place(IWorld worldIn, Random rand, BlockPos pos) {
		int dir = rand.nextInt(4) ; 	    	  
		int baseBlock = rand.nextInt(base.length) ; 
		  
		blockStateHolder = new PreBuildBlockStateHolder() ; 
		  
		for(pos = pos.up(); worldIn.isAirBlock(pos) && pos.getY() > 2; pos = pos.down()) {
			;
	    }

	    if (!IS_GRASS.test(worldIn.getBlockState(pos))) 
	    	return false;		
		
		
	    
	    //Base	    
  	  	for(int x = 0 ; x <= 7 ; x++) {
  	  		for(int y = 0 ; y <= 7 ; y++) {
  	  			if(x == 0 || y == 0 || x == 6 || y == 6)
	  	  			if(!checkPos(worldIn, pos, x, 1, y, this.base_stairs[baseBlock], false))
	  	  				return false ; 
  	  			else
	  	  			if(!checkPos(worldIn, pos, x, 1, y, this.base[baseBlock], false))
	  	  				return false ; 
  	  		}
  	  	}
		
  	  	//RENDER ALL BLOCKS
  	  	for(BlockStatePosHolder b : blockStateHolder.getList()) {	  
  	  		worldIn.setBlockState(pos.add(b.getX(), b.getY(), b.getZ()), b.getBlockState(), 2) ; 
  	  	}
  	  	
		return true ; 
	}


		
	
}
