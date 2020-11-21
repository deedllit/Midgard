package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum MidgardMixRiverLayer implements IAreaTransformer2, IDimOffset0Transformer {
	INSTANCE;

	public int apply(INoiseRandom context, IArea biomeArea, IArea riverArea, int x, int z) {

		int biomeId = biomeArea.getValue(x, z);
		int riverId = riverArea.getValue(x, z);
		Biome biome = Registry.BIOME.getByValue(biomeId);

		if (MidgardLayerUtil.isOcean(biomeId)) {
			return biomeId;
		} else if (riverId == MidgardLayerUtil.RIVER) {
			if (biomeId == MidgardLayerUtil.SNOWY_TUNDRA) {
				return MidgardLayerUtil.FROZEN_RIVER;
			} else {
				return biomeId != MidgardLayerUtil.MUSHROOM_FIELDS && biomeId != MidgardLayerUtil.MUSHROOM_FIELD_SHORE
						? riverId & 255
						: MidgardLayerUtil.MUSHROOM_FIELD_SHORE;
			}
		} else {
			return biomeId;
		}

	}
}