package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

import java.util.Optional;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BiomeInit;

public enum MidgardBiomeEdgeLayer implements ICastleTransformer {
	INSTANCE;

	private static final int DESERT = Registry.BIOME.getId(BiomeInit.VANILLA_DESERT_BIOME.get());
    private static final int MOUNTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAINS_BIOME.get());
    private static final int WOODED_MOUNTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_WOODED_MOUNTAINS_BIOME.get());
    private static final int SNOWY_TUNDRA = Registry.BIOME.getId(BiomeInit.VANILLA_SNOWY_TUNDRA_BIOME.get());
    private static final int JUNGLE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_BIOME.get());
    private static final int JUNGLE_HILLS = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_HILLS_BIOME.get());
    private static final int JUNGLE_EDGE = Registry.BIOME.getId(BiomeInit.VANILLA_JUNGLE_EDGE_BIOME.get());
    private static final int BADLANDS = Registry.BIOME.getId(BiomeInit.VANILLA_BADLANDS_BIOME.get());
    private static final int BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_BADLANDS_PLATEAU_BIOME.get());
    private static final int WOODED_BADLANDS_PLATEAU = Registry.BIOME.getId(BiomeInit.VANILLA_WOODED_BADLANDS_PLATEAU_BIOME.get());
    private static final int PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_PLAINS_BIOME.get());
    private static final int GIANT_TREE_TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_GIANT_TREE_TAIGA_BIOME.get());
    private static final int MOUNTAIN_EDGE = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAIN_EDGE_BIOME.get());
    private static final int SWAMP = Registry.BIOME.getId(BiomeInit.VANILLA_SWAMP_BIOME.get());
    private static final int TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_TAIGA_BIOME.get());
    private static final int SNOWY_TAIGA = Registry.BIOME.getId(BiomeInit.VANILLA_SNOWY_TAIGA_BIOME.get());
	
    private static final int CHARPARRAL = Registry.BIOME.getId(BiomeInit.MIDGARD_CHARPARRAL_TROPICAL_BIOME.get());
    
    
	@Override
	public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {

		int[] outBiomeId = new int[1];

		
		//ISLAND
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				BiomeInit.MIDGARD_TROPICAL_ISLAND_BIOME.get(), BiomeInit.VANILLA_DEEP_WARM_OCEAN_BIOME.get())) {
			
			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer MIDGARD_TROPICAL_ISLAND_BIOME <---> VANILLA_DEEP_WARM_OCEAN_BIOME" );
			
			return outBiomeId[0];
		}		
		
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				BiomeInit.MIDGARD_VOLCANIC_ISLAND_BIOME.get(), BiomeInit.VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get())) {

			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer MIDGARD_VOLCANIC_ISLAND_BIOME <---> VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME" );

			return outBiomeId[0];
		}		
		
		//CHARPARRAL
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				CHARPARRAL, JUNGLE_EDGE)) {

			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer MIDGARD_CHARPARRAL_TROPICAL_BIOME <---> VANILLA_JUNGLE_EDGE_BIOME" );

			return outBiomeId[0];
		}	
		
		//MOUNTAINS
		if (this.replaceBiomeEdgeIfNecessary(outBiomeId, north, west, south, east, center,
				MOUNTAINS, MOUNTAIN_EDGE)) {
			
			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer MOUNTAINS <---> MOUNTAIN_EDGE" );

			return outBiomeId[0];
		}
		
		//BADLANDS
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				WOODED_BADLANDS_PLATEAU, BADLANDS)) {

			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer WOODED_BADLANDS_PLATEAU <---> BADLANDS" );

			return outBiomeId[0];
		}	
		
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				BADLANDS_PLATEAU, BADLANDS)) {

			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer BADLANDS_PLATEAU <---> BADLANDS" );

			return outBiomeId[0];
		}	

		//GIANT TREE TAIGA
		if (this.replaceBiomeEdge(outBiomeId, north, west, south, east, center,
				GIANT_TREE_TAIGA, TAIGA)) {

			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer GIANT_TREE_TAIGA <---> TAIGA" );

			return outBiomeId[0];
		}	
		
		
		if (center == DESERT && (north == SNOWY_TUNDRA || east == SNOWY_TUNDRA
				|| west == SNOWY_TUNDRA || south == SNOWY_TUNDRA)) {
			
			Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer DESERT <---> SNOWY_TUNDRA INTO WOODED_MOUNTAINS" );

			return WOODED_MOUNTAINS;
		} else {
			if (center == SWAMP) {
				if (north == DESERT || east == DESERT || west == DESERT || south == DESERT
						|| north == SNOWY_TAIGA || east == SNOWY_TAIGA || west == SNOWY_TAIGA
						|| south == SNOWY_TAIGA || north == SNOWY_TUNDRA || east == SNOWY_TUNDRA
						|| west == SNOWY_TUNDRA || south == SNOWY_TUNDRA) {
					
					Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer SWAMP <---> DESERT/SNOWY_TUNDRA into PLAINS" );

					return PLAINS;
				}

				if (north == JUNGLE || south == JUNGLE || east == JUNGLE || west == JUNGLE
						|| north == JUNGLE_HILLS || south == JUNGLE_HILLS || east == JUNGLE_HILLS
						|| west == JUNGLE_HILLS) {
					
					Midgard.LOGGER.info("MidgardBiomeEdgeLayer : Edge Layer SWAMP <---> JUNGLE/JUNGLE_HILLS into JUNGLE_EDGE" );

					return JUNGLE_EDGE;
				}
			}
		}
		
		
		return center;
	}
	
	private boolean replaceBiomeEdgeIfNecessary(int[] outId, int northBiomeId, int southBiomeId, int eastBiomeId,
			int westBiomeId, int biomeId, int fromBiome, int toBiome) {
		if (!LayerUtil.areBiomesSimilar(biomeId, fromBiome)) {
			return false;
		} else {
			if (this.canBiomesBeNeighbors(northBiomeId, fromBiome) && this.canBiomesBeNeighbors(southBiomeId, fromBiome)
					&& this.canBiomesBeNeighbors(westBiomeId, fromBiome)
					&& this.canBiomesBeNeighbors(eastBiomeId, fromBiome)) {
				outId[0] = biomeId;
			} else {
				outId[0] = toBiome;
			}

			return true;
		}
	}
	
	private boolean canBiomesBeNeighbors(int biomeIdA, int biomeIdB) {
		if (LayerUtil.areBiomesSimilar(biomeIdA, biomeIdB)) {
			return true;
		} else {
			Biome biomeA = Registry.BIOME.getByValue(biomeIdA);
			Biome biomeB = Registry.BIOME.getByValue(biomeIdB);
			if (biomeA != null && biomeB != null) {
				Biome.TempCategory catA = biomeA.getTempCategory();
				Biome.TempCategory catB = biomeB.getTempCategory();
				return catA == catB || catA == Biome.TempCategory.MEDIUM || catB == Biome.TempCategory.MEDIUM;
			} else {
				return false;
			}
		}
	}


	
    private boolean replaceBiomeEdge(int[] outId, int north, int west, int south, int east, int center, Biome fromBiome, Biome toBiome) {
        return this.replaceBiomeEdge(outId, north, west, south, east, center, Registry.BIOME.getId(fromBiome), Registry.BIOME.getId(toBiome));
    }

	boolean replaceBiomeEdge(int[] outId, int north, int west, int south, int east, int center, int from, int to) {
		if (center != from) {
			return false;
		} else {
			if (LayerUtil.areBiomesSimilar(north, from) && LayerUtil.areBiomesSimilar(east, from)
					&& LayerUtil.areBiomesSimilar(west, from) && LayerUtil.areBiomesSimilar(south, from)) {
				outId[0] = center;
			} else {
				outId[0] = to;
			}

			return true;
		}	

	}

}
