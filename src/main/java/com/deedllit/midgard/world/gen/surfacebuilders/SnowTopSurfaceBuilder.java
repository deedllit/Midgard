package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class SnowTopSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	
	public SnowTopSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

		int floor = 112 ; 
		
		double d = Biome.INFO_NOISE.noiseAt(x * 0.125D, z * 0.125D, false);		
		
		int i = x & 15 ; 
		int j = z & 15 ; 
		
		if(d < 0)			
			floor += d * 5 ;
		
		
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
		
		for(int k = startHeight; k >= floor; --k) {
			blockpos$mutableblockpos.setPos(i, k, j);
									
			if (!chunkIn.getBlockState(blockpos$mutableblockpos).isAir()) {
				blockpos$mutableblockpos.setPos(i, k+1, j);
				chunkIn.setBlockState(blockpos$mutableblockpos, Blocks.SNOW.getBlock().getDefaultState(), false);
				break;
			}
		}
		
		
		
	}
	
	
}
