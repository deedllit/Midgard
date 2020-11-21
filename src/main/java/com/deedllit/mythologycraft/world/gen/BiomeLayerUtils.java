package com.deedllit.mythologycraft.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public class BiomeLayerUtils implements IC0Transformer {

	private Biome[] dimensionBiomes ;
	
	public BiomeLayerUtils(Biome[] dimensionBiomes) {
		this.dimensionBiomes = dimensionBiomes ; 
	}
	
	@Override
	public int apply(INoiseRandom context, int value) {
		return Registry.BIOME.getId(dimensionBiomes[context.random(dimensionBiomes.length)]);
	}
}
