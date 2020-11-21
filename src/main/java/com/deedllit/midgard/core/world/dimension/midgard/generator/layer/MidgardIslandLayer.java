package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IAreaTransformer0;

public enum MidgardIslandLayer implements IAreaTransformer0 {
	   INSTANCE;

	   public int apply(INoiseRandom context, int x, int z) {
	      if (x == 0 && z == 0) {
	         return 1;
	      } else {
	         return context.random(10) == 0 ? MidgardLayerUtil.PLAINS : MidgardLayerUtil.OCEAN;
	      }
	   }
}
