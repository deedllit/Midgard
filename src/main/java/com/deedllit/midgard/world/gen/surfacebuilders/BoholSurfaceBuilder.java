package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.world.gen.noise.VoronoiGenerator;
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

public class BoholSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public BoholSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

        
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
        
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        blockpos$mutable.setPos(x, startHeight, z);
        WorldUtil.reachFloor(chunkIn, blockpos$mutable) ;	

        double h = 0 ;        
                        
        if (noise > 0) {        	
        	h = -1 + 2.63 * noise * Math.pow(1.36, noise/3) ;          	
        }
		
        if(h > 0) {
        	
    		h = h + 6 ;
    		    		
    		blockpos$mutable.move(Direction.DOWN) ;         	
    		blockpos$mutable.move(Direction.DOWN) ;         	
    		blockpos$mutable.move(Direction.DOWN) ;         	
    		blockpos$mutable.move(Direction.DOWN) ;         	
    		blockpos$mutable.move(Direction.DOWN) ;         	
    		blockpos$mutable.move(Direction.DOWN) ;         	
        	
    		
        	int iH = (int) h + 1; 
        	
        	for(int hy = 0 ; hy <= iH ; hy++) {
        		
        		if(hy <= iH - 4) {
                    chunkIn.setBlockState(blockpos$mutable, defaultBlock , false);                        			
        		} else if (hy == iH) {
                    chunkIn.setBlockState(blockpos$mutable, config.getTop() , false);                        			        			
        		} else {
                    chunkIn.setBlockState(blockpos$mutable, config.getUnder() , false);                        			        			
        		}
        		
    			blockpos$mutable.move(Direction.UP) ;         	
        	}

        }
    	


	}
	

}
