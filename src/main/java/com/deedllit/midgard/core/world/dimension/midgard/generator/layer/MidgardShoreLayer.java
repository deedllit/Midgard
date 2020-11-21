package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MidgardShoreLayer implements ICastleTransformer {
	INSTANCE;

	private static final int BEACH = Registry.BIOME.getId(BiomeInit.VANILLA_BEACH_BIOME.get());
	private static final int SNOWY_BEACH = Registry.BIOME.getId(BiomeInit.VANILLA_SNOWY_BEACH_BIOME.get());
	private static final int DESERT = Registry.BIOME.getId(BiomeInit.VANILLA_DESERT_BIOME.get());
	private static final int MOUNTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAINS_BIOME.get());
	private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_WOODED_MOUNTAINS_BIOME.get());
	private static final int FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_FOREST_BIOME.get());
	private static final int JUNGLE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_BIOME.get());
	private static final int JUNGLE_EDGE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_EDGE_BIOME.get());
	private static final int JUNGLE_HILLS = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_HILLS_BIOME.get());
	private static final int BADLANDS = Registry.BIOME.getId(BiomeInit.VANILLA_BADLANDS_BIOME.get());
	private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_WOODED_BADLANDS_PLATEAU_BIOME.get());
	private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_BADLANDS_PLATEAU_BIOME.get());
	private static final int ERODED_BADLANDS = Registry.BIOME.getId(BiomeInit.VANILLA_ERODED_BADLANDS_BIOME.get());
	private static final int MODIFIED_WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_MODIFIED_WOODED_BADLANDS_PLATEAU_BIOME.get());
	private static final int MODIFIED_BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_MODIFIED_BADLANDS_PLATEAU_BIOME.get());
	private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get());
	private static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(BiomeInit.VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get());
	private static final int RIVER = Registry.BIOME.getId(BiomeInit.VANILLA_RIVER_BIOME.get());
	private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAIN_EDGE_BIOME.get());
	private static final int STONE_SHORE = Registry.BIOME.getId(BiomeInit.VANILLA_STONE_SHORE_BIOME.get());
	private static final int SWAMP = Registry.BIOME.getId(BiomeInit.VANILLA_SWAMP_BIOME.get());
	private static final int TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_TAIGA_BIOME.get());

	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
		Biome biome = Registry.BIOME.getByValue(center);
		if (center == MUSHROOM_FIELDS) {
			if (MidgardLayerUtil.isShallowOcean(north) || MidgardLayerUtil.isShallowOcean(west)
					|| MidgardLayerUtil.isShallowOcean(south) || MidgardLayerUtil.isShallowOcean(east)) {
				return MUSHROOM_FIELD_SHORE;
			}
		} else if (biome != null && biome.getCategory() == Biome.Category.JUNGLE) {
			if (!isJungleCompatible(north) || !isJungleCompatible(west) || !isJungleCompatible(south)
					|| !isJungleCompatible(east)) {
				return JUNGLE_EDGE;
			}

			if (MidgardLayerUtil.isOcean(north) || MidgardLayerUtil.isOcean(west) || MidgardLayerUtil.isOcean(south)
					|| MidgardLayerUtil.isOcean(east)) {
				return BEACH;
			}
		} else if (center != MOUNTAINS && center != WOODED_MOUNTAINS && center != MOUNTAIN_EDGE) {
			if (biome != null && biome.getPrecipitation() == Biome.RainType.SNOW) {
				if (!MidgardLayerUtil.isOcean(center) && (MidgardLayerUtil.isOcean(north) || MidgardLayerUtil.isOcean(west)
						|| MidgardLayerUtil.isOcean(south) || MidgardLayerUtil.isOcean(east))) {
					return SNOWY_BEACH;
				}
			} else if (center != BADLANDS && center != WOODED_BADLANDS_PLATEAU) {
				if (!MidgardLayerUtil.isOcean(center) && center != RIVER && center != SWAMP
						&& (MidgardLayerUtil.isOcean(north) || MidgardLayerUtil.isOcean(west)
								|| MidgardLayerUtil.isOcean(south) || MidgardLayerUtil.isOcean(east))) {
					return BEACH;
				}
			} else if (!MidgardLayerUtil.isOcean(north) && !MidgardLayerUtil.isOcean(west)
					&& !MidgardLayerUtil.isOcean(south) && !MidgardLayerUtil.isOcean(east)
					&& (!this.isMesa(north) || !this.isMesa(west) || !this.isMesa(south) || !this.isMesa(east))) {
				return DESERT;
			}
		} else if (!MidgardLayerUtil.isOcean(center) && (MidgardLayerUtil.isOcean(north) || MidgardLayerUtil.isOcean(west)
				|| MidgardLayerUtil.isOcean(south) || MidgardLayerUtil.isOcean(east))) {
			return STONE_SHORE;
		}

		return center;
	}

	private static boolean isJungleCompatible(int p_151631_0_) {
		if (Registry.BIOME.getByValue(p_151631_0_) != null
				&& Registry.BIOME.getByValue(p_151631_0_).getCategory() == Biome.Category.JUNGLE) {
			return true;
		} else {
			return p_151631_0_ == JUNGLE_EDGE || p_151631_0_ == JUNGLE || p_151631_0_ == JUNGLE_HILLS
					|| p_151631_0_ == FOREST || p_151631_0_ == TAIGA || MidgardLayerUtil.isOcean(p_151631_0_);
		}
	}

	private boolean isMesa(int p_151633_1_) {
		return p_151633_1_ == BADLANDS || p_151633_1_ == WOODED_BADLANDS_PLATEAU || p_151633_1_ == BADLANDS_PLATEAU
				|| p_151633_1_ == ERODED_BADLANDS || p_151633_1_ == MODIFIED_WOODED_BADLANDS_PLATEAU
				|| p_151633_1_ == MODIFIED_BADLANDS_PLATEAU;
	}
}
