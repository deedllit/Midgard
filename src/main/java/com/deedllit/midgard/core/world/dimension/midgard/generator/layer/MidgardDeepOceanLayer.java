package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MidgardDeepOceanLayer implements ICastleTransformer {
	INSTANCE;

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		if (MidgardLayerUtil.isShallowOcean(center)) {
			int i = 0;
			if (MidgardLayerUtil.isShallowOcean(north)) {
				++i;
			}

			if (MidgardLayerUtil.isShallowOcean(west)) {
				++i;
			}

			if (MidgardLayerUtil.isShallowOcean(east)) {
				++i;
			}

			if (MidgardLayerUtil.isShallowOcean(south)) {
				++i;
			}

			if (i > 3) {
				if (center == MidgardLayerUtil.WARM_OCEAN) {
					return MidgardLayerUtil.DEEP_WARM_OCEAN;
				}

				if (center == MidgardLayerUtil.LUKEWARM_OCEAN) {
					return MidgardLayerUtil.DEEP_LUKEWARM_OCEAN;
				}

				if (center == MidgardLayerUtil.OCEAN) {
					return MidgardLayerUtil.DEEP_OCEAN;
				}

				if (center == MidgardLayerUtil.COLD_OCEAN) {
					return MidgardLayerUtil.DEEP_COLD_OCEAN;
				}

				if (center == MidgardLayerUtil.FROZEN_OCEAN) {
					return MidgardLayerUtil.DEEP_FROZEN_OCEAN;
				}

				return MidgardLayerUtil.DEEP_OCEAN;
			}
		}

		return center;
	}
}
