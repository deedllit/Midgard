package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum MidgardAddBambooForestLayer implements IC1Transformer {
	   INSTANCE;

	   private static final int JUNGLE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_BIOME.get());
	   private static final int BAMBOO_JUNGLE = Registry.BIOME.getId(BiomeInit.VANILLA_BAMBOO_JUNGLE_BIOME.get());

	   public int apply(INoiseRandom context, int value) {
	      return context.random(10) == 0 && value == JUNGLE ? BAMBOO_JUNGLE : value;
	   }
	}
