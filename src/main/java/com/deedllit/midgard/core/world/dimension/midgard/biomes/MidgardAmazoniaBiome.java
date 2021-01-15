package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.midgard.init.FeatureInit;
import com.deedllit.midgard.init.SurfaceBuilderInit;
import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardAmazoniaBiome extends MidgardBiome {

	public MidgardAmazoniaBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.AMAZONIA, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
		  	.precipitation(Biome.RainType.RAIN)
		  	.category(Biome.Category.PLAINS)
			.depth(0.01F)
			.scale(0.05F)
			.temperature(0.9F)
			.downfall(0.01F)
		  	.waterColor(6388580)
		  	.waterFogColor(2302743)
		  	.parent((String)null));

			//this.addStructure(FeatureInit.BAHAY_KUBO_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));

			this.addStructure(Feature.JUNGLE_TEMPLE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
			this.addStructure(
					Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
			this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	      
			DefaultBiomeFeatures.addCarvers(this);
			DefaultBiomeFeatures.addStructures(this);
			DefaultBiomeFeatures.addLakes(this);
			DefaultBiomeFeatures.addMonsterRooms(this);
			DefaultBiomeFeatures.addStoneVariants(this);
			DefaultBiomeFeatures.addOres(this);
			DefaultBiomeFeatures.addSedimentDisks(this);

			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
		    		  FeatureInit.MANGROVE_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
		    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
		    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
			
			/*
			DefaultBiomeFeatures.addBamboo(this);
			DefaultBiomeFeatures.addJungleTreeForest(this);
			DefaultBiomeFeatures.addExtraDefaultFlowers(this);
			DefaultBiomeFeatures.addJungleGrass(this);
			DefaultBiomeFeatures.addMushrooms(this);
			DefaultBiomeFeatures.addReedsAndPumpkins(this);
			DefaultBiomeFeatures.addSprings(this);
			DefaultBiomeFeatures.addJunglePlants(this);
			DefaultBiomeFeatures.addFreezeTopLayer(this);
			*/
	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 10, 1, 2));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      
	      this.addWeight( MidgardClimate.TROPICAL,1);

	      
	}
	
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	    return d0 < -0.1D ? 10066176 : 10526720;
	}

	@Override
	public Biome getRiver() {
		return BiomeInit.VANILLA_RIVER_BIOME.get();
	}
}