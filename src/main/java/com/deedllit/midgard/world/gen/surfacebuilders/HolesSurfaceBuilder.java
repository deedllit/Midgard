package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class HolesSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public HolesSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;

		int i = x & 15;
	    int j = z & 15;
	    int k = -Math.abs((int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D)); 
	    
	    BlockState blockstate = Blocks.STONE.getDefaultState() ; 
	    BlockState blockstate1 = biomeIn.getSurfaceBuilderConfig().getUnder();
	    
	    BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	    
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);		

	    //62
	    
        if (!flag) {
		    for(int j1 = 1; j1 <= 150; j1++) {
		    			    	
		    	
			    blockpos$mutableblockpos.setPos(x, j1, z);  
			    BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
			    
			    if (blockstateCur == defaultFluid) {
			    	break ; 
			    } else if (blockstateCur == Blocks.AIR.getDefaultState()) {

	    			//blockstate = Blocks.RED_TERRACOTTA.getDefaultState() ; 
			    	for(int j2 = j1 - 1 ; j2 >= 61-k ; j2--) {
			    		
			    		blockpos$mutableblockpos.setPos(x, j2, z);  
			    		if(checkCorner(chunkIn, x, j2, z, defaultFluid)) {
				    		chunkIn.setBlockState(blockpos$mutableblockpos, defaultFluid, false);			    					    			
			    		} else {
				    		chunkIn.setBlockState(blockpos$mutableblockpos, Blocks.LAVA.getDefaultState(), false);			    					    						    			
			    		}
			    	}

			    	break ; 
	    			
	    		}

		    }
	    }

	    
		
	}

	
	private boolean checkCorner(IChunk chunkIn, int x, int y, int z, BlockState defaultFluid ) {
		
	    BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	  
	    BlockState blockstate[] = {Blocks.AIR.getDefaultState(),Blocks.AIR.getDefaultState(),Blocks.AIR.getDefaultState(),Blocks.AIR.getDefaultState()} ;
	    
	    blockstate[0] = chunkIn.getBlockState(blockpos$mutableblockpos.east()) ; 
	    blockstate[1] = chunkIn.getBlockState(blockpos$mutableblockpos.west()) ; 
	    blockstate[2] = chunkIn.getBlockState(blockpos$mutableblockpos.north()) ; 
	    blockstate[3] = chunkIn.getBlockState(blockpos$mutableblockpos.south()) ; 
	    
	    for (int i = 0; i < blockstate.length; i++) {
	    		if(blockstate[i] != defaultFluid && blockstate[i] == Blocks.STONE.getDefaultState())
	    			return false ; 
	    	}

	    /*
	    BlockState blockstateCur ;
	    blockpos$mutableblockpos.setPos(x-1, y, z);  
	    blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
	    
	    if (blockstateCur == defaultFluid || blockstateCur == Blocks.STONE.getDefaultState()) {
		    blockpos$mutableblockpos.setPos(x+1, y, z);  
		    blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);

		    if (blockstateCur == defaultFluid || blockstateCur == Blocks.STONE.getDefaultState()) {
			    blockpos$mutableblockpos.setPos(x, y, z-1);  
			    blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);		    	
			    if (blockstateCur == defaultFluid || blockstateCur == Blocks.STONE.getDefaultState()) {
				    blockpos$mutableblockpos.setPos(x, y, z+1);  
				    blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);		    	
				    if (blockstateCur == defaultFluid || blockstateCur == Blocks.STONE.getDefaultState()) {
				    	return true ; 
				    }
			    }
				    
			}
	    	
	    }
		*/
	    
		return false ; 
	}
	
}
