package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.init.SurfaceBuilderInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class MangroveMixedSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig>  {

	public MangroveMixedSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		if (noise > 1.7D) {
			SurfaceBuilderInit.MANGROVE_BORDER.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);
		} else {
			SurfaceBuilderInit.MANGROVE.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);			
		}
	
		
	}

}
