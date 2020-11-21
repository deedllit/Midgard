package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.SurfaceBuilderInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public class MidgardRainbowMoutainBiome extends MidgardBiome {

	public MidgardRainbowMoutainBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.RAINBOW, SurfaceBuilder.RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.PLAINS)
	    		  .depth(0.45F)
	    		  .scale(0.3F)
	    		  .temperature(0.75F)
	    		  .downfall(0.6F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent((String) null ));
	      
			this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));

		    DefaultBiomeFeatures.addCarvers(this);
		    DefaultBiomeFeatures.addStructures(this);
		    DefaultBiomeFeatures.addLakes(this);
		    DefaultBiomeFeatures.addMonsterRooms(this);
		    DefaultBiomeFeatures.addStoneVariants(this);
		    DefaultBiomeFeatures.addOres(this);
		    DefaultBiomeFeatures.addExtraGoldOre(this);
		    DefaultBiomeFeatures.addSedimentDisks(this);
		    
		    MidgardDefaultBiomeFeatures.addGrassAndDeadBushes(this);

		    DefaultBiomeFeatures.addMushrooms(this);
		    DefaultBiomeFeatures.addReedsPumpkinsCactus(this);
		    DefaultBiomeFeatures.addSprings(this);
		    DefaultBiomeFeatures.addFreezeTopLayer(this);
		    
		    this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
		    this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));


			this.canSpawnInBiome = false;
		    this.addWeight( MidgardClimate.HOT_DESERT,1);

		}

}
