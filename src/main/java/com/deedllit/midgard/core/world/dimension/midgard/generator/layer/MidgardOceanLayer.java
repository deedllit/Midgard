package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.ImprovedNoiseGenerator;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum MidgardOceanLayer implements IAreaTransformer0 {
	   INSTANCE;

	   public int apply(INoiseRandom context, int x, int z) {
	      ImprovedNoiseGenerator improvednoisegenerator = context.getNoiseGenerator();
	      double d0 = improvednoisegenerator.func_215456_a((double)x / 8.0D, (double)z / 8.0D, 0.0D, 0.0D, 0.0D);
	      if (d0 > 0.4D) {
	         return MidgardLayerUtil.WARM_OCEAN;
	      } else if (d0 > 0.2D) {
	         return MidgardLayerUtil.LUKEWARM_OCEAN;
	      } else if (d0 < -0.4D) {
	         return MidgardLayerUtil.FROZEN_OCEAN;
	      } else {
	         return d0 < -0.2D ? MidgardLayerUtil.COLD_OCEAN : MidgardLayerUtil.OCEAN;
	      }
	   }
	}