package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public class MidgardBiomeLayer implements IC0Transformer {
	private static final int BIRCH_FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_BIRCH_FOREST_BIOME.get());
	private static final int DESERT = Registry.BIOME.getId(BiomeInit.VANILLA_DESERT_BIOME.get());
	private static final int MOUNTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAINS_BIOME.get());
	private static final int FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_FOREST_BIOME.get());
	private static final int SNOWY_TUNDRA = Registry.BIOME.getId(BiomeInit.VANILLA_SNOWY_TUNDRA_BIOME.get());
	private static final int JUNGLE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_BIOME.get());
	private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_BADLANDS_PLATEAU_BIOME.get());
	private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_WOODED_BADLANDS_PLATEAU_BIOME.get());
	private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get());
	private static final int PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_PLAINS_BIOME.get());
	private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_GIANT_TREE_TAIGA_BIOME.get());
	private static final int DARK_FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_DARK_FOREST_BIOME.get());
	private static final int SAVANNA = Registry.BIOME.getId(BiomeInit.VANILLA_SAVANNA_BIOME.get());
	private static final int SWAMP = Registry.BIOME.getId(BiomeInit.VANILLA_SWAMP_BIOME.get());
	private static final int TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_TAIGA_BIOME.get());
	private static final int SNOWY_TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_SNOWY_TAIGA_BIOME.get());
	private final int field_227472_v_;
	@SuppressWarnings("unchecked")
	private java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes = new java.util.ArrayList[net.minecraftforge.common.BiomeManager.BiomeType
			.values().length];

	public MidgardBiomeLayer(WorldType p_i225882_1_, int p_i225882_2_) {
		this.field_227472_v_ = -1;
		for (net.minecraftforge.common.BiomeManager.BiomeType type : net.minecraftforge.common.BiomeManager.BiomeType
				.values()) {
			com.google.common.collect.ImmutableList<net.minecraftforge.common.BiomeManager.BiomeEntry> biomesToAdd = net.minecraftforge.common.BiomeManager
					.getBiomes(type);
			int idx = type.ordinal();

			if (biomes[idx] == null)
				biomes[idx] = new java.util.ArrayList<net.minecraftforge.common.BiomeManager.BiomeEntry>();
			if (biomesToAdd != null)
				biomes[idx].addAll(biomesToAdd);
		}

		int desertIdx = net.minecraftforge.common.BiomeManager.BiomeType.DESERT.ordinal();

		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_DESERT_BIOME.get(), 10));
		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_SAVANNA_BIOME.get(), 10));
		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_MOUNTAINS_BIOME.get(), 10));

		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_SWAMP_BIOME.get(), 10));
		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_TAIGA_BIOME.get(), 10));
		biomes[desertIdx].add(new net.minecraftforge.common.BiomeManager.BiomeEntry(BiomeInit.VANILLA_PLAINS_BIOME.get(), 10));

	}

	public int apply(INoiseRandom context, int value) {
		if (this.field_227472_v_ >= 0) {
			return this.field_227472_v_;
		} else {
			int i = (value & 3840) >> 8;
			value = value & -3841;
			
			Midgard.LOGGER.info("MidgardBiomeLayer : " + i + " " +  value) ;
			
			if (!MidgardLayerUtil.isOcean(value) && value != MUSHROOM_FIELDS) {
				switch (value) {
				case 1:
					if (i > 0) {
						return context.random(3) == 0 ? BADLANDS_PLATEAU : WOODED_BADLANDS_PLATEAU;
					}

					return Registry.BIOME
							.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.DESERT,
									context).biome);
				case 2:
					if (i > 0) {
						return JUNGLE;
					}

					return Registry.BIOME
							.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.WARM,
									context).biome);
				case 3:
					if (i > 0) {
						return GIANT_TREE_TAIGA;
					}

					return Registry.BIOME
							.getId(getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.COOL,
									context).biome);
				case 4:
					return Registry.BIOME.getId(
							getWeightedBiomeEntry(net.minecraftforge.common.BiomeManager.BiomeType.ICY, context).biome);
				default:
					return MUSHROOM_FIELDS;
				}
			} else {
				return value;
			}
		}
	}

	protected net.minecraftforge.common.BiomeManager.BiomeEntry getWeightedBiomeEntry(
			net.minecraftforge.common.BiomeManager.BiomeType type, INoiseRandom context) {
		java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry> biomeList = biomes[type.ordinal()];
		int totalWeight = net.minecraft.util.WeightedRandom.getTotalWeight(biomeList);
		int weight = net.minecraftforge.common.BiomeManager.isTypeListModded(type) ? context.random(totalWeight)
				: context.random(totalWeight / 10) * 10;
		return (net.minecraftforge.common.BiomeManager.BiomeEntry) net.minecraft.util.WeightedRandom
				.getRandomItem(biomeList, weight);
	}
}
