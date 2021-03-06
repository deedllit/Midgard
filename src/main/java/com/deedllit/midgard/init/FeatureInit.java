package com.deedllit.midgard.init;

import java.util.Locale;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.world.gen.feature.crop.RiceFeature;
import com.deedllit.midgard.core.world.gen.feature.crop.RiceFeatureConfig;
import com.deedllit.midgard.core.world.gen.feature.tree.*;
import com.deedllit.midgard.world.feature.asgard.features.*;
import com.deedllit.midgard.world.feature.midgard.features.*;
import com.deedllit.midgard.world.feature.midgard.structures.*;

import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.SeaGrassConfig;
import net.minecraft.world.gen.feature.SeaGrassFeature;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.registries.IForgeRegistry;

public class FeatureInit {


	
	public static Feature<BaseTreeFeatureConfig> TEST =
			new MidgardBasicTreeFeature.Builder().log(Blocks.ACACIA_LOG.getDefaultState()).leaves(Blocks.ACACIA_LEAVES.getDefaultState()).create() ;  


	public static Feature<BaseTreeFeatureConfig> MANGROVE_TREE =
			new MidgardMangroveTreeFeature.Builder()
				.log(BlockInit.MIDGARD_MANGROVE_LOG.get().getDefaultState())
				.leaves(Blocks.JUNGLE_LEAVES.getDefaultState())
				.minSize(6)
				.maxSize(8)
				.create() ;  

	
	public static Feature<BaseTreeFeatureConfig> BLACK_POPLAR_SMALL =
			new MidgardPoplarTreeFeature.Builder()
				.log(BlockInit.BLACK_POPLAR_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(20)
				.maxSize(36)
				.create() ;  
	

	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_SMALL_MOUTAIN =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSpawnHeight(120)
				.maxSpawnHeight(165)
				.create() ;  

	
	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_SMALL =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.create() ;  
			
	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_MEDIUM =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(10)
				.maxSize(16)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_GIANT =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(16)
				.maxSize(22)
				.create() ;  
	
	public static Feature<BaseTreeFeatureConfig> VANILLA_SPRUCE_SMALL_MOUTAIN =
			new MidgardConiferTreeFeature.Builder()
				.log(Blocks.SPRUCE_LOG.getDefaultState())
				.leaves(Blocks.SPRUCE_LEAVES.getDefaultState())
				.minSpawnHeight(110)
				.maxSpawnHeight(165)
				.create() ; 
	
	public static Feature<BaseTreeFeatureConfig> NORWAY_SPRUCE_SMALL_MOUTAIN =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.NORWAY_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.NORWAY_SPRUCE_LEAVES.get().getDefaultState())
				.minSpawnHeight(120)
				.maxSpawnHeight(165)
				.create() ; 
	
	public static Feature<BaseTreeFeatureConfig> NORWAY_SPRUCE_SMALL =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.NORWAY_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.NORWAY_SPRUCE_LEAVES.get().getDefaultState())
				.create() ;  
			
	public static Feature<BaseTreeFeatureConfig> NORWAY_SPRUCE_MEDIUM =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.NORWAY_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.NORWAY_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(10)
				.maxSize(16)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> NORWAY_SPRUCE_GIANT =
			new MidgardConiferTreeFeature.Builder()
				.log(BlockInit.NORWAY_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.NORWAY_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(16)
				.maxSize(22)
				.create() ;  

	
	/*
	 * BOHOL TREES 
	 */
	
	public static Feature<BaseTreeFeatureConfig> BANANA_SMALL_BOHOL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.BANANA_LOG.get().getDefaultState())
				.leaves(BlockInit.BANANA_LEAVES.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.25D)
				.extraCavring(true)
				.maxSpawnHeight(68)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> PAPAYA_SMALL_BOHOL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PAPAYA_LOG.get().getDefaultState())
				.leaves(BlockInit.PAPAYA_LEAVES.get().getDefaultState())
				.trunkFruit(BlockInit.PAPAYA.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.25D)
				.extraCavring(true)
				.maxSpawnHeight(68)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> PAPAYA_EMERALD_SMALL_BOHOL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PAPAYA_LOG.get().getDefaultState())
				.leaves(BlockInit.PAPAYA_LEAVES.get().getDefaultState())
				.trunkFruit(BlockInit.PAPAYA_EMERALD.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.27D)
				.extraCavring(true)
				.maxSpawnHeight(68)
				.create() ;  
	
	public static Feature<BaseTreeFeatureConfig> PLAM_SMALL_BOHOL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PALM_LOG.get().getDefaultState())
				.leaves(BlockInit.PALM_LEAVES.get().getDefaultState())
				.baseCarving(1.35D)
				.extraCavring(false)
				.maxSpawnHeight(68)
				.create() ;  
	
	public static Feature<BaseTreeFeatureConfig> GREEN_PLAM_SMALL_BOHOL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.GREEN_PALM_LOG.get().getDefaultState())
				.leaves(BlockInit.GREEN_PALM_LEAVES.get().getDefaultState())
				.maxSpawnHeight(68)
				.create() ;
	
	/*
	 * PALM TREES
	 */
	
	public static Feature<BaseTreeFeatureConfig> BANANA_SMALL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.BANANA_LOG.get().getDefaultState())
				.leaves(BlockInit.BANANA_LEAVES.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.25D)
				.extraCavring(true)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> PAPAYA_SMALL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PAPAYA_LOG.get().getDefaultState())
				.leaves(BlockInit.PAPAYA_LEAVES.get().getDefaultState())
				.trunkFruit(BlockInit.PAPAYA.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.25D)
				.extraCavring(true)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> PAPAYA_EMERALD_SMALL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PAPAYA_LOG.get().getDefaultState())
				.leaves(BlockInit.PAPAYA_LEAVES.get().getDefaultState())
				.trunkFruit(BlockInit.PAPAYA_EMERALD.get().getDefaultState())
				.minSize(8)
				.maxSize(9)
				.baseCarving(1.27D)
				.extraCavring(true)
				.create() ;  
	
	public static Feature<BaseTreeFeatureConfig> PLAM_SMALL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.PALM_LOG.get().getDefaultState())
				.leaves(BlockInit.PALM_LEAVES.get().getDefaultState())
				.baseCarving(1.35D)
				.extraCavring(false)
				.create() ;  
	
	public static Feature<BaseTreeFeatureConfig> GREEN_PLAM_SMALL =
			new MidgardPalmTreeFeature.Builder()
				.log(BlockInit.GREEN_PALM_LOG.get().getDefaultState())
				.leaves(BlockInit.GREEN_PALM_LEAVES.get().getDefaultState())
				.create() ;  
	
	/*
	 * ASGARD
	 */
	public static Feature<NoFeatureConfig> ASGARD_BIFORST = new AsgadBifrostFeature(NoFeatureConfig::deserialize) ; 
	public static Feature<NoFeatureConfig> ASGARD_SMALL_ISLAND = new AsgardIslandFeature(NoFeatureConfig::deserialize) ; 
	
	
	/*
	 * MIDGARD
	 */	
	public static Feature<NoFeatureConfig> MIDGARD_BAHAY_KUBO = new MidgardBahayKubo(NoFeatureConfig::deserialize) ; 
	
	
	
	public static Feature<RiceFeatureConfig> RICE = new RiceFeature(RiceFeatureConfig::deserialize);

	public static Feature<NoFeatureConfig> MIDGARD_GOLD_WELL = new MidgardGoldWeelsFeature(NoFeatureConfig::deserialize) ; 

	public static Feature<NoFeatureConfig> MIDGARD_SMALL_ISLAND = new MidgardIslandFeature(NoFeatureConfig::deserialize) ; 
	public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType RDHP = RunDownHousePieces.Piece::new;
	
	public static Structure<NoFeatureConfig> MANGROVE_WITCH = new MangroveWitchHutStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType MANGROVE_WITCH_PIECES = MangroveWitchHutPieces.Piece::new;

	public static Structure<NoFeatureConfig> BAHAY_KUBO_HUT = new BahayKuboHutStructure(NoFeatureConfig::deserialize);
	//public static IStructurePieceType BAHAY_KUBO_HUT_PIECES = BahayKuboHutPieces.Piece::new;
	
	
	
	
	
	public static void registerFeatures(Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		Midgard.register(registry, RUN_DOWN_HOUSE, "run_down_house");
		register(RDHP, "RDHP");
		
		Midgard.register(registry, MANGROVE_WITCH, "mangrove_witch_hut");
		register(MANGROVE_WITCH_PIECES, "mangrove_witch_hut_pieces");

		Midgard.register(registry, BAHAY_KUBO_HUT, "bahay_kubo_hut");
		//register(BAHAY_KUBO_HUT_PIECES, "bahay_kubo_hut_pieces");
		
	}
	
	static IStructurePieceType register(IStructurePieceType structurePiece, String key) {
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
	
}
