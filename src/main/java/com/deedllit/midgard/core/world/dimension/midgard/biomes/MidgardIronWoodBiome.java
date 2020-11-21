package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.midgard.init.BlockInit;
import com.google.common.collect.ImmutableList;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.common.IPlantable;

public class MidgardIronWoodBiome extends MidgardBiome {

    public static final HugeTreeFeatureConfig HUGE_IRON_WOOD_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(
    		new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LOG.get().getDefaultState()), 
    		new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LEAVES.get().getDefaultState())))
    			.baseHeight(6)
    			.setSapling((net.minecraftforge.common.IPlantable)BlockInit.IRON_WOOD_SAPLING.get())
    			.build();
    
    public static final TreeFeatureConfig NORMAL_IRON_WOOD_TREE_CONFIG = (new TreeFeatureConfig.Builder(
			new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LOG.get().getDefaultState()), 
			new SimpleBlockStateProvider(BlockInit.IRON_WOOD_LEAVES.get().getDefaultState()), 
			new BlobFoliagePlacer(2, 0)))
				.baseHeight(4)
				.heightRandA(2)
				.foliageHeight(3)
				.ignoreVines()
				.setSapling((IPlantable) BlockInit.IRON_WOOD_SAPLING.get())
				.build();
    
    public MidgardIronWoodBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
	    		  .precipitation(Biome.RainType.RAIN)
	    		  .category(Biome.Category.FOREST)
	    		  .depth(0.1F)
	    		  .scale(0.2F)
	    		  .temperature(0.7F)
	    		  .downfall(0.8F)
	    		  .waterColor(4159204)
	    		  .waterFogColor(329011)
	    		  .parent("dark_forest"));
		
	      
	      //this.addStructure(StructureInit.YGGDRASIL_TREE_STRUCTURE.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	      
	      
	      this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
	      this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
	      DefaultBiomeFeatures.addCarvers(this);
	      DefaultBiomeFeatures.addStructures(this);
	      DefaultBiomeFeatures.addLakes(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      	      
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		 Feature.MEGA_SPRUCE_TREE.withConfiguration(HUGE_IRON_WOOD_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(6, 0.1F, 1))));
	      
	      
	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
				Feature.NORMAL_TREE.withConfiguration(NORMAL_IRON_WOOD_TREE_CONFIG).withPlacement(
						Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(4, 0.1f, 1))));	

	      this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  Feature.RANDOM_SELECTOR.withConfiguration(
	    				  new MultipleRandomFeatureConfig(ImmutableList.of(
	    						  Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM).withChance(0.0125F), 
	    						  Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM).withChance(0.025F), 
	    						  Feature.DARK_OAK_TREE.withConfiguration(DefaultBiomeFeatures.DARK_OAK_TREE_CONFIG).withChance(0.333334F), 
	    						  Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).withChance(0.1F), 
	    						  Feature.FANCY_TREE.withConfiguration(DefaultBiomeFeatures.FANCY_TREE_CONFIG).withChance(0.05F)), 
	    						  Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG))).withPlacement(Placement.DARK_OAK_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));

	      
	      
	      DefaultBiomeFeatures.addDoubleFlowers(this);
	      
	      DefaultBiomeFeatures.addStoneVariants(this);
	      	      
	      DefaultBiomeFeatures.addOres(this);
	      DefaultBiomeFeatures.addSedimentDisks(this);
	      DefaultBiomeFeatures.addDefaultFlowers(this);
	      DefaultBiomeFeatures.addGrass(this);
	      DefaultBiomeFeatures.addMushrooms(this);
	      DefaultBiomeFeatures.addReedsAndPumpkins(this);
	      DefaultBiomeFeatures.addSprings(this);
	      DefaultBiomeFeatures.addFreezeTopLayer(this);
	      DefaultBiomeFeatures.addMonsterRooms(this);
	      
	      
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.PIG, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.CHICKEN, 10, 4, 4));
	      this.addSpawn(EntityClassification.CREATURE, new Biome.SpawnListEntry(EntityType.COW, 8, 4, 4));
	      this.addSpawn(EntityClassification.AMBIENT, new Biome.SpawnListEntry(EntityType.BAT, 10, 8, 8));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE, 95, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ZOMBIE_VILLAGER, 5, 1, 1));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SKELETON, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.CREEPER, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.SLIME, 100, 4, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.ENDERMAN, 10, 1, 4));
	      this.addSpawn(EntityClassification.MONSTER, new Biome.SpawnListEntry(EntityType.WITCH, 5, 1, 1));
	      	      
	      
	}

	@Override
	public Biome getRiver() {
		return BiomeInit.VANILLA_RIVER_BIOME.get();
	}
	
	
}
