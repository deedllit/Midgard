package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ChaparralSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public ChaparralSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> deserializer) {
		super(deserializer);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		SurfaceBuilderConfig layer1 ;
		SurfaceBuilderConfig layer2 ; 
		
		if(config.getTop() == Blocks.SAND.getDefaultState()) {
			layer1 = SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG ;  
			layer2 = SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG ;  
		} else {			
			layer1 = SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG ;  
			layer2 = SurfaceBuilder.SAND_SAND_GRAVEL_CONFIG ;  
		}
		
		if(noise > 2.5D) {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, SurfaceBuilder.STONE_STONE_GRAVEL_CONFIG);
		} else if(noise > 1.2D) { 
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, layer2);			
		} else {
			SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, layer1);			
		}

		
	}

	
	
}
