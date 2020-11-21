package com.deedllit.midgard.core.world.dimension.midgard.config;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.OverworldChunkGenerator;
import net.minecraft.world.gen.OverworldGenSettings;

public class ChunkGeneratorOverworldVanillaMidgard extends OverworldChunkGenerator {

	public ChunkGeneratorOverworldVanillaMidgard(IWorld worldIn, BiomeProvider provider,
			OverworldGenSettings settingsIn) {
		super(worldIn, provider, settingsIn);
	}
	
}
