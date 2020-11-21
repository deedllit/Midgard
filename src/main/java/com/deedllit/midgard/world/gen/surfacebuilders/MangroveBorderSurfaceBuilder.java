package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MangroveBorderSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public MangroveBorderSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		int floor = 62 ; 
		
		double r = random.nextDouble() ; 
		double d = biomeIn.INFO_NOISE.noiseAt(x * 0.225D, z * 0.225D, false);		
		
		if (d >= 0.2D && r > 0.5D) {
			int i = x & 15 ; 
			int j = z & 15 ; 
			
			BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
			
			for(int k = startHeight; k >= 0; --k) {
				blockpos$mutableblockpos.setPos(i, k, j);
				if (!chunkIn.getBlockState(blockpos$mutableblockpos).isAir()) {
					if (k == floor && chunkIn.getBlockState(blockpos$mutableblockpos).getBlock() != defaultFluid.getBlock()) {
						chunkIn.setBlockState(blockpos$mutableblockpos, defaultFluid, false);
					}
					break;
				}
			}
			
		}
		
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
	}
}
