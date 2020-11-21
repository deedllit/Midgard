package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

public enum MidgardAddMushroomIslandLayer implements IBishopTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int x, int southEast, int p_202792_4_, int p_202792_5_, int p_202792_6_) {
		return MidgardLayerUtil.isShallowOcean(p_202792_6_) && MidgardLayerUtil.isShallowOcean(p_202792_5_)
				&& MidgardLayerUtil.isShallowOcean(x) && MidgardLayerUtil.isShallowOcean(p_202792_4_)
				&& MidgardLayerUtil.isShallowOcean(southEast) && context.random(100) == 0 ? MidgardLayerUtil.MUSHROOM_FIELDS
						: p_202792_6_;
	}
}