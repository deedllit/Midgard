package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;
import com.deedllit.midgard.util.shapes.SandWaves;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.CellularDistanceFunction;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.CellularReturnType;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.FractalType;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.NoiseType;
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

public class WaveSurfaceBuilder9 extends SurfaceBuilder<SurfaceBuilderConfig>  {
	
	private FastNoiseLite noiseLite = null ; 
	
	public WaveSurfaceBuilder9(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
			
		VoronoiGenerator voronoiNoise = new VoronoiGenerator(seed, (short) 0);
		PrecomputedMath preComputed = new PrecomputedMath() ; 
		
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		
		if(this.noiseLite == null) {
	        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
	        this.noiseLite = new FastNoiseLite((int) seed);	

	        this.noiseLite.SetNoiseType(NoiseType.Cellular);
	        this.noiseLite.SetFrequency(0.1f);
	        this.noiseLite.SetFractalType(FractalType.PingPong);
	        this.noiseLite.SetFractalOctaves(4);
	        this.noiseLite.SetFractalLacunarity(2.0f);
	        this.noiseLite.SetFractalGain(0.5f);
	        this.noiseLite.SetFractalWeightedStrength(0);
	        this.noiseLite.SetFractalPingPongStrength(2.0f);
	        this.noiseLite.SetCellularDistanceFunction(CellularDistanceFunction.Euclidean);
	        this.noiseLite.SetCellularReturnType(CellularReturnType.Distance2Mul);
	        this.noiseLite.SetCellularJitter(2.25f);
	        
	        
	    	/*
	    	this.noiseLite.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
	        this.noiseLite.SetFractalType(FractalType.Ridged);
	        this.noiseLite.SetFrequency(0.06f);
	        this.noiseLite.SetFractalOctaves(1);
	        this.noiseLite.SetFractalLacunarity(2.0f);
	        this.noiseLite.SetFractalGain(0.9f);
	        this.noiseLite.SetFractalWeightedStrength(0.5f);
	        this.noiseLite.SetCellularDistanceFunction(CellularDistanceFunction.Hybrid);
	        this.noiseLite.SetCellularReturnType(CellularReturnType.CellValue);
	    	 */

		}
		

	    
		BlockState test ;
		
	    int floor = 62 ; 
		int i = x & 15 ;
		int j = z & 15 ;
		
		int mX = x / 16 ; 
		int mZ = z / 16 ; 
		
		//double n = 0.5 ; 
		//double coff = 10 / n ; 
		
		double n = -0.15 ; 
		double coff = 2.85 ; 
		
        float h1 = (float) biomeIn.INFO_NOISE.noiseAt(mX * 0.225D, mZ * 0.125D, false) ;  	
        float h2 = (float) biomeIn.INFO_NOISE.noiseAt(mX * 0.125, mZ * 0.225D, false) ;	
		float dX = (float) biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.125D, false) / 10;		
		float dZ = (float) biomeIn.INFO_NOISE.noiseAt(x * 0.125, z * 0.225D, false) / 10;		

		h1 += dX ; 
		h2 += dZ ; 
        h1 *= 2  ; 
        h2 *= 2 ; 
        
        
		double d = this.noiseLite.GetNoise(x + h1, z + h2) ;

		
		//Midgard.LOGGER.info( d );		

		
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

        
        /*
        d = d * -1  ; 
        if( d > 0.85) {
        	d = d - 1 ; 
        }
        */
        
        /*
        if(d < 0 && d > -0.3) {
        	d = 0 ; 
        }
        */
        
        
        if( d < 0 && d > -0.5) {
        	d = d + 0.8 ; 
        }
        
        //d+= 0.50 ; 
        
        
		//double height = d * coff ; 

        /*
        if(d < 0 && d > -0.3) {
        	d = 0 ;
        } else {
        	if(d > 0 && d < 0.3) {
        		d = d - 0.5 ;
        	}
        }
        */
        
        double height = d * 3.25 ; 
        //double height = d * 2.85 ; 
        //double height = d * 2.25 ; 
        //double height = d * 1.85 ; 

		if(height >= 0) {
			
			height++ ;
			
			for(int h = 0 ; h <= height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, config.getTop(), false);
				blockpos$mutable.move(Direction.UP) ; 
			}  			
		} 
		else {
			
			height = Math.max(height, -1) ; 
			/*
			blockpos$mutable.move(Direction.UP) ; 
			for(int h = 0 ; h >= height ; h--) {	
				chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
				blockpos$mutable.move(Direction.DOWN) ; 
			}  			
			*/
			
			blockpos$mutable.move(Direction.UP) ; 							
			chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
		}
		
		

		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
	



}
