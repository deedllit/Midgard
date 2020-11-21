package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MidgardRemoveTooMuchOceanLayer implements ICastleTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		return MidgardLayerUtil.isShallowOcean(center) && MidgardLayerUtil.isShallowOcean(north)
				&& MidgardLayerUtil.isShallowOcean(west) && MidgardLayerUtil.isShallowOcean(east) && MidgardLayerUtil.isShallowOcean(south)
				&& context.random(2) == 0 ? MidgardLayerUtil.PLAINS : center;
	}
}
