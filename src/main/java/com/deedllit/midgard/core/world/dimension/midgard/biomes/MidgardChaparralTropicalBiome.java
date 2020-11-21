package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.midgard.init.SurfaceBuilderInit;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardChaparralTropicalBiome extends MidgardBiome {

	public MidgardChaparralTropicalBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilderInit.CHAPARRAL, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
		  	.precipitation(Biome.RainType.RAIN)
		  	.category(Biome.Category.PLAINS)
		  	.depth(1.25F)
		  	.scale(0.325F)
		  	.temperature(0.9F)
		  	.downfall(0.3F)
		  	.waterColor(6388580)
		  	.waterFogColor(2302743)
		  	.parent((String)null));

	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addDesertLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      DefaultBiomeFeatures.addStoneVariants(this);
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      MidgardDefaultBiomeFeatures.addRice(this) ; 
	      MidgardDefaultBiomeFeatures.addJungleTrees(this);
	      MidgardDefaultBiomeFeatures.addTropicalVegetation(this);
	      MidgardDefaultBiomeFeatures.addExtraTropicalVegetation(this);
	      MidgardDefaultBiomeFeatures.addBamboo(this);
	      MidgardDefaultBiomeFeatures.addBambooJungleVegetation(this) ;
	      MidgardDefaultBiomeFeatures.addDesertFlowers(this); 
	      MidgardDefaultBiomeFeatures.addExtraPomelias(this);
	      
	      MidgardDefaultBiomeFeatures.addCactus(this);
	      MidgardDefaultBiomeFeatures.addExtraCactus(this);
	      
	      DefaultBiomeFeatures.addSprings(this);

	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PARROT, 10, 1, 2));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PANDA, 1, 1, 2));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      
	      this.addWeight( MidgardClimate.TROPICAL,10);

	      
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
