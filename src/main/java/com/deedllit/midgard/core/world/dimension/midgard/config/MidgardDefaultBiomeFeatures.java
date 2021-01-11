package com.deedllit.midgard.core.world.dimension.midgard.config;


import com.deedllit.midgard.core.world.gen.feature.crop.RiceFeatureConfig;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.init.FeatureInit;
import com.deedllit.midgard.world.feature.flowers.MidgardDesertFlowerBlockStateProvider;
import com.deedllit.midgard.world.feature.midgard.flowers.MidgardRainbowFlowerBlockStateProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.blockplacer.ColumnBlockPlacer;
import net.minecraft.world.gen.blockplacer.DoublePlantBlockPlacer;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.BlockStateFeatureConfig;
import net.minecraft.world.gen.feature.BlockWithContextConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.MultipleWithChanceRandomFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.SphereReplaceConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.PineFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.SpruceFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.CaveEdgeConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidWithNoiseConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraft.world.gen.treedecorator.CocoaTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeaveVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;

public class MidgardDefaultBiomeFeatures {

	private static final BlockState IXIA_VIRIDIFLORA= BlockInit.IXIA_VIRIDIFLORA_TEAL_BUSH.get().getDefaultState();
	private static final BlockState GUZMANIA_PINK = BlockInit.GUZMANIA_PINK.get().getDefaultState();
	private static final BlockState GUZMANIA_RED = BlockInit.GUZMANIA_RED.get().getDefaultState();
	private static final BlockState FISH_HOOK = BlockInit.FISH_HOOK.get().getDefaultState();
	private static final BlockState TEAL_POMELIA_BLOCK = BlockInit.MIDGARD_TEAL_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState BLUE_POMELIA_BLOCK = BlockInit.MIDGARD_BLUE_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState WHITE_POMELIA_BLOCK = BlockInit.MIDGARD_WHITE_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState PINK_POMELIA_BLOCK = BlockInit.MIDGARD_PINK_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState ORANGE_POMELIA_BLOCK = BlockInit.MIDGARD_ORANGE_POMELIA_BUSH.get().getDefaultState();
	private static final BlockState EDELWEISS = BlockInit.EDELWEISS.get().getDefaultState() ; 
	private static final BlockState CHARDON = BlockInit.CHARDON.get().getDefaultState() ; 
	private static final BlockState BISTORT_PINK = BlockInit.PINK_BISTORT.get().getDefaultState() ; 
	private static final BlockState RED_SUNFLOWER = BlockInit.RED_SUNFLOWER.get().getDefaultState();
	private static final BlockState DESERT_GRASS = BlockInit.DESERT_GRASS.get().getDefaultState();
    private static final BlockState RICE = BlockInit.MIDGARD_RICE_BOTTOM_CROP.get().getDefaultState() ; 

    //private static final BlockState RICE = BlockInit.MIDGARD_RICE_TOP_CROP.get().getDefaultState();

	private static final BlockState AIR = Blocks.AIR.getDefaultState() ; 
	private static final BlockState TALL_GRASS = Blocks.TALL_GRASS.getDefaultState() ; 
	private static final BlockState LILY_OF_THE_VALLEY = Blocks.LILY_OF_THE_VALLEY.getDefaultState();
    private static final BlockState LILY_PAD = Blocks.LILY_PAD.getDefaultState();
    private static final BlockState BLUE_ORCHID = Blocks.BLUE_ORCHID.getDefaultState();
    private static final BlockState GRASS = Blocks.GRASS.getDefaultState() ; 
    private static final BlockState GRASS_BLOCK = Blocks.GRASS_BLOCK.getDefaultState() ; 
    private static final BlockState SAND = Blocks.SAND.getDefaultState() ; 
    private static final BlockState STONE = Blocks.STONE.getDefaultState() ; 
    private static final BlockState DEAD_BUSH = Blocks.DEAD_BUSH.getDefaultState() ; 
    private static final BlockState RED_MUSHROOM = Blocks.RED_MUSHROOM.getDefaultState() ; 
    private static final BlockState BROWN_MUSHROOM = Blocks.BROWN_MUSHROOM.getDefaultState() ; 
    private static final BlockState OAK_LOG = Blocks.OAK_LOG.getDefaultState() ; 
    private static final BlockState OAK_LEAVES = Blocks.OAK_LEAVES.getDefaultState() ; 
    private static final BlockState CACTUS = Blocks.CACTUS.getDefaultState();
    private static final BlockState JUNGLE_LOG = Blocks.JUNGLE_LOG.getDefaultState();
    private static final BlockState JUNGLE_LEAVES = Blocks.JUNGLE_LEAVES.getDefaultState();
    private static final BlockState FERN = Blocks.FERN.getDefaultState();
    private static final BlockState LARGE_FERN = Blocks.LARGE_FERN.getDefaultState();
    private static final BlockState PODZOL = Blocks.PODZOL.getDefaultState();
    private static final BlockState SPRUCE_LOG = Blocks.SPRUCE_LOG.getDefaultState() ; 
    private static final BlockState SPRUCE_LEAVES = Blocks.SPRUCE_LEAVES.getDefaultState() ; 
    private static final BlockState WATER = Blocks.WATER.getDefaultState() ; 
    private static final BlockState DIRT = Blocks.DIRT.getDefaultState() ; 
    private static final BlockState CLAY = Blocks.CLAY.getDefaultState() ; 
    private static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState() ; 

    
    
    public static final SurfaceBuilderConfig TROPICAL_SURFACE_CONFIG = new SurfaceBuilderConfig(GRASS,SAND,STONE)  ;
    public static final BlockClusterFeatureConfig RAINBOW_FLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new MidgardRainbowFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();
    
    //public static final BaseTreeFeatureConfig BANYAN_TREE_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(8, 0, 4, 0, 5), new StraightTrunkPlacer(4, 8, 3), new TwoLayerFeature(1, 1, 2))).func_236701_a_(1).func_236703_a_(ImmutableList.of(LeaveVineTreeDecorator.field_236871_b_)).build();
    
    
    public static final TreeFeatureConfig FANCY_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(0, 0))).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
    public static final HugeTreeFeatureConfig MEGA_JUNGLE_TREE_CONFIG = (new HugeTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES))).baseHeight(10).heightInterval(20).decorators(ImmutableList.of(new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).setSapling((net.minecraftforge.common.IPlantable)Blocks.JUNGLE_SAPLING).build();
    public static final BaseTreeFeatureConfig JUNGLE_GROUND_BUSH_CONFIG = (new BaseTreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(OAK_LEAVES))).baseHeight(4).setSapling((net.minecraftforge.common.IPlantable)Blocks.JUNGLE_SAPLING).build();
    public static final TreeFeatureConfig JUNGLE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(JUNGLE_LOG), new SimpleBlockStateProvider(JUNGLE_LEAVES), new BlobFoliagePlacer(2, 0))).baseHeight(4).heightRandA(8).foliageHeight(3).decorators(ImmutableList.of(new CocoaTreeDecorator(0.2F), new TrunkVineTreeDecorator(), new LeaveVineTreeDecorator())).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.JUNGLE_SAPLING).build();
    public static final TreeFeatureConfig SWAMP_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(OAK_LOG), new SimpleBlockStateProvider(OAK_LEAVES), new BlobFoliagePlacer(3, 0))).baseHeight(5).heightRandA(3).foliageHeight(3).maxWaterDepth(1).decorators(ImmutableList.of(new LeaveVineTreeDecorator())).setSapling((net.minecraftforge.common.IPlantable)Blocks.OAK_SAPLING).build();
	public static final TreeFeatureConfig PINE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new PineFoliagePlacer(1, 0))).baseHeight(7).heightRandA(4).trunkTopOffset(1).foliageHeight(3).foliageHeightRandom(1).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();
	
	public static final TreeFeatureConfig SPRUCE_TREE_CONFIG = (new TreeFeatureConfig.Builder(new SimpleBlockStateProvider(SPRUCE_LOG), new SimpleBlockStateProvider(SPRUCE_LEAVES), new SpruceFoliagePlacer(2, 1))).baseHeight(6).heightRandA(3).trunkHeight(1).trunkHeightRandom(1).trunkTopOffsetRandom(2).ignoreVines().setSapling((net.minecraftforge.common.IPlantable)Blocks.SPRUCE_SAPLING).build();

	//public static final BlockClusterFeatureConfig RICE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RICE), SimpleBlockPlacer.field_236447_c_)).tries(1).build();

    
    //public static final BlockClusterFeatureConfig IXIA_VIRIDIFLORA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(IXIA_VIRIDIFLORA), SimpleBlockPlacer.field_236447_c_)).tries(1).build();
	//public static final BlockClusterFeatureConfig GUZMANIA_PINK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GUZMANIA_PINK), SimpleBlockPlacer.field_236447_c_)).tries(1).build();
	//public static final BlockClusterFeatureConfig GUZMANIA_RED_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GUZMANIA_RED), SimpleBlockPlacer.field_236447_c_)).tries(1).build();
	//public static final BlockClusterFeatureConfig FISH_HOOK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FISH_HOOK), SimpleBlockPlacer.field_236447_c_)).tries(4).build();
	
	public static final BlockClusterFeatureConfig IXIA_VIRIDIFLORA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(IXIA_VIRIDIFLORA), new SimpleBlockPlacer())).tries(1).build();
	public static final BlockClusterFeatureConfig GUZMANIA_PINK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GUZMANIA_PINK), new SimpleBlockPlacer())).tries(1).build();
	public static final BlockClusterFeatureConfig GUZMANIA_RED_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GUZMANIA_RED), new SimpleBlockPlacer())).tries(1).build();
	public static final BlockClusterFeatureConfig FISH_HOOK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(FISH_HOOK), new SimpleBlockPlacer())).tries(1).build();
	
	public static final BlockClusterFeatureConfig EDELWEISS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(EDELWEISS), new SimpleBlockPlacer())).tries(2).build();
	public static final BlockClusterFeatureConfig CHARDON_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CHARDON), new SimpleBlockPlacer())).tries(4).build();
	public static final BlockClusterFeatureConfig BISTORT_PINK_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BISTORT_PINK), new SimpleBlockPlacer())).tries(4).build();
    public static final BlockClusterFeatureConfig RICE_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RICE), new SimpleBlockPlacer())).tries(64).whitelist(ImmutableSet.of(DIRT.getBlock())).func_227317_b_().build();

	
	//public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_GRASS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();

	   
	public static final BlockClusterFeatureConfig RED_SUNFLOWER_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_SUNFLOWER), new DoublePlantBlockPlacer())).tries(16).func_227317_b_().build();
    public static final BlockClusterFeatureConfig LARGE_FERN_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LARGE_FERN), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    public static final BlockClusterFeatureConfig TROPICAL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 1).addWeightedBlockstate(FERN, 4), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig LUSH_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 3).addWeightedBlockstate(FERN, 1), new SimpleBlockPlacer())).blacklist(ImmutableSet.of(PODZOL)).tries(32).build();
    public static final BlockClusterFeatureConfig CACTUS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(CACTUS), new ColumnBlockPlacer(1, 2))).tries(10).func_227317_b_().build();
	public static final BlockClusterFeatureConfig WHITE_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(WHITE_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig PINK_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(PINK_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig BLUE_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BLUE_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig TEAL_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TEAL_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig ORANGE_POMELIA_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(ORANGE_POMELIA_BLOCK), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
	public static final BlockClusterFeatureConfig LILY_OF_THE_VALLEY_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_OF_THE_VALLEY), new SimpleBlockPlacer())).tries(64).build();
	public static final BlockClusterFeatureConfig GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(GRASS), new SimpleBlockPlacer())).tries(32).build();
	public static final BlockClusterFeatureConfig BLUE_ORCHID_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BLUE_ORCHID), new SimpleBlockPlacer())).tries(64).build();
	public static final BlockClusterFeatureConfig DEAD_BUSH_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DEAD_BUSH), new SimpleBlockPlacer())).tries(4).build();
    public static final BlockClusterFeatureConfig LILY_PAD_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(LILY_PAD), new SimpleBlockPlacer())).tries(10).build();
    public static final BlockClusterFeatureConfig RED_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(RED_MUSHROOM), new SimpleBlockPlacer())).tries(64).build();
    public static final BlockClusterFeatureConfig BROWN_MUSHROOM_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(BROWN_MUSHROOM), new SimpleBlockPlacer())).tries(64).build();
    public static final BlockClusterFeatureConfig JUNGLE_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder((new WeightedBlockStateProvider()).addWeightedBlockstate(GRASS, 3).addWeightedBlockstate(FERN, 2), new SimpleBlockPlacer())).tries(32).build();
    public static final BlockClusterFeatureConfig TALL_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_GRASS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();
    public static final BlockClusterFeatureConfig DESERT_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(DESERT_GRASS), new SimpleBlockPlacer())).tries(4).build();

    public static final BlockClusterFeatureConfig DESERT_FLOWERS_CONFIG = (new BlockClusterFeatureConfig.Builder(new MidgardDesertFlowerBlockStateProvider(), new SimpleBlockPlacer())).tries(64).build();

    //public static final BlockClusterFeatureConfig JUNGLE_GRASS_CONFIG = (new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(TALL_GRASS), new DoublePlantBlockPlacer())).tries(64).func_227317_b_().build();

    
    
    
	public static void addRedSunFlower(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(RED_SUNFLOWER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(2))));
	}

    
	public static void addDesertVegetation(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DESERT_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(2))));
	}
    
	public static void addGrassAndDeadBushes(Biome biomeIn) {
		MidgardDefaultBiomeFeatures.addDesertVegetation( biomeIn );
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(15))));		
	}
    
    public static void addRainbowFlowers(Biome biomeIn) {    	
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(RAINBOW_FLOWER_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));
    }
    
    public static void addMoreLakes(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.LOCAL_MODIFICATIONS, Feature.LAKE.withConfiguration(new BlockStateFeatureConfig(WATER)).withPlacement(Placement.WATER_LAKE.configure(new ChanceConfig(1))));    	
    }
    
	public static void addExtraPomelias(Biome biomeIn) {	
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(ORANGE_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(3))));

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(PINK_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(2))));
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH
				.withConfiguration(WHITE_POMELIA_CONFIG)
				.withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE
						.configure(new FrequencyConfig(1))));		
	}
	
	
	
	public static void addAlpinaFlowers(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CHARDON_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(EDELWEISS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	}


	public static void addMoutainsFlower(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(BISTORT_PINK_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));		
	}
	
	
	public static void addMixedSpruce(Biome biomeIn) {

	}
	
	public static void addMoutainSpruceTrees(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		Feature.RANDOM_SELECTOR.withConfiguration(
	    				new MultipleRandomFeatureConfig(
	    						ImmutableList.of(
	    								FeatureInit.NORWAY_SPRUCE_SMALL_MOUTAIN.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.333333333F),
	    								FeatureInit.BLUE_SPRUCE_SMALL_MOUTAIN.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.1F)								
	    								), 
	    						FeatureInit.VANILLA_SPRUCE_SMALL_MOUTAIN.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(10, 0.1F, 1))));
	}
	
	
	public static void addBoholTrees(Biome biomeIn) {		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.BANANA_SMALL_BOHOL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PAPAYA_EMERALD_SMALL_BOHOL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PAPAYA_SMALL_BOHOL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PLAM_SMALL_BOHOL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.GREEN_PLAM_SMALL_BOHOL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));	
		}
	
	public static void addPalmTree(Biome biomeIn) {		
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		Feature.RANDOM_SELECTOR.withConfiguration(
	    				new MultipleRandomFeatureConfig(
	    						ImmutableList.of(FeatureInit.PAPAYA_EMERALD_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.01F), 
	    								FeatureInit.BANANA_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.1F), 
	    								FeatureInit.PAPAYA_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.1F),
	    								FeatureInit.GREEN_PLAM_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withChance(0.333333333F)), 
	    						FeatureInit.PLAM_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

		
		/*
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.BANANA_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PAPAYA_EMERALD_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PAPAYA_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.PLAM_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.GREEN_PLAM_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
		*/
	    
	}
	
	public static void addDenseBlueSpruce(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.BLUE_SPRUCE_GIANT.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	      
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.BLUE_SPRUCE_MEDIUM.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(2, 0.1F, 1))));

		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
	    		  FeatureInit.BLUE_SPRUCE_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG)
	    		  .withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP
	    				  .configure(new AtSurfaceWithExtraConfig(4, 0.1F, 1))));
	}
	
	public static void addDenseGrass(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(25))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TALL_GRASS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.1D, 25, 35))));
	}
	
	public static void addFewConifers(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.NORMAL_TREE.withConfiguration(PINE_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(SPRUCE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.01F, 0))));
	}
	
	public static void addSurfaceStones(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.DISK.withConfiguration(new SphereReplaceConfig(GRASS_BLOCK, 7, 2, Lists.newArrayList(STONE))).withPlacement(Placement.COUNT_TOP_SOLID.configure(new FrequencyConfig(3))));
	}
	
	public static void addMoreChardon(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CHARDON_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
	}

	public static void addMoreEdelweiss(Biome biomeIn) {
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(EDELWEISS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(3))));
	}

	
	public static void addRice(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, FeatureInit.RICE.withConfiguration(new RiceFeatureConfig(64, 0.6D)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
	}
	
	public static void addMoreDesertFlowers(Biome biomeIn) {
        biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(DESERT_FLOWERS_CONFIG).withPlacement(Placement.NOISE_HEIGHTMAP_32.configure(new NoiseDependant(-0.8D, 15, 4))));		
	}

	public static void addDesertFlowers(Biome biomeIn) {				
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(IXIA_VIRIDIFLORA_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GUZMANIA_PINK_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GUZMANIA_RED_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(FISH_HOOK_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	}
	
	public static void addJungleTrees(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.15F), Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.75F), Feature.MEGA_JUNGLE_TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)), Feature.NORMAL_TREE.withConfiguration(JUNGLE_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(5, 0.1F, 1))));
	}

	public static void addExtraTropicalVegetation(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.15F), Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.75F), Feature.MEGA_JUNGLE_TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.33333334F)), Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(3, 0.1F, 1))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(TROPICAL_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(7))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LARGE_FERN_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(7))));
	}

	public static void addBamboo(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.0F)).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(16))));
	}
	
	public static void addBambooJungleVegetation(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.BAMBOO.withConfiguration(new ProbabilityConfig(0.2F)).withPlacement(Placement.TOP_SOLID_HEIGHTMAP_NOISE_BIASED.configure(new TopSolidWithNoiseConfig(10, 50.0D, 0.3D, Heightmap.Type.WORLD_SURFACE_WG))));
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(FANCY_TREE_CONFIG).withChance(0.05F), Feature.JUNGLE_GROUND_BUSH.withConfiguration(JUNGLE_GROUND_BUSH_CONFIG).withChance(0.15F), Feature.MEGA_JUNGLE_TREE.withConfiguration(MEGA_JUNGLE_TREE_CONFIG).withChance(0.7F)), Feature.RANDOM_PATCH.withConfiguration(LUSH_GRASS_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(30, 0.1F, 1))));
	}

	
	public static void addCactus(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(10))));
	}

	public static void addExtraCactus(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(CACTUS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(40))));
	}

	public static void addTropicalVegetation(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, 
				Feature.RANDOM_RANDOM_SELECTOR.withConfiguration(new MultipleWithChanceRandomFeatureConfig(ImmutableList.of(
						Feature.RANDOM_PATCH.withConfiguration(ORANGE_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(PINK_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(BLUE_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(TEAL_POMELIA_CONFIG), 
						Feature.RANDOM_PATCH.withConfiguration(WHITE_POMELIA_CONFIG), 
						Feature.FLOWER.withConfiguration(LILY_OF_THE_VALLEY_CONFIG)), 0))
				.withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(5))));		

		
		
		
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(JUNGLE_GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		//biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(5))));
		
		//biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.FLOWER.withConfiguration(BLUE_ORCHID_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(1))));
	  //biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.field_236291_c_.withConfiguration(BANYAN_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.05F, 1))));
	    biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DEAD_BUSH_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(1))));
	}

	public static void addPads(Biome biomeIn) {
		biomeIn.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(LILY_PAD_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_DOUBLE.configure(new FrequencyConfig(8))));
	}
	
	public static void addMangroveVegetation(Biome biomeIn) {	
	}

	
}
