package com.deedllit.midgard.init;

import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.world.dimension.midgard.biomes.*;
import com.deedllit.midgard.core.world.dimension.vanilla.biomes.*;
import com.deedllit.midgard.world.gen.worldtype.WorldTypeMidgard;
import com.google.common.collect.Sets;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeInit {

	public static WorldTypeMidgard worldType;
	public static final DeferredRegister<Biome> BIOMES = new DeferredRegister<>(ForgeRegistries.BIOMES, Midgard.MOD_ID) ; 	
	public static Set<Biome> setMidgard = Sets.newHashSet();
	
	//https://www.mathsisfun.com/hexadecimal-decimal-colors.html
	

/*
 * OVERWORLD
 */
	
	
	public static final RegistryObject<Biome> VANILLA_BADLANDS_BIOME = 
			BIOMES.register("vanilla_badlands_biome", () -> new VanillaBadlandsBiome());

	public static final RegistryObject<Biome> VANILLA_BADLANDS_PLATEAU_BIOME = 
			BIOMES.register("vanilla_badlands_plateau_biome", () -> new VanillaBadlandsPlateauBiome());

	public static final RegistryObject<Biome> VANILLA_BAMBOO_JUNGLE_BIOME = 
			BIOMES.register("vanilla_bamboo_jungle_biome", () -> new VanillaBambooJungleBiome());

	public static final RegistryObject<Biome> VANILLA_BAMBOO_JUNGLE_HILLS_BIOME = 
			BIOMES.register("vanilla_bamboo_jungle_hills_biome", () -> new VanillaBambooJungleHillsBiome());

	public static final RegistryObject<Biome> VANILLA_BEACH_BIOME = 
			BIOMES.register("vanilla_beach_biome", () -> new VanillaBeachBiome());

	public static final RegistryObject<Biome> VANILLA_BIRCH_FOREST_BIOME = 
			BIOMES.register("vanilla_birch_forest_biome", () -> new VanillaBirchForestBiome());

	public static final RegistryObject<Biome> VANILLA_BIRCH_FOREST_HILLS_BIOME = 
			BIOMES.register("vanilla_birch_forest_hills_biome", () -> new VanillaBirchForestHillsBiome());

	
	public static final RegistryObject<Biome> VANILLA_COLD_OCEAN_BIOME = 
			BIOMES.register("vanilla_cold_ocean_biome", () -> new VanillaColdOceanBiome());
	
	public static final RegistryObject<Biome> VANILLA_DARK_FOREST_BIOME = 
			BIOMES.register("vanilla_dark_forest_biome", () -> new VanillaDarkForestBiome());

	public static final RegistryObject<Biome> VANILLA_DARK_FOREST_HILL_BIOME = 
			BIOMES.register("vanilla_dark_forest_hill_biome", () -> new VanillaDarkForestHillsBiome());

	public static final RegistryObject<Biome> VANILLA_DEEP_COLD_OCEAN_BIOME = 
			BIOMES.register("vanilla_deep_cold_ocean_biome", () -> new VanillaDeepColdOceanBiome());

	public static final RegistryObject<Biome> VANILLA_DEEP_FROZEN_OCEAN_BIOME = 
			BIOMES.register("vanilla_deep_frozen_ocean_biome", () -> new VanillaDeepFrozenOceanBiome());

	public static final RegistryObject<Biome> VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME = 
			BIOMES.register("vanilla_deep_luke_warm_ocean_biome",() -> new VanillaDeepLukewarmOceanBiome());

	public static final RegistryObject<Biome> VANILLA_DEEP_OCEAN_BIOME = 
			BIOMES.register("vanilla_deep_ocean_biome", () -> new VanillaDeepOceanBiome());

	public static final RegistryObject<Biome> VANILLA_DEEP_WARM_OCEAN_BIOME = 
			BIOMES.register("vanilla_deep_warm_ocean_biome", () -> new VanillaDeepWarmOceanBiome());

	public static final RegistryObject<Biome> VANILLA_DESERT_BIOME = 
			BIOMES.register("vanilla_desert_biome", () -> new VanillaDesertBiome());

	public static final RegistryObject<Biome> VANILLA_DESERT_HILLS_BIOME = 
			BIOMES.register("vanilla_desert_hills_biome", () -> new VanillaDesertHillsBiome());

	public static final RegistryObject<Biome> VANILLA_DESERT_LAKES_BIOME = 
			BIOMES.register("vanilla_desert_lakes_biome", () -> new VanillaDesertLakesBiome());

	public static final RegistryObject<Biome> VANILLA_ERODED_BADLANDS_BIOME = 
			BIOMES.register("vanilla_eroded_badlands_biome", () -> new VanillaErodedBadlandsBiome());

	public static final RegistryObject<Biome> VANILLA_FLOWER_FOREST_BIOME = 
			BIOMES.register("vanilla_flower_forest_biome", () -> new VanillaFlowerForestBiome());

	public static final RegistryObject<Biome> VANILLA_FOREST_BIOME = 
			BIOMES.register("vanilla_forest_biome",() -> new VanillaForestBiome());

	public static final RegistryObject<Biome> VANILLA_FROZEN_OCEAN_BIOME = 
			BIOMES.register("vanilla_frozen_ocean_biome",() -> new VanillaFrozenOceanBiome());

	public static final RegistryObject<Biome> VANILLA_FROZEN_RIVER_BIOME = 
			BIOMES.register("vanilla_frozen_river_biome",() -> new VanillaFrozenRiverBiome());

	public static final RegistryObject<Biome> VANILLA_GIANT_SPRUCE_TAIGA_BIOME = 
			BIOMES.register("vanilla_giant_spruce_taiga_biome",() -> new VanillaGiantSpruceTaigaBiome());

	public static final RegistryObject<Biome> VANILLA_GIANT_SPRUCE_TAIGA_HILLS_BIOME = 
			BIOMES.register("vanilla_giant_spruce_taiga_hills_biome",() -> new VanillaGiantSpruceTaigaHillsBiome());

	public static final RegistryObject<Biome> VANILLA_GIANT_TREE_TAIGA_BIOME = 
			BIOMES.register("vanilla_giant_tree_taiga_biome", () -> new VanillaGiantTreeTaigaBiome());

	public static final RegistryObject<Biome> VANILLA_GIANT_TREE_TAIGA_HILLS_BIOME = 
			BIOMES.register("vanilla_giant_tree_taiga_hills_biome", () -> new VanillaGiantTreeTaigaHillsBiome());

	public static final RegistryObject<Biome> VANILLA_GRAVELLY_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_gravelly_mountains_biome", () -> new VanillaGravellyMountainsBiome());

	public static final RegistryObject<Biome> VANILLA_JUNGLE_BIOME = 
			BIOMES.register("vanilla_jungle_biome",() -> new VanillaJungleBiome());

	public static final RegistryObject<Biome> VANILLA_JUNGLE_EDGE_BIOME = 
			BIOMES.register("vanilla_jungle_edge_biome",() -> new VanillaJungleEdgeBiome());

	public static final RegistryObject<Biome> VANILLA_JUNGLE_HILLS_BIOME = 
			BIOMES.register("vanilla_jungle_hills_biome", () -> new VanillaJungleHillsBiome());

	public static final RegistryObject<Biome> VANILLA_LUKE_WARM_OCEAN_BIOME = 
			BIOMES.register("vanilla_luke_warm_ocean_biome", () -> new VanillaLukewarmOceanBiome());

	public static final RegistryObject<Biome> VANILLA_MODIFIED_BADLANDS_PLATEAU_BIOME = 
			BIOMES.register("vanilla_modified_bandlands_plateau_biome", () -> new VanillaModifiedBadlandsPlateauBiome());
	
	public static final RegistryObject<Biome> VANILLA_MODIFIED_GRAVELLY_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_modified_gravelly_mountains_biome", () -> new VanillaModifiedGravellyMountainsBiome());

	public static final RegistryObject<Biome> VANILLA_MODIFIED_JUNGLE_BIOME = 
			BIOMES.register("vanilla_modified_jungle_biome", () -> new VanillaModifiedJungleBiome());

	public static final RegistryObject<Biome> VANILLA_MODIFIED_JUNGLE_EDGE_BIOME = 
			BIOMES.register("vanilla_modified_jungle_edge_biome", () -> new VanillaModifiedJungleEdgeBiome());
	
	public static final RegistryObject<Biome> VANILLA_MODIFIED_WOODED_BADLANDS_PLATEAU_BIOME = 
			BIOMES.register("vanilla_modified_wooded_badlands_plateau_biome", () -> new VanillaModifiedWoodedBadlandsPlateauBiome());
	
	public static final RegistryObject<Biome> VANILLA_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_mountains_biome", () -> new VanillaMountainsBiome());
	
	public static final RegistryObject<Biome> VANILLA_MOUNTAIN_EDGE_BIOME = 
			BIOMES.register("vanilla_mountain_edge_biome", () -> new VanillaMountainEdgeBiome());

	public static final RegistryObject<Biome> VANILLA_MUSHROOM_FIELDS_BIOME = 
			BIOMES.register("vanilla_mushroom_fields_biome", () -> new VanillaMushroomFieldsBiome());

	public static final RegistryObject<Biome> VANILLA_MUSHROOM_FIELD_SHORE_BIOME = 
			BIOMES.register("vanilla_mushroom_field_shore_biome", () -> new VanillaMushroomFieldShoreBiome());
	
	public static final RegistryObject<Biome> VANILLA_OCEAN_BIOME = 
			BIOMES.register("vanilla_ocean_biome", () -> new VanillaOceanBiome());

	public static final RegistryObject<Biome> VANILLA_PLAINS_BIOME = 
			BIOMES.register("vanilla_plains_biome", () -> new VanillaPlainsBiome());

	public static final RegistryObject<Biome> VANILLA_RIVER_BIOME = 
			BIOMES.register("vanilla_river_biome", () -> new VanillaRiverBiome());

	public static final RegistryObject<Biome> VANILLA_SAVANNA_BIOME = 
			BIOMES.register("vanilla_savanna_biome", () -> new VanillaSavannaBiome());

	public static final RegistryObject<Biome> VANILLA_SAVANNA_PLATEAU_BIOME = 
			BIOMES.register("vanilla_savanna_plateau_biome", () -> new VanillaSavannaPlateauBiome());

	public static final RegistryObject<Biome> VANILLA_SHATTERED_SAVANNA_BIOME = 
			BIOMES.register("vanilla_shattered_savanna_biome", () -> new VanillaShatteredSavannaBiome());

	public static final RegistryObject<Biome> VANILLA_SHATTERED_SAVANNA_PLATEAU_BIOME = 
			BIOMES.register("vanilla_shattered_savanna_plateau_biome", () -> new VanillaShatteredSavannaPlateauBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_BEACH_BIOME = 
			BIOMES.register("vanilla_snowy_beach_biome", () -> new VanillaSnowyBeachBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_snowy_mountains_biome", () -> new VanillaSnowyMountainsBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_TAIGA_BIOME = 
			BIOMES.register("vanilla_snowy_taiga_biome", () -> new VanillaSnowyTaigaBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_TAIGA_HILLS_BIOME = 
			BIOMES.register("vanilla_snowy_taiga_hills_biome", () -> new VanillaSnowyTaigaHillsBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_TAIGA_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_snowy_taiga_mountains_biome", () -> new VanillaSnowyTaigaMountainsBiome());

	public static final RegistryObject<Biome> VANILLA_SNOWY_TUNDRA_BIOME = 
			BIOMES.register("vanilla_snowy_tundra_biome", () -> new VanillaSnowyTundraBiome());

	public static final RegistryObject<Biome> VANILLA_SUNFLOWER_PLAINS_BIOME = 
			BIOMES.register("vanilla_sunflower_plains_biome", () -> new VanillaSunflowerPlainsBiome());

	public static final RegistryObject<Biome> VANILLA_STONE_SHORE_BIOME = 
			BIOMES.register("vanilla_stone_shore_biome", () -> new VanillaStoneShoreBiome());

	public static final RegistryObject<Biome> VANILLA_SWAMP_BIOME = 
			BIOMES.register("vanilla_swamp_biome", () -> new VanillaSwampBiome());

	public static final RegistryObject<Biome> VANILLA_SWAMP_HILLS_BIOME = 
			BIOMES.register("vanilla_swamp_hills_biome", () -> new VanillaSwampHillsBiome());

	public static final RegistryObject<Biome> VANILLA_TAIGA_BIOME = 
			BIOMES.register("vanilla_taiga_biome", () -> new VanillaTaigaBiome());

	public static final RegistryObject<Biome> VANILLA_TAIGA_HILLS_BIOME = 
			BIOMES.register("vanilla_taiga_hills_biome",() -> new VanillaTaigaHillsBiome());

	public static final RegistryObject<Biome> VANILLA_TAIGA_MOUNTAIN_BIOME = 
			BIOMES.register("vanilla_taiga_mountains_biome", () -> new VanillaTaigaMountainsBiome());

	public static final RegistryObject<Biome> VANILLA_TALL_BIRCH_FOREST_BIOME = 
			BIOMES.register("vanilla_tall_birch_forest_biome", () -> new VanillaTallBirchForestBiome());

	public static final RegistryObject<Biome> VANILLA_TALL_BIRCH_HILLS_BIOME = 
			BIOMES.register("vanilla_tall_birch_hills_biome", () -> new VanillaTallBirchHillsBiome());

	public static final RegistryObject<Biome> VANILLA_WARM_OCEAN_BIOME = 
			BIOMES.register("vanilla_warm_ocean_biome", () -> new VanillaWarmOceanBiome());

	public static final RegistryObject<Biome> VANILLA_WOODED_BADLANDS_PLATEAU_BIOME = 
			BIOMES.register("vanilla_wooded_badlands_plateau_biome", () -> new VanillaWoodedBadlandsPlateauBiome());

	public static final RegistryObject<Biome> VANILLA_WOODED_HILLS_BIOME = 
			BIOMES.register("vanilla_wooded_hills_biome", () -> new VanillaWoodedHillsBiome());

	public static final RegistryObject<Biome> VANILLA_WOODED_MOUNTAINS_BIOME = 
			BIOMES.register("vanilla_wooded_mountains_biome", () -> new VanillaWoodedMountainsBiome());
	
	

	/*
 * MIDGARD
 */

	public static final RegistryObject<Biome> MIDGARD_AMAZONIA_BIOME = 
			BIOMES.register("midgard_amazonia_biome", () -> new MidgardAmazoniaBiome());	

	public static final RegistryObject<Biome> MIDGARD_BOHOL_BIOME = 
			BIOMES.register("midgard_bohol_biome", () -> new MidgardBoholBiome());	

	public static final RegistryObject<Biome> MIDGARD_ALPINE_GRINDELWALD_BIOME = 
			BIOMES.register("midgard_alpine_grindelwald_biome", () -> new MidgardAlpineGrindelwaldBiome());	

	public static final RegistryObject<Biome> DESERT_WAVE = 
			BIOMES.register("midgard_desert_wave", () -> new MidgardDesertWave());	
	
	public static final RegistryObject<Biome> DESERT_DUNE = 
			BIOMES.register("midgard_desert_dune", () -> new MidgardDesertDune());	

	public static final RegistryObject<Biome> MIDGARD_RICE_PLAINS_BIOME = 
		BIOMES.register("midgard_rice_plains_biome", () -> new MidgardRicePlainsBiome());	

	public static final RegistryObject<Biome> MIDGARD_ALPINE_TUNDRA_BIOME = 
			BIOMES.register("midgard_alpine_tundra", () -> new MidgardAlpineTundraBiome());	

	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_TROPICAL_BIOME = 
			BIOMES.register("midgard_charparral_tropical", () -> new MidgardChaparralTropicalBiome());	

	public static final RegistryObject<Biome> MIDGARD_IRON_WOOD_BIOME = 
			BIOMES.register("midgard_iron_wood", () -> new MidgardIronWoodBiome());
	
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_BIOME = 
			BIOMES.register("midgard_mangrove", () -> new MidgardMangroveBiome());
	
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_DRYER_BIOME = 
			BIOMES.register("midgard_mangrove_dryer", () -> new MidgardMangroveDryerBiome());	

	public static final RegistryObject<Biome> MIDGARD_RAINBOW_MOUTAIN_BIOME = 
			BIOMES.register("midgard_rainbow_moutain", () -> new MidgardRainbowMoutainBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_RAINBOW_PLAINS_BIOME = 
			BIOMES.register("midgard_rainbow_plains", () -> new MidgardRainbowPlainsBiome());

	public static final RegistryObject<Biome> MIDGARD_TEAK_FOREST_BIOME = 
			BIOMES.register("midgard_teak_forest", () -> new MidgardTeakForestBiome());	

	public static final RegistryObject<Biome> MIDGARD_THOUSAND_LAKES_BIOME = 
			BIOMES.register("midgard_thousand_lakes", () -> new MidgardThousandLakesBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_TROPICAL_BEACH_BIOME = 
			BIOMES.register("midgard_tropical_beach", () -> new MidgardTropicalBeachBiome());	

	public static final RegistryObject<Biome> MIDGARD_TROPICAL_ISLAND_BIOME = 
			BIOMES.register("midgard_tropical_island", () -> new MidgardTropicalIslandBiome());	

	public static final RegistryObject<Biome> MIDGARD_VOLCANIC_ISLAND_BIOME = 
			BIOMES.register("midgard_volcanic_island", () -> new MidgardVolcanicIslandBiome());	

	/*
	public static final RegistryObject<Biome> MIDGARD_MANGROVE_RIVER = BIOMES
			.register("midgard_mangrove_river",
					() -> new MidgardMangroveRiverBiome());	

	public static final RegistryObject<Biome> MIDGARD_FYNBOS = BIOMES
			.register("midgard_fynbos",
					() -> new MidgardFynbos());	
				
	public static final RegistryObject<Biome> MIDGARD_VOLCANIC = BIOMES
			.register("midgard_volcanic",
					() -> new MidgardVolcanicBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_CHARPARRAL_DESERT = BIOMES
			.register("midgard_charparral_desert",
					() -> new MidgardChaparralDesertBiome());	
	
	public static final RegistryObject<Biome> MIDGARD_SPOOKY = BIOMES
			.register("midgard_spooky",
					() -> new MidgardSpookyBiome());	
	*/
	
	
	
	
	
	public static void onRegisterBiomes(RegistryEvent.Register<Biome> event) {
	}
	
	
	public static void onInit() {
	}
	
	
	
	private static void registerMidgardBiomes() {
		setMidgard.add(VANILLA_BADLANDS_BIOME.get()) ; 
		setMidgard.add(VANILLA_BADLANDS_PLATEAU_BIOME.get()) ; 
		setMidgard.add(VANILLA_BAMBOO_JUNGLE_BIOME.get()) ; 
		setMidgard.add(VANILLA_BAMBOO_JUNGLE_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_BEACH_BIOME.get()) ; 
		setMidgard.add(VANILLA_BIRCH_FOREST_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_COLD_OCEAN_BIOME.get()) ; 		
		setMidgard.add(VANILLA_DARK_FOREST_BIOME.get()) ; 
		setMidgard.add(VANILLA_DARK_FOREST_HILL_BIOME.get()) ; 
		setMidgard.add(VANILLA_DEEP_COLD_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_DEEP_FROZEN_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_DEEP_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_DEEP_WARM_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_DESERT_BIOME.get()) ; 
		setMidgard.add(VANILLA_DESERT_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_DESERT_LAKES_BIOME.get()) ; 
		setMidgard.add(VANILLA_ERODED_BADLANDS_BIOME.get()) ; 
		setMidgard.add(VANILLA_FLOWER_FOREST_BIOME.get()) ; 
		setMidgard.add(VANILLA_FOREST_BIOME.get()) ; 
		setMidgard.add(VANILLA_FROZEN_OCEAN_BIOME.get()) ;
		setMidgard.add(VANILLA_FROZEN_RIVER_BIOME.get()) ;
		setMidgard.add(VANILLA_GIANT_SPRUCE_TAIGA_BIOME.get()) ;
		setMidgard.add(VANILLA_GIANT_SPRUCE_TAIGA_HILLS_BIOME.get()) ;
		setMidgard.add(VANILLA_GIANT_TREE_TAIGA_BIOME.get()) ;
		setMidgard.add(VANILLA_GIANT_TREE_TAIGA_HILLS_BIOME.get()) ;
		setMidgard.add(VANILLA_GRAVELLY_MOUNTAINS_BIOME.get()) ;
		setMidgard.add(VANILLA_JUNGLE_BIOME.get()) ;
		setMidgard.add(VANILLA_JUNGLE_EDGE_BIOME.get()) ;
		setMidgard.add(VANILLA_JUNGLE_HILLS_BIOME.get()) ;
		setMidgard.add(VANILLA_LUKE_WARM_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_MODIFIED_BADLANDS_PLATEAU_BIOME.get()) ;
		setMidgard.add(VANILLA_MODIFIED_GRAVELLY_MOUNTAINS_BIOME.get()) ;
		setMidgard.add(VANILLA_MODIFIED_JUNGLE_BIOME.get()) ;
		setMidgard.add(VANILLA_MODIFIED_JUNGLE_EDGE_BIOME.get()) ;
		setMidgard.add(VANILLA_MODIFIED_WOODED_BADLANDS_PLATEAU_BIOME.get()) ;
		setMidgard.add(VANILLA_MOUNTAINS_BIOME.get()) ;
		setMidgard.add(VANILLA_MOUNTAIN_EDGE_BIOME.get()) ;
		setMidgard.add(VANILLA_MUSHROOM_FIELDS_BIOME.get()) ;
		setMidgard.add(VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get()) ;
		setMidgard.add(VANILLA_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_PLAINS_BIOME.get()) ; 
		setMidgard.add(VANILLA_RIVER_BIOME.get()) ; 
		setMidgard.add(VANILLA_SAVANNA_BIOME.get()) ; 
		setMidgard.add(VANILLA_SAVANNA_PLATEAU_BIOME.get()) ; 
		setMidgard.add(VANILLA_SHATTERED_SAVANNA_BIOME.get()) ; 
		setMidgard.add(VANILLA_SHATTERED_SAVANNA_PLATEAU_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_BEACH_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_MOUNTAINS_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_TAIGA_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_TAIGA_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_TAIGA_MOUNTAINS_BIOME.get()) ; 
		setMidgard.add(VANILLA_SNOWY_TUNDRA_BIOME.get()) ; 
		setMidgard.add(VANILLA_STONE_SHORE_BIOME.get()) ;
		setMidgard.add(VANILLA_SUNFLOWER_PLAINS_BIOME.get()) ;
		setMidgard.add(VANILLA_SWAMP_BIOME.get()) ;
		setMidgard.add(VANILLA_SWAMP_HILLS_BIOME.get()) ;
		setMidgard.add(VANILLA_TAIGA_BIOME.get()) ; 
		setMidgard.add(VANILLA_TAIGA_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_TAIGA_MOUNTAIN_BIOME.get()) ; 
		setMidgard.add(VANILLA_TALL_BIRCH_FOREST_BIOME.get()) ; 
		setMidgard.add(VANILLA_TALL_BIRCH_HILLS_BIOME.get()) ; 
		setMidgard.add(VANILLA_WARM_OCEAN_BIOME.get()) ; 
		setMidgard.add(VANILLA_WOODED_BADLANDS_PLATEAU_BIOME.get()) ; 
		setMidgard.add(VANILLA_WOODED_HILLS_BIOME.get()) ; 		
		setMidgard.add(VANILLA_WOODED_MOUNTAINS_BIOME.get()) ; 

		
		
		setMidgard.add(MIDGARD_RAINBOW_PLAINS_BIOME.get()) ; 
		setMidgard.add(MIDGARD_IRON_WOOD_BIOME.get()) ; 
		setMidgard.add(MIDGARD_MANGROVE_DRYER_BIOME.get()) ; 
		setMidgard.add(MIDGARD_CHARPARRAL_TROPICAL_BIOME.get()) ; 
		setMidgard.add(MIDGARD_ALPINE_TUNDRA_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TROPICAL_BEACH_BIOME.get()) ; 
		setMidgard.add(MIDGARD_RAINBOW_MOUTAIN_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TEAK_FOREST_BIOME.get()) ; 
		setMidgard.add(MIDGARD_THOUSAND_LAKES_BIOME.get()) ; 
		setMidgard.add(MIDGARD_TROPICAL_ISLAND_BIOME.get()) ; 
		setMidgard.add(MIDGARD_VOLCANIC_ISLAND_BIOME.get()) ; 
	}
	
	
	/*
	 * REGISTER IN OVERWORLD
	 */
	public static void registerBiomes() {

		
		registerMidgardBiomes() ;
		
        BiomeDictionary.addTypes(VANILLA_BADLANDS_BIOME.get(), BiomeDictionary.Type.MESA, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_BADLANDS_PLATEAU_BIOME.get(), BiomeDictionary.Type.MESA, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.DRY,  BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_BAMBOO_JUNGLE_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.RARE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_BAMBOO_JUNGLE_HILLS_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.RARE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_BEACH_BIOME.get(), BiomeDictionary.Type.BEACH, Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_BIRCH_FOREST_HILLS_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS,  BiomeDictionary.Type.OVERWORLD );
        BiomeDictionary.addTypes(VANILLA_COLD_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DARK_FOREST_BIOME.get(), BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DARK_FOREST_HILL_BIOME.get(), BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DEEP_COLD_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DEEP_FROZEN_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DEEP_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DEEP_WARM_OCEAN_BIOME.get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DESERT_BIOME.get(), BiomeDictionary.Type.HOT, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DESERT_HILLS_BIOME.get(), BiomeDictionary.Type.HILLS, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_DESERT_LAKES_BIOME.get(), BiomeDictionary.Type.SANDY, BiomeDictionary.Type.RARE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_ERODED_BADLANDS_BIOME.get(), BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_FLOWER_FOREST_BIOME .get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_FOREST_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.OVERWORLD);        
        BiomeDictionary.addTypes(VANILLA_FROZEN_OCEAN_BIOME .get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_FROZEN_RIVER_BIOME.get(), BiomeDictionary.Type.RIVER, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_GIANT_SPRUCE_TAIGA_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_GIANT_SPRUCE_TAIGA_HILLS_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE,  BiomeDictionary.Type.RARE, BiomeDictionary.Type.HILLS,  BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_GIANT_TREE_TAIGA_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_GIANT_TREE_TAIGA_HILLS_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);        
        BiomeDictionary.addTypes(VANILLA_GRAVELLY_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);        
        BiomeDictionary.addTypes(VANILLA_JUNGLE_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.HOT, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_JUNGLE_EDGE_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.RARE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_JUNGLE_HILLS_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_LUKE_WARM_OCEAN_BIOME .get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MODIFIED_BADLANDS_PLATEAU_BIOME.get(), BiomeDictionary.Type.HOT, BiomeDictionary.Type.DRY, BiomeDictionary.Type.RARE, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MODIFIED_GRAVELLY_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MODIFIED_JUNGLE_BIOME.get(), BiomeDictionary.Type.HOT, BiomeDictionary.Type.WET, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.DRY, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MODIFIED_JUNGLE_EDGE_BIOME.get(), BiomeDictionary.Type.HOT, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MODIFIED, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MODIFIED_WOODED_BADLANDS_PLATEAU_BIOME.get(), BiomeDictionary.Type.MESA, BiomeDictionary.Type.SANDY, BiomeDictionary.Type.DRY, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MOUNTAIN_EDGE_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MUSHROOM_FIELDS_BIOME.get(), BiomeDictionary.Type.MUSHROOM, BiomeDictionary.Type.RARE,BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get(), BiomeDictionary.Type.MUSHROOM, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_OCEAN_BIOME .get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_PLAINS_BIOME.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_RIVER_BIOME.get(), BiomeDictionary.Type.RIVER, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SAVANNA_BIOME.get(), BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SAVANNA_PLATEAU_BIOME.get(), BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SHATTERED_SAVANNA_BIOME.get(), BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SHATTERED_SAVANNA_PLATEAU_BIOME.get(), BiomeDictionary.Type.DRY, BiomeDictionary.Type.HOT, BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_BEACH_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_TAIGA_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_TAIGA_HILLS_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_TAIGA_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.CONIFEROUS,BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SNOWY_TUNDRA_BIOME.get(), BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.COLD, BiomeDictionary.Type.WASTELAND, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_STONE_SHORE_BIOME.get(), BiomeDictionary.Type.BEACH, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SUNFLOWER_PLAINS_BIOME.get(), BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SWAMP_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_SWAMP_HILLS_BIOME.get(), BiomeDictionary.Type.WET, BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_TAIGA_BIOME .get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST,  BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_TAIGA_HILLS_BIOME .get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST,  BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_TAIGA_MOUNTAIN_BIOME .get(), BiomeDictionary.Type.COLD, BiomeDictionary.Type.FOREST,  BiomeDictionary.Type.CONIFEROUS, BiomeDictionary.Type.RARE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_TALL_BIRCH_FOREST_BIOME .get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE,  BiomeDictionary.Type.RARE, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_TALL_BIRCH_HILLS_BIOME .get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.DENSE,  BiomeDictionary.Type.RARE, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_WARM_OCEAN_BIOME .get(), BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.HOT,  BiomeDictionary.Type.WATER, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_WOODED_BADLANDS_PLATEAU_BIOME .get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.FOREST,  BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(VANILLA_WOODED_HILLS_BIOME .get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.HILLS, BiomeDictionary.Type.OVERWORLD);        
        BiomeDictionary.addTypes(VANILLA_WOODED_MOUNTAINS_BIOME.get(), BiomeDictionary.Type.MESA, BiomeDictionary.Type.SANDY,  BiomeDictionary.Type.DRY, BiomeDictionary.Type.SPARSE, BiomeDictionary.Type.PLATEAU, BiomeDictionary.Type.OVERWORLD);
        

        
        BiomeDictionary.addTypes(MIDGARD_ALPINE_TUNDRA_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.SNOWY, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_CHARPARRAL_TROPICAL_BIOME.get(), BiomeDictionary.Type.RIVER, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_IRON_WOOD_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_MANGROVE_BIOME.get(), BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_MANGROVE_DRYER_BIOME.get(), BiomeDictionary.Type.SWAMP, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_RAINBOW_MOUTAIN_BIOME.get(), BiomeDictionary.Type.DRY, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_RAINBOW_PLAINS_BIOME.get(), BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_TEAK_FOREST_BIOME.get(), BiomeDictionary.Type.FOREST, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_THOUSAND_LAKES_BIOME.get(), BiomeDictionary.Type.WATER, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_TROPICAL_BEACH_BIOME.get(), BiomeDictionary.Type.BEACH, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_TROPICAL_ISLAND_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.HOT, BiomeDictionary.Type.OVERWORLD);
        BiomeDictionary.addTypes(MIDGARD_VOLCANIC_ISLAND_BIOME.get(), BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OCEAN, BiomeDictionary.Type.COLD, BiomeDictionary.Type.OVERWORLD);

                
        Midgard.LOGGER.info("Yggdrasil_Debug = BiomeInit.registerBiomes() =");
        

	}

	
	private static void registerBiome(int weight, Biome biome, Type... types) {
		// the line below will make it spawn in the overworld
		BiomeManager.addBiome(BiomeManager.BiomeType.COOL, new BiomeManager.BiomeEntry(biome, weight));
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addSpawnBiome(biome);
	}

	
    public static void setup() {
        worldType = new WorldTypeMidgard();
                
        
        
    }

}
