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

	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_SMALL =
			new MidgardTaigaTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.create() ;  
			
	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_MEDIUM =
			new MidgardTaigaTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(10)
				.maxSize(16)
				.create() ;  

	public static Feature<BaseTreeFeatureConfig> BLUE_SPRUCE_GIANT =
			new MidgardTaigaTreeFeature.Builder()
				.log(BlockInit.BLUE_SPRUCE_LOG.get().getDefaultState())
				.leaves(BlockInit.BLUE_SPRUCE_LEAVES.get().getDefaultState())
				.minSize(16)
				.maxSize(22)
				.create() ;  

	
	/*
	 * ASGARD
	 */
	public static Feature<NoFeatureConfig> ASGARD_BIFORST = new AsgadBifrostFeature(NoFeatureConfig::deserialize) ; 
	public static Feature<NoFeatureConfig> ASGARD_SMALL_ISLAND = new AsgardIslandFeature(NoFeatureConfig::deserialize) ; 
	
	
	/*
	 * MIDGARD
	 */	
	
	
	
	public static Feature<RiceFeatureConfig> RICE = new RiceFeature(RiceFeatureConfig::deserialize);

	public static Feature<NoFeatureConfig> MIDGARD_GOLD_WELL = new MidgardGoldWeelsFeature(NoFeatureConfig::deserialize) ; 

	public static Feature<NoFeatureConfig> MIDGARD_SMALL_ISLAND = new MidgardIslandFeature(NoFeatureConfig::deserialize) ; 
	public static Structure<NoFeatureConfig> RUN_DOWN_HOUSE = new RunDownHouseStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType RDHP = RunDownHousePieces.Piece::new;
	public static Structure<NoFeatureConfig> MANGROVE_WITCH = new MangroveWitchHutStructure(NoFeatureConfig::deserialize);
	public static IStructurePieceType MANGROVE_WITCH_PIECES = MangroveWitchHutPieces.Piece::new;

	
	
	
	
	
	public static void registerFeatures(Register<Feature<?>> event) {
		IForgeRegistry<Feature<?>> registry = event.getRegistry();

		Midgard.register(registry, RUN_DOWN_HOUSE, "run_down_house");
		register(RDHP, "RDHP");
		
		Midgard.register(registry, MANGROVE_WITCH, "mangrove_witch_hut");
		register(MANGROVE_WITCH_PIECES, "mangrove_witch_hut_pieces");

		
	}
	
	static IStructurePieceType register(IStructurePieceType structurePiece, String key) {
		return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), structurePiece);
	}
	
}
