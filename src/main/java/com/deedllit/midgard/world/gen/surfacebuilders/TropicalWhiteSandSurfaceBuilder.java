package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.init.BlockInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TropicalWhiteSandSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public TropicalWhiteSandSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}
	
	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
        BlockState blockstate = config.getTop();
        BlockState blockstate1 = config.getUnder();

        BlockState sand = BlockInit.WHITE_SAND.get().getDefaultState() ;
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        
        int sandLevelBottom = seaLevel -4 ;
        int sandLevelTop = seaLevel +1 ;
        int moutainLevelBottom = 105 ; 
        
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = -1;
        int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int x2 = x & 15;
        int z2 = z & 15;

		double d = Biome.INFO_NOISE.noiseAt(x * 0.25D, z * 0.25D, false);		
        double d2 = Biome.INFO_NOISE.noiseAt(x * 0.125D, z * 0.125D, false);

		if(d > 0) {
			sandLevelTop += d * 1 ;
			moutainLevelBottom += d * 5 ;
		}
	
        
        for(int h = startHeight; h >= 0; --h)
        {
            blockpos$mutable.setPos(x2, h, z2);
            BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.isAir()) {
                i = -1;
            }
            else if (blockstate2 == defaultBlock.getBlock().getDefaultState()) {
                if (i == -1) {
                    if (j <= 0) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                    }
                    else if (h >= sandLevelBottom && h <= sandLevelTop) {
                    	//Layered + smoothed sand area
                        blockstate = sand; 
                        blockstate1 = sand ; 
                    } else if (h >= moutainLevelBottom && h <= 120) {
                    	//Mix ground
                    	if(d2 > 2F) {
                            blockstate = Blocks.STONE.getDefaultState(); 
                            blockstate1 = Blocks.STONE.getDefaultState();  ;                     	                    		
                    	} 
                                    	
                    } else if (h >= 120) {
                        blockstate = Blocks.STONE.getDefaultState(); 
                        blockstate1 = Blocks.STONE.getDefaultState();                      	                    		    	
                    }

                    
                    if (h < seaLevel && (blockstate == null || blockstate.isAir())) {
                    	//just in case if used for a cold biome
                        if (biomeIn.getTemperature(blockpos$mutable.setPos(x, h, z)) < 0.15F) {
                            blockstate = Blocks.ICE.getDefaultState();
                        }
                        else {
                            blockstate = defaultFluid;
                        }

                        blockpos$mutable.setPos(x2, h, z2);
                    }
					

                    i = j;
                    if (h >= seaLevel - 1) {
                        chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                    }
                    else if (h < seaLevel - 7 - j) {
                        blockstate = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                        chunkIn.setBlockState(blockpos$mutable, config.getUnderWaterMaterial(), false);
                    }
                    else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                    }
                }
            }
        }
        
	}

	
	
}
