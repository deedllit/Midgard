package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;
import com.deedllit.midgard.util.shapes.SandWaves;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.CellularDistanceFunction;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.CellularReturnType;
import com.deedllit.midgard.world.gen.noise.FastNoiseLite.DomainWarpType;
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

public class WaveSurfaceBuilder12 extends SurfaceBuilder<SurfaceBuilderConfig>  {
	
	private FastNoiseLite noiseLite = null ; 
	
	public WaveSurfaceBuilder12(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
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

	        this.noiseLite.SetNoiseType(NoiseType.OpenSimplex2S);
	        this.noiseLite.SetFrequency(0.03f);
	        this.noiseLite.SetFractalType(FractalType.PingPong);
	        this.noiseLite.SetFractalOctaves(4);
	        this.noiseLite.SetFractalLacunarity(2.0f);
	        this.noiseLite.SetFractalGain(0.5f);
	        this.noiseLite.SetFractalWeightedStrength(-0.40f);
	        this.noiseLite.SetFractalPingPongStrength(1.0f);
	        this.noiseLite.SetCellularDistanceFunction(CellularDistanceFunction.Euclidean);
	        this.noiseLite.SetCellularReturnType(CellularReturnType.Distance2Mul);
	        this.noiseLite.SetCellularJitter(1.25f);
	        this.noiseLite.SetDomainWarpType(DomainWarpType.OpenSimplex2);
	        this.noiseLite.SetDomainWarpAmp(15.0f);
	        
	        /*
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
	        */
	        
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
		int mX32 = x / 32 ; 
		int mZ32 = z / 32 ; 
		int mX64 = x / 64 ; 
		int mZ64 = z / 64 ; 
		
		
		int x2 = x / 2 ;
		int z2 = z / 2;
		
		//double n = 0.5 ; 
		//double coff = 10 / n ; 
		
		double n = -0.15 ; 
		double coff = 2.85 ; 
		
        float h1 = (float) biomeIn.INFO_NOISE.noiseAt(mX32 * 0.225D, mZ * 0.125D, false) ;  	
        float h2 = (float) biomeIn.INFO_NOISE.noiseAt(mX * 0.125, mZ32 * 0.225D, false) ;	
		float dX = (float) biomeIn.INFO_NOISE.noiseAt(mX64 * 0.225D, z * 0.125D, false) / 10;		
		float dZ = (float) biomeIn.INFO_NOISE.noiseAt(x * 0.125, mZ64 * 0.225D, false) / 10;		

		h1 += dX - h2 ; 
		h2 += dZ - h1; 

		//h1 = 0 ;
		//h2 = 0 ;
		
		double d1 = Math.sin(x2 / (1.18 + h1) ) * Math.cos(z2 / (1.05 + h2)) ; 
		double d2 = Math.tan(x2 / (1.06 + h1) ) * Math.sin(z2 / (1.13 + h2)) ;
		double d3 = Math.cos(x2 / (1.03 + h1) ) * Math.tan(z2 / (1.03 + h2)) ;
		double d ; 
		
		d = Math.max(d3,  d2) ; 
		d = Math.min(d1, d) ; 
		
		//d = Math.max(d,  d2) ; 
		//d = Math.max(d,  d3) ; 
		
		//d = (d + d2) / 2 ;
		
		/*
		if(d > 0) {
			d = 0 ; 
		}
		*/
		
		//double d = Math.sin(x2 / (1.18 + h1) ) * Math.cos(z2 / (1.05 + h2)) ; 
		double dNoise = this.noiseLite.GetNoise(x2, z2) ;

		
		if(d > 1) {
			d = Math.abs(dNoise) ; 
		} else {
			
			/*
			if(dNoise > 0)
				d = dNoise ; 
			*/
			
			if(dNoise > 0)
				d = (d + dNoise) / 2 ; 
		}
		
		/*
		if(d > 0)
			d = 0 ;
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

        int surface = blockpos$mutable.getY()  ;
        for(int h = blockpos$mutable.getY() ; h >= floor ; h--) {
    			chunkIn.setBlockState(blockpos$mutable, Blocks.AIR.getDefaultState(), false);        	
			blockpos$mutable.move(Direction.DOWN) ;         	
        }
        
        
        blockpos$mutable.setPos(x, floor - 1, z);
        
        
        if(d > 0.5)
        	d = 0.5 + (d/2) ; 
        
        
        double height = d * 3.25 ; 
        //double height = d ; 

		if(height >= 0) {
			
			height++ ;
			
			for(int h = 0 ; h <= height ; h++) {	
				chunkIn.setBlockState(blockpos$mutable, config.getTop(), false);
				blockpos$mutable.move(Direction.UP) ; 
			}  			
		} 
		else {
			
			height = Math.max(height, -1) ; 
			
			blockpos$mutable.move(Direction.UP) ; 
			for(int h = 0 ; h >= height ; h--) {	
				chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
				blockpos$mutable.move(Direction.DOWN) ; 
			}  			
			
			
			//blockpos$mutable.move(Direction.UP) ; 							
			//chunkIn.setBlockState(blockpos$mutable, defaultFluid, false);
		}
		
		

		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
	



}
