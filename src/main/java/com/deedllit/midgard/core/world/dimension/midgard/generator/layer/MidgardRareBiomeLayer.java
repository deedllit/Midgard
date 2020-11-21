package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum MidgardRareBiomeLayer implements IC1Transformer {
	   INSTANCE;

	   private static final int PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_PLAINS_BIOME.get());
	   private static final int SUNFLOWER_PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_SUNFLOWER_PLAINS_BIOME.get());

	   public int apply(INoiseRandom context, int value) {
	      return context.random(57) == 0 && value == PLAINS ? SUNFLOWER_PLAINS : value;
	   }
	}
