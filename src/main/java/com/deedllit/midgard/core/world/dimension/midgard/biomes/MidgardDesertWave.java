package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.SurfaceBuilderInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MidgardDesertWave extends MidgardBiome {

	public MidgardDesertWave() {
		      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.WAVE, SurfaceBuilder.SAND_CONFIG)
		    		  .precipitation(Biome.RainType.NONE)
		    		  .category(Biome.Category.DESERT)
		    		  .depth(0.01F)
		    		  .scale(0.05F)
		    		  .temperature(2.0F)
		    		  .downfall(0.01F)
		    		  .waterColor(874564)
		    		  .waterFogColor(329011)
		    		  .parent((String) null));
		      
				this.addStructure(
						Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
				this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
				
				DefaultBiomeFeatures.addCarvers(this);
				DefaultBiomeFeatures.addStructures(this);
				DefaultBiomeFeatures.addDesertLakes(this);
				DefaultBiomeFeatures.addMonsterRooms(this);
				DefaultBiomeFeatures.addStoneVariants(this);
				DefaultBiomeFeatures.addOres(this);
				DefaultBiomeFeatures.addSedimentDisks(this);
				DefaultBiomeFeatures.addDefaultFlowers(this);
				DefaultBiomeFeatures.addSparseGrass(this);
				
				MidgardDefaultBiomeFeatures.addGrassAndDeadBushes(this) ;

				DefaultBiomeFeatures.addMushrooms(this);
				DefaultBiomeFeatures.addExtraReedsPumpkinsCactus(this);
				DefaultBiomeFeatures.addSprings(this);
				DefaultBiomeFeatures.addDesertFeatures(this);
				DefaultBiomeFeatures.addFreezeTopLayer(this);
				
				this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.RABBIT, 4, 2, 3));
				this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 19, 4, 4));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 1, 1, 1));
				this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.HUSK, 80, 4, 4));
		      
	} 

}
