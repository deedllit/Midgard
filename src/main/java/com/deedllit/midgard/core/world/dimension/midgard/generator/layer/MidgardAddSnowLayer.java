package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC1Transformer;

public enum MidgardAddSnowLayer implements IC1Transformer {
	INSTANCE;

	public int apply(INoiseRandom context, int value) {
		if (MidgardLayerUtil.isShallowOcean(value)) {
			return value;
		} else {
			int i = context.random(6);
			if (i == 0) {
				return MidgardLayerUtil.FOREST ;
			} else {
				return i == 1 ? MidgardLayerUtil.FOREST : MidgardLayerUtil.PLAINS ;
			}
		}
	}
}