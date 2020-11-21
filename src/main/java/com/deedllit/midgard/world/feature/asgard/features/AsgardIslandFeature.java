package com.deedllit.midgard.world.feature.asgard.features;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class AsgardIslandFeature extends Feature<NoFeatureConfig> {

	public AsgardIslandFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
	      float f = (float)(rand.nextInt(3) + 4);
	      int c = 0 ; 
	      
	      BlockState[] bs = {Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()} ;
	      
	      for(int i = 0; f > 0.5F; --i) {
	    	  	    	  
	         for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
	            for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
	               if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
	            	   
	            	   if(c == 0)
	            		   this.setBlockState(worldIn, pos.add(j, i, k), bs[0]);
	            	   else if(c == 1)
	            		   this.setBlockState(worldIn, pos.add(j, i, k), bs[1]);
	            	   else 
	            		   this.setBlockState(worldIn, pos.add(j, i, k), bs[2]);

	            	   
	               }
	            }
	         }

	         c++ ; 
	         f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
	         
	         
	      }

	      return true;

	}
}
	

 
