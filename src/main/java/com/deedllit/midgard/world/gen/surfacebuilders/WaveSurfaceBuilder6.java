package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;
import com.deedllit.midgard.util.shapes.SandWaves;
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

public class WaveSurfaceBuilder6 extends SurfaceBuilder<SurfaceBuilderConfig>  {
	
	private PerlinNoiseGenerator perlinNoise = null ; 
	private SandWaves sandWaves = null ; 
	
	public WaveSurfaceBuilder6(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
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
	        this.sandWaves = new SandWaves() ;
		}

	    
		BlockState test ;
		
	    int floor = 62 ; 
		int i = x & 15 ;
		int j = z & 15 ;
		
		int mX = x / 16 ; 
		int mZ = z / 16 ; 
		
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

		
        double h1 = biomeIn.INFO_NOISE.noiseAt(mX * 0.225D, mZ * 0.125D, false) ;  	
        double h2 = biomeIn.INFO_NOISE.noiseAt(mX * 0.125, mZ * 0.225D, false) ;	
                
		double centerH = Math.max(h1, h2) ; 
		if(centerH >= 0)
			centerH = 1 ; 
		
		h1 = biomeIn.INFO_NOISE.noiseAt((mX + 1) * 0.225D, mZ * 0.125D, false) ;  	
		h2 = biomeIn.INFO_NOISE.noiseAt((mX + 1) * 0.125, mZ * 0.225D, false) ;		
		double eastH = Math.max(h1, h2) ; 
		if(eastH >= 0)
			eastH = 2 ; 
		
		h1 = biomeIn.INFO_NOISE.noiseAt((mX - 1) * 0.225D, mZ * 0.125D, false) ;  	
		h2 = biomeIn.INFO_NOISE.noiseAt((mX - 1) * 0.125, mZ * 0.225D, false) ;
		double westH = Math.max(h1, h2) ; 
		if(westH >= 0)
			westH = 4 ; 
		
		h1 = biomeIn.INFO_NOISE.noiseAt(mX * 0.225D, (mZ + 1) * 0.125D, false) ;  	
		h2 = biomeIn.INFO_NOISE.noiseAt(mX * 0.125, (mZ + 1)* 0.225D, false) ;
		double southH = Math.max(h1, h2) ; 
		if(southH >= 0)
			southH = 8 ; 
		
		h1 = biomeIn.INFO_NOISE.noiseAt(mX * 0.225D, (mZ - 1) * 0.125D, false) ;  	
		h2 = biomeIn.INFO_NOISE.noiseAt(mX * 0.125, (mZ - 1)* 0.225D, false) ;
		double northH = Math.max(h1, h2) ; 
		if(northH >= 0)
			northH = 16 ; 

		double height = 0; 
		double height2 ; 				
		double heightFinal ; 				
        
		int trigo1 = i ; 
		int trigo2 = j ;

		double dX = biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.125D, false) / 10;		
		double dZ = biomeIn.INFO_NOISE.noiseAt(x * 0.125, z * 0.225D, false) / 10;		
				
		
		
		test = Blocks.SAND.getDefaultState() ; 
		int avg = 1; 
		
		
		//STONE TEST
		
		/* 
		height = 2  ;
		if(centerH > 0) {
			height = 5 ; 
			test = Blocks.COBBLESTONE.getDefaultState() ;		
			if(northH > 0 || southH > 0) {
				test = Blocks.CHISELED_STONE_BRICKS.getDefaultState() ;		
			}
		} else {
			test = Blocks.SAND.getDefaultState() ; 			
			if(northH > 0 || southH > 0) {
				test = Blocks.CHISELED_SANDSTONE.getDefaultState() ;						
			}
		}
		
		height = height * 5  ;

		for(int h = 0 ; h <= height ; h++) {	
			chunkIn.setBlockState(blockpos$mutable, test, false);
			blockpos$mutable.move(Direction.UP) ; 
		}  			

		
		
		
		 */
			
		
		height = Math.abs(dX) + Math.abs(dZ) ;
		
		/*
		if(centerH > 0) {
			//height = this.sandWaves.getNorthSouthWaveHeight(i, j)  ; 			
			height *= -1 ;
			height += this.sandWaves.getPyramid(i, j)  ; 			
		} else {
			//height *= -1 ;
		}
				
		
		avg += 1 ; 
		if(northH > 0) {
			height += this.sandWaves.getNorthSouthWaveHeight(i, j)  ; 			
		} 
	
		avg += 1 ; 
		if(southH > 0) {
			height += this.sandWaves.getNorthSouthWaveHeight(i, j)  ; 			
		} 
		
		avg += 1 ; 
		if(eastH > 0) {
			height += this.sandWaves.getEastWestWaveHeight(i, j)  ; 						
		}

		avg += 1 ; 
		if(westH > 0) {
			height += this.sandWaves.getEastWestWaveHeight(i, j)  ; 						
		}
		*/
		
		height = height / avg ; 
		height2 = height * 5  ;
		
		
		
        
        blockpos$mutable.setPos(x, floor - 1, z);
		
		double localNoiseHole = voronoiNoise.noise(x, z, 0.05f) ;		
				

		double vertical = chunkIn.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG).getHeight(i, j);
		double smooth = MathHelper.clamp((vertical - seaLevel) * 0.125D, 0, 1);

		h1 = this.perlinNoise.noiseAt((double)x * 0.00953125D, (double)z * 0.001553125D, false) * 2 * smooth;
        h2 = this.perlinNoise.noiseAt((double)x * 0.02953125D + 5, (double)z * 0.004553125D + 5, false) * 4 + 1;
		height = Math.max(h1, h2);      

		if(height > 0 || (localNoiseHole > 0.35f && localNoiseHole < 0.85f)) {

			//if(height < 1) {
				height = Math.max(1, height2) ; 				
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
		
		

		
		//SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
	



}
