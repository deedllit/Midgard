package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public class MidgardEdgeLayer {
	public static enum CoolWarm implements ICastleTransformer {
		INSTANCE;

		public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
			return center != MidgardLayerUtil.PLAINS
					|| north != MidgardLayerUtil.MOUTAINS && west != MidgardLayerUtil.MOUTAINS
							&& east != MidgardLayerUtil.MOUTAINS && south != MidgardLayerUtil.MOUTAINS
							&& north != MidgardLayerUtil.FOREST && west != MidgardLayerUtil.FOREST
							&& east != MidgardLayerUtil.FOREST && south != MidgardLayerUtil.FOREST ? center
									: MidgardLayerUtil.DESERT;
		}
	}

	public static enum HeatIce implements ICastleTransformer {
		INSTANCE;

		public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
			return center != MidgardLayerUtil.FOREST
					|| north != MidgardLayerUtil.PLAINS && west != MidgardLayerUtil.PLAINS
							&& east != MidgardLayerUtil.PLAINS && south != MidgardLayerUtil.PLAINS
							&& north != MidgardLayerUtil.DESERT && west != MidgardLayerUtil.DESERT
							&& east != MidgardLayerUtil.DESERT && south != MidgardLayerUtil.DESERT ? center
									: MidgardLayerUtil.MOUTAINS;
		}
	}

	public static enum Special implements IC0Transformer {
		INSTANCE;

		public int apply(INoiseRandom context, int value) {
			if (!MidgardLayerUtil.isShallowOcean(value) && context.random(13) == 0) {
				value |= 1 + context.random(15) << 8 & 3840;
			}

			return value;
		}
	}
}