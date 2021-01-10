package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.world.gen.noise.VoronoiGenerator;
import com.deedllit.midgard.world.gen.noise.VoronoiGenerator2;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SwampBuilder extends SurfaceBuilder<SurfaceBuilderConfig>  {

	
	public SwampBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
			
		VoronoiGenerator voronoiNoise = new VoronoiGenerator(seed, (short) 0);
		
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		
	    int floor = 62 ; 
		int i = x & 15 ;
		int j = z & 15 ;
		

        blockpos$mutable.setPos(x, startHeight, z);
        
        //Make sure we reach surface
        if(chunkIn.getBlockState(blockpos$mutable).isAir()) {
            while(chunkIn.getBlockState(blockpos$mutable).isAir()) {
    			blockpos$mutable.move(Direction.DOWN) ;         	
            }        	
        } else {
            while(!chunkIn.getBlockState(blockpos$mutable).isAir()) {  
            	
            	if( blockpos$mutable.getY() >= floor ) {
        			chunkIn.setBlockState(blockpos$mutable, Blocks.AIR.getDefaultState(), false);        	            		
            	}
            	
    			blockpos$mutable.move(Direction.UP) ;         	
            }        	        	
        }

        
        for(int h = blockpos$mutable.getY() ; h >= floor ; h--) {
    			chunkIn.setBlockState(blockpos$mutable, Blocks.AIR.getDefaultState(), false);        	
			blockpos$mutable.move(Direction.DOWN) ;         	
        }
        
        
        blockpos$mutable.setPos(x, floor - 1, z);
        
		double d = biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.225D, false) / 100;		
		
		double localNoiseA = voronoiNoise.noise(x, z, 0.02f + d) ;
		double localNoiseB = voronoiNoise.noise(x, z, 0.03f) ;
		double localNoiseC = voronoiNoise.noise(x, z, 0.3f) ;
		
		double localNoise ;
		
		
		localNoise = localNoiseA + localNoiseB + localNoiseC   ; 
		localNoise /= 3 ; 
		
		double height = localNoise * 5 ; 

		
		
		if(localNoiseA > 0.3f && localNoiseA < 0.9f) {
			for(int h = 0 ; h < height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, defaultBlock, false);
				blockpos$mutable.move(Direction.UP) ; 
			}  			
		} 
		else {
			blockpos$mutable.move(Direction.UP) ; 
			for(int h = 0 ; h < height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
				blockpos$mutable.move(Direction.DOWN) ; 
			}  			
			
			//blockpos$mutable.move(Direction.UP) ; 							
			//chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
		}
		
		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
	



}
