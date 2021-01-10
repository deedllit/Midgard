package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;
import com.deedllit.midgard.world.gen.noise.VoronoiGenerator;
import com.deedllit.midgard.world.gen.noise.VoronoiGenerator2;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class WaveSurfaceBuilder5 extends SurfaceBuilder<SurfaceBuilderConfig>  {
	
	private PerlinNoiseGenerator perlinNoise = null ; 

	
	public WaveSurfaceBuilder5(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
			
		VoronoiGenerator voronoiNoise = new VoronoiGenerator(seed, (short) 0);
		PrecomputedMath preComputed = new PrecomputedMath() ; 
		
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		
		if(this.perlinNoise == null) {
	        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
	        this.perlinNoise = new PerlinNoiseGenerator(sharedseedrandom, 3, 0);		
		}

	    
	    int floor = 62 ; 
		int i = x & 15 ;
		int j = z & 15 ;
		
		int mX = x / 32 ; 
		int mZ = z / 32 ; 
		
		int trigo1 ; 
		int trigo2 ;
		
		trigo1 = i ;
		trigo2 = j ;							
			
		/*
		if(noise > 0) {
			
			int n = random.nextInt(32) + 1 ;
			
			if(mX % n == 1 || mZ % n == 1) {
				if(random.nextBoolean()) {
					trigo1 = j ;
					trigo2 = i ;							
				} else {
					trigo1 = Math.max(i, j) ;
					trigo2 = Math.min(i, j) ;
				}
			} 
			
		}
		*/
		
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
        		
		double localNoiseHole = voronoiNoise.noise(x, z, 0.02f) ;		
		double localNoise = voronoiNoise.noise(x, z, 0.02f) ;		
		
		double dX = biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.125D, false) / 10;		
		double dZ = biomeIn.INFO_NOISE.noiseAt(x * 0.125, z * 0.225D, false) / 10;		

		
		double height ; 
		double height2 ; 				
		
		height= preComputed.getCos(trigo1) ; 
		if(height < 0)
			height = preComputed.getSin(trigo1) ; 
		height += dX ; 	
		height *= 3 ; 
		
		if(height < 0) {
			height2 = preComputed.getCos(trigo2) ; 		
			if(height2 < 0)
				height2 = preComputed.getSin(trigo2) ; 
			height2 += dZ ; 	
			height2 *= 2 ; 
			
			height = Math.min(height, height2) ; 
		}
		
		height2 = height ;

		double vertical = chunkIn.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG).getHeight(i, j);
		double smooth = MathHelper.clamp((vertical - seaLevel) * 0.125D, 0, 1);

		double h1 = this.perlinNoise.noiseAt((double)x * 0.00953125D, (double)z * 0.001553125D, false) * 2 * smooth;
        double h2 = this.perlinNoise.noiseAt((double)x * 0.02953125D + 5, (double)z * 0.004553125D + 5, false) * 4 + 1;
		height = Math.max(h1, h2);      

		/*
        double h1 = this.perlinNoise.noiseAt((double)x * 0.00953125D, (double)z * 0.001553125D, false) * 30 * smooth;
        double h2 = this.perlinNoise.noiseAt((double)x * 0.02953125D + 5, (double)z * 0.004553125D + 5, false) * 35 + 8;                
		height = Math.sqrt(Math.max(h1, h2));      
		*/
		
		if(height > 1 || (localNoiseHole > 0.3f && localNoiseHole < 0.9f)) {

			height += height2 ; 
			//height = Math.max(1, height) ; 				
			
			//if(height < 1) {
		//		height = Math.max(1, height2) ; 				
			//}
			
			
			for(int h = 0 ; h <= height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, defaultBlock, false);
				blockpos$mutable.move(Direction.UP) ; 
			}  			
		} 
		else {
			blockpos$mutable.move(Direction.UP) ; 
			//for(int h = 0 ; h <= height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
			//	blockpos$mutable.move(Direction.DOWN) ; 
			//}  			
			
			//blockpos$mutable.move(Direction.UP) ; 							
			//chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
		}
		
		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
	



}
