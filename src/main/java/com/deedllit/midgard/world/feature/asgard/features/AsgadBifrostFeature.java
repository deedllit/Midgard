package com.deedllit.midgard.world.feature.asgard.features;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.util.holder.BlockStatePosHolder;
import com.deedllit.midgard.util.holder.PreBuildBlockStateHolder;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class AsgadBifrostFeature extends Feature<NoFeatureConfig> {
	   private static final BlockStateMatcher IS_GRASS = BlockStateMatcher.forBlock(Blocks.GRASS_BLOCK);
	   
	   private PreBuildBlockStateHolder blockStateHolder ; 
	   
	   private final BlockState base = Blocks.COBBLESTONE.getDefaultState();
	   private final BlockState portal = Blocks.GOLD_BLOCK.getDefaultState();

	   private final BlockState [] rainbow = {
			   Blocks.RED_TERRACOTTA.getDefaultState(),
			   Blocks.ORANGE_TERRACOTTA.getDefaultState(),
			   Blocks.YELLOW_TERRACOTTA.getDefaultState(),
			   Blocks.GREEN_TERRACOTTA.getDefaultState(),
			   Blocks.BLUE_TERRACOTTA.getDefaultState(),
			   Blocks.PURPLE_TERRACOTTA.getDefaultState(),
			   Blocks.PINK_TERRACOTTA.getDefaultState()
	   };

	   public AsgadBifrostFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> p_i49887_1_) {
	      super(p_i49887_1_);
	   }

	   	   
	   private boolean checkPos(IWorld worldIn, BlockPos pos, long x, long y, long z, BlockState newBlock, boolean needBeEmtpy) {

		   if(needBeEmtpy) {
			   if(worldIn.getBlockState(pos.add(x , y , z)) != Blocks.AIR.getDefaultState())  {
				   return false  ;   
			   }			   
		   }
		   
		   
		   blockStateHolder.add(x, y, z, newBlock);
		   return true ;
	   }
	   
	   public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
		  int dir = rand.nextInt(4) ; 	    	  
		  
		  blockStateHolder = new PreBuildBlockStateHolder() ; 
		  
	      for(pos = pos.up(); worldIn.isAirBlock(pos) && pos.getY() > 2; pos = pos.down()) {
	         ;
	      }

	      if (!IS_GRASS.test(worldIn.getBlockState(pos))) 
	         return false;
	      	  
	    	  
    	  //base 
    	  for(int x = 0 ; x <= 6 ; x++) {
	    	  for(int y = 0 ; y <= 6 ; y++) {
	    		  
	    		  if(!checkPos(worldIn, pos, x, 1, y, this.base, true))
	    			  return false ; 
	    		  
	    	  }
    	  }
	    	  
    	  //rainbow steps (0 to 13) + base 3     	  
    	  for(int x = 0 ; x <= 6 ; x++) {
	    	  for(int y = 0 ; y <= 16 ; y++) {
		    		  
		    		  int l = Math.min(y/2, 6) ; 
		    		  
		    		  switch(dir) {
		    		  
		    		  case 0 : 
			    		  //north
		    			  if(!checkPos(worldIn, pos, x, 2 + l, -y, this.rainbow[6-x], true))
		    				  return false ; 
		    				  
			    		  break ; 
		    		  
		    		  case 1:
			    		  //south
		    			  if(!checkPos(worldIn, pos, x, 2 + l, 6+y, this.rainbow[6-x], true))
		    				  return false ; 
		    				  
			    		  break ; 
		    		  
		    		  case 2:
			    		  //west
		    			  if(!checkPos(worldIn, pos, -y, 2 + l, x, this.rainbow[6-x], true))
		    				  return false ; 
		    				  
			    		  break ; 
			    		  
		    		  default:
			    		  //east  
		    			  if(!checkPos(worldIn, pos, 6+y, 2 + l, x, this.rainbow[6-x], true ))
		    				  return false ; 
		    				
			    		  break ; 
		    		  }

		    	  }
	    	  }
	    	  
    	  
    		 //portal
	    	  
	    	  //y = 2+7
	    	  //z = 14  (except e and s that need cross the base so +6)
	    	  for(int x = 1 ; x <= 5 ; x++ ) {
		    	  for(int y = 0 ; y <= 6 ; y++) {
		    		  
		    		  
		    		  switch(dir) {
		    		  case 0 : 
			    		  //north
			    		  if(y == 0 || y == 6 || x == 1 || x == 5) {
			    			  
			    			  if(!checkPos(worldIn, pos, x, 9+y, -14, this.portal, true ))
			    				  return false ; 
			    			  
			    		  }
			    		  break ; 
		    		  case 1:
			    		  //south
			    		  if(y == 0 || y == 6 || x == 1 || x == 5) {
			    			  
			    			  if(!checkPos(worldIn, pos, x, 9+y, 20, this.portal, true ))
			    				  return false ; 

			    		  }
			    		  break ; 
		    		  case 2:
			    		  //west
			    		  if(y == 0 || y == 6 || x == 1 || x == 5) {
			    			  if(!checkPos(worldIn, pos, -14, 9+y, x, this.portal, true )) 
			    				  return false ; 

			    		  }
			    		  break ; 
		    		  default:
			    		  //east
			    		  if(y == 0 || y == 6 || x == 1 || x == 5) {
			    			  if(!checkPos(worldIn, pos, 20, 9+y, x, this.portal, true ))
			    				  return false ; 

			    		  }
			    		  break ; 
		    		  }
		    		  

		    			  
		    		  
		    		  
		    		  
		    	  }
	    	  }
	    	  
	    	  
	    	  //RENDER ALL BLOCKS
	    	  for(BlockStatePosHolder b : blockStateHolder.getList()) {
	    		  
	    		  worldIn.setBlockState(pos.add(b.getX(), b.getY(), b.getZ()), b.getBlockState(), 2) ; 
	    		  
	    	  }
	    	  
		    		  
	    	  
	         return true;
	     	}
	   
	   
}