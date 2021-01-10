package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.world.gen.util.WorldUtil;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class GrindelwaldSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public GrindelwaldSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

        int x2 = x & 15;
        int z2 = z & 15;
        
		double d = Biome.INFO_NOISE.noiseAt(x * 0.25D, z * 0.25D, false);		
        double d2 = Biome.INFO_NOISE.noiseAt(x * 0.125D, z * 0.125D, false);
        
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        blockpos$mutable.setPos(x, startHeight, z);
        WorldUtil.reachFloor(chunkIn, blockpos$mutable) ;	

    	double height = blockpos$mutable.getY() ;
        double h = 0 ;         
    	
        if(noise > 2.3) {
        	h = 25 + noise * 5.55 ;          	        	
        } else if(noise > 1.8) {
        	h = 18 + noise * 4.95 ;          	
        } else if(noise > 1) {        	
        	h = 12 + noise * 4.65 ;  
        } else if (noise > 0) {
        	h = noise * 10 ;          	
        }
		
        if(h > 0) {
        	for(int hy = 0 ; hy <= h ; hy++) {
    			blockpos$mutable.move(Direction.UP) ;         	
                chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.getDefaultState(), false);                
        	}
        	
        	if(blockpos$mutable.getY() < 128 && d2 > 0) {
                chunkIn.setBlockState(blockpos$mutable, Blocks.GRASS_BLOCK.getDefaultState(), false);                        		
        	} else if(blockpos$mutable.getY() < 150 &&  d2 > 1) {
                chunkIn.setBlockState(blockpos$mutable, Blocks.GRASS_BLOCK.getDefaultState(), false);                        		        		
        	} 
        	
        	if(blockpos$mutable.getY() > 140 && (d > 0 || d2 < 0)) {
    			blockpos$mutable.move(Direction.UP) ;         	
				chunkIn.setBlockState(blockpos$mutable, Blocks.SNOW.getBlock().getDefaultState(), false);
        	} else if(blockpos$mutable.getY() > 160) {
    			blockpos$mutable.move(Direction.UP) ;         	
				chunkIn.setBlockState(blockpos$mutable, Blocks.SNOW.getBlock().getDefaultState(), false);
        	}
        }
    	

		SurfaceBuilder.MOUNTAIN.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

	}
	

}
