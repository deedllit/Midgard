package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.FeatureInit;
import com.deedllit.midgard.init.SurfaceBuilderInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardMangroveBiome extends MidgardBiome {

	public MidgardMangroveBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.MANGROVE, SurfaceBuilder.GRASS_DIRT_SAND_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.SWAMP)
	    		  .depth(-0.25F)
	    		  .scale(-0.0025F)
	    		  .temperature(0.80F)
	    		  .downfall(0.7F)
	    		  .waterColor(6388580)
	    		  .waterFogColor(2302743)
	    		  .parent((String)null));
	      
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      
			this.addStructure(FeatureInit.MANGROVE_WITCH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			this.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, FeatureInit.MANGROVE_WITCH.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
					.withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

		  DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSwampClayDisks(this);
	      MidgardDefaultBiomeFeatures.addPads(this);
	      MidgardDefaultBiomeFeatures.addMangroveVegetation(this);
	      DefaultBiomeFeatures.addSwampVegetation(this);
	      DefaultBiomeFeatures.addMushrooms(this);
	      DefaultBiomeFeatures.addExtraReedsAndPumpkins(this);
	      DefaultBiomeFeatures.addSprings(this);
	      
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.SEAGRASS.withConfiguration(new SeaGrassConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.COD, 15, 3, 6));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.SQUID, 10, 4, 4));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.PUFFERFISH, 15, 1, 3));
	      this.addSpawn(EntityClassification.WATER_CREATURE, new Biome.SpawnListEntry(EntityType.TROPICAL_FISH, 25, 8, 8));

	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 40, 1, 2));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 1, 1, 1));	      
	      
	      this.addWeight( MidgardClimate.SUBTROPICAL,10);

	      
	}

	@Override
	public int getSkyColor() {
		return 6975545;
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	    return d0 < -0.1D ? 5011004 : 6975545;
	}

	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		return 6975545;
	}
}
