package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.init.SurfaceBuilderInit;
import com.deedllit.midgard.world.gen.surfacebuilders.subbuilders.TropicalIslandSubBuilder;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class BlackSandIsland extends SurfaceBuilder<SurfaceBuilderConfig> {

	public BlackSandIsland(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> p_i51305_1_) {
		super(p_i51305_1_);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		TropicalIslandSubBuilder tropicalIslandBuilder = new TropicalIslandSubBuilder() ;
		tropicalIslandBuilder.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config,
				-2, 5, 85,
				Blocks.STONE.getDefaultState(), Blocks.GRASS_BLOCK.getDefaultState(), BlockInit.BLACK_SAND.get().getDefaultState());

	}

	
	

}
