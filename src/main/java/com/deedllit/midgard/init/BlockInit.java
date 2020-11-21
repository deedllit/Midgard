package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.block.*;
import com.deedllit.midgard.common.block.midgard.*;
import com.deedllit.midgard.common.objects.blocks.PedestalItemBlock;
import com.deedllit.midgard.core.block.MidgardSeaGrassBlock;
import com.deedllit.midgard.init.objects.blocks.*;
import com.deedllit.midgard.world.feature.midgard.trees.*;

import net.minecraft.block.PressurePlateBlock.Sensitivity;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.SandBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

	public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS,  Midgard.MOD_ID) ; 	

	public static final RegistryObject<Block> SULFUR_BLOCK = BLOCKS.register("sulfur",
			() -> new Block(Block.Properties.from(Blocks.GRAVEL)));

	public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));
	
	public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore",
			() -> new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> COPPER_BARS = BLOCKS.register("copper_bars",
			() -> new YggdrasilPaneBlock(Block.Properties.create(Material.IRON, MaterialColor.AIR).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).notSolid()));
	
	public static final RegistryObject<Block> LEAD_BARS = BLOCKS.register("lead_bars",
			() -> new YggdrasilPaneBlock(Block.Properties.create(Material.IRON, MaterialColor.AIR).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).notSolid()));

	public static final RegistryObject<Block> PINK_QUARTZ_ORE = BLOCKS.register("pink_quartz_ore",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(0.8F).sound(SoundType.STONE)));

	
	 /* SPEICAL BLOCK
	 */
	
	public static final RegistryObject<Block> PEDESTAL_ITEM = BLOCKS.register("pedestal_item",
			() -> new PedestalItemBlock(Block.Properties.from(Blocks.ANVIL)));

	
	/*
	 * MIDGARD
	 */

	public static final RegistryObject<Block> MIDGARD_RICE_BOTTOM_CROP = BLOCKS.register("rice_bottom_crop",
			() -> new RiceBottomCropBlock(Block.Properties.from(Blocks.KELP), 
					1, 1, 2, 2,
					new Block[] {Blocks.SAND, Blocks.DIRT, Blocks.CLAY, Blocks.GRAVEL})
			);
	
	public static final RegistryObject<Block> MIDGARD_RICE_TOP_CROP = BLOCKS.register("rice_top_crop",
			() -> new RiceTopCropBlock(Block.Properties.from(Blocks.WHEAT))
			);

	//PINK_QUARTZ
	
	public static final RegistryObject<Block> PINK_QUARTZ_BLOCK = BLOCKS.register("pink_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> CHISELED_PINK_QUARTZ_BLOCK = BLOCKS.register("chiseled_pink_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> PINK_QUARTZ_PILLAR = BLOCKS.register("pink_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> PINK_QUARTZ_STAIRS = BLOCKS.register("pink_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.PINK_QUARTZ_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> SMOOTH_PINK_QUARTZ = BLOCKS.register("smooth_pink_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> SMOOTH_PINK_QUARTZ_STAIRS = BLOCKS.register("smooth_pink_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_PINK_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> PINK_QUARTZ_SLAB = BLOCKS.register("pink_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));

	public static final RegistryObject<Block> SMOOTH_PINK_QUARTZ_SLAB = BLOCKS.register("smooth_pink_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));
	
	//AMETHYST_QUARTZ
	
	
	public static final RegistryObject<Block> AMETHYST_QUARTZ_BLOCK = BLOCKS.register("amethyst_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> CHISELED_AMETHYST_QUARTZ_BLOCK = BLOCKS.register("chiseled_amethyst_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> AMETHYST_QUARTZ_PILLAR = BLOCKS.register("amethyst_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> AMETHYST_QUARTZ_STAIRS = BLOCKS.register("amethyst_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.AMETHYST_QUARTZ_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> SMOOTH_AMETHYST_QUARTZ = BLOCKS.register("smooth_amethyst_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> SMOOTH_AMETHYST_QUARTZ_STAIRS = BLOCKS.register("smooth_amethyst_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_AMETHYST_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> AMETHYST_QUARTZ_SLAB = BLOCKS.register("amethyst_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));

	public static final RegistryObject<Block> SMOOTH_AMETHYST_QUARTZ_SLAB = BLOCKS.register("smooth_amethyst_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));
	
	//GREEN QUARTZ

	
	public static final RegistryObject<Block> GREEN_QUARTZ_BLOCK = BLOCKS.register("green_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> CHISELED_GREEN_QUARTZ_BLOCK = BLOCKS.register("chiseled_green_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> GREEN_QUARTZ_PILLAR = BLOCKS.register("green_quartz_pillar",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> GREEN_QUARTZ_STAIRS = BLOCKS.register("green_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.GREEN_QUARTZ_BLOCK.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> SMOOTH_GREEN_QUARTZ = BLOCKS.register("smooth_green_quartz",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));

	public static final RegistryObject<Block> SMOOTH_GREEN_QUARTZ_STAIRS = BLOCKS.register("smooth_green_quartz_stairs",
			() -> new StairsBlock(() -> BlockInit.SMOOTH_GREEN_QUARTZ.get().getDefaultState(),
					Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ)));
	
	public static final RegistryObject<Block> MOZAIC_GREEN_QUARTZ_BLOCK = BLOCKS.register("mozaic_green_quartz_block",
			() -> new Block(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(0.8F)));
	
	public static final RegistryObject<Block> GREEN_QUARTZ_SLAB = BLOCKS.register("green_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));

	public static final RegistryObject<Block> SMOOTH_GREEN_QUARTZ_SLAB = BLOCKS.register("smooth_green_quartz_slab",
			() -> new SlabBlock(Block.Properties.create(Material.ROCK, MaterialColor.QUARTZ).hardnessAndResistance(2.0F, 6.0F)));
	
	//ELM TREE
	
	public static final RegistryObject<Block> ELM_LOG = BLOCKS.register("elm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> STRIPPED_ELM_LOG = BLOCKS.register("stripped_elm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> ELM_WOOD = BLOCKS.register("elm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_ELM_WOOD = BLOCKS.register("stripped_elm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> ELM_PLANKS = BLOCKS.register("elm_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> ELM_STAIRS = BLOCKS.register("elm_stairs",
			() -> new StairsBlock(() -> BlockInit.ELM_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_FENCE = BLOCKS.register("elm_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_FENCE_GATE = BLOCKS.register("elm_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> ELM_BUTTON = BLOCKS.register("elm_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_PRESSURE_PLATE = BLOCKS.register("elm_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
		
	//ASH TREE

	public static final RegistryObject<Block> ASH_LOG = BLOCKS.register("ash_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_ASH_LOG = BLOCKS.register("stripped_ash_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> ASH_WOOD = BLOCKS.register("ash_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_ASH_WOOD = BLOCKS.register("stripped_ash_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> ASH_PLANKS = BLOCKS.register("ash_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> ASH_STAIRS = BLOCKS.register("ash_stairs",
			() -> new StairsBlock(() -> BlockInit.ASH_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> ASH_FENCE = BLOCKS.register("ash_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ASH_FENCE_GATE = BLOCKS.register("ash_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> ASH_BUTTON = BLOCKS.register("ash_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ASH_PRESSURE_PLATE = BLOCKS.register("ash_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	//COCO NUT
	
	public static final RegistryObject<Block> COCO_NUT_PLANKS = BLOCKS.register("coco_nut_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> COCO_NUT_STAIRS = BLOCKS.register("coco_nut_stairs",
			() -> new StairsBlock(() -> BlockInit.COCO_NUT_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	

	//WHITE POPLAR
	public static final RegistryObject<Block> WHITE_POPLAR_LOG = BLOCKS.register("white_poplar_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> STRIPPED_WHITE_POPLAR_LOG = BLOCKS.register("stripped_white_poplar_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> WHITE_POPLAR_WOOD = BLOCKS.register("white_poplar_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_WHITE_POPLAR_WOOD = BLOCKS.register("stripped_white_poplar_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> WHITE_POPLAR_PLANKS = BLOCKS.register("white_poplar_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> WHITE_POPLAR_STAIRS = BLOCKS.register("white_poplar_stairs",
			() -> new StairsBlock(() -> BlockInit.WHITE_POPLAR_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> WHITE_POPLAR_FENCE = BLOCKS.register("white_poplar_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> WHITE_POPLAR_FENCE_GATE = BLOCKS.register("white_poplar_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> WHITE_POPLAR_BUTTON = BLOCKS.register("white_poplar_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> WHITE_POPLAR_PRESSURE_PLATE = BLOCKS.register("white_poplar_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	//BLACK POPLAR
	public static final RegistryObject<Block> BLACK_POPLAR_LOG = BLOCKS.register("black_poplar_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_BLACK_POPLAR_LOG = BLOCKS.register("stripped_black_poplar_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> BLACK_POPLAR_WOOD = BLOCKS.register("black_poplar_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_BLACK_POPLAR_WOOD = BLOCKS.register("stripped_black_poplar_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));
	
	public static final RegistryObject<Block> BLACK_POPLAR_PLANKS = BLOCKS.register("black_poplar_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> BLACK_POPLAR_STAIRS = BLOCKS.register("black_poplar_stairs",
			() -> new StairsBlock(() -> BlockInit.BLACK_POPLAR_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLACK_POPLAR_FENCE = BLOCKS.register("black_poplar_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLACK_POPLAR_FENCE_GATE = BLOCKS.register("black_poplar_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> BLACK_POPLAR_BUTTON = BLOCKS.register("black_poplar_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLACK_POPLAR_PRESSURE_PLATE = BLOCKS.register("black_poplar_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	
	//MIDGARD_MANGROVE TREE

	public static final RegistryObject<Block> MIDGARD_MANGROVE_LOG = BLOCKS.register("midgard_mangrove_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_MIDGARD_MANGROVE_LOG = BLOCKS.register("stripped_midgard_mangrove_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_WOOD = BLOCKS.register("midgard_mangrove_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_MIDGARD_MANGROVE_WOOD = BLOCKS.register("stripped_midgard_mangrove_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_PLANKS = BLOCKS.register("midgard_mangrove_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_STAIRS = BLOCKS.register("midgard_mangrove_stairs",
			() -> new StairsBlock(() -> BlockInit.MIDGARD_MANGROVE_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_FENCE = BLOCKS.register("midgard_mangrove_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_FENCE_GATE = BLOCKS.register("midgard_mangrove_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> MIDGARD_MANGROVE_BUTTON = BLOCKS.register("midgard_mangrove_button",
			() -> new YggdrasilWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_PRESSURE_PLATE = BLOCKS.register("midgard_mangrove_pressure_plate",
			() -> new YggdrasilPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_LEAVES = BLOCKS.register("midgard_mangrove_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	
	public static final RegistryObject<Block> PALM_LOG = BLOCKS.register("palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> GREEN_PALM_LOG = BLOCKS.register("green_palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> PALM_LEAVES = BLOCKS.register("palm_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> IRON_WOOD_LOG = BLOCKS.register("iron_wood_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> IRON_WOOD_LEAVES = BLOCKS.register("iron_wood_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> IRON_WOOD_SAPLING = BLOCKS.register("iron_wood_sapling",
			() -> new IronWoodSaplingBlock(() -> new IronWoodTree(), Block.Properties.from(Blocks.OAK_SAPLING)));

	public static final RegistryObject<Block> HIBICUS_TREE_LEAVES = BLOCKS.register("hibiscus_tree_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	
	
	public static final RegistryObject<Block> MIDGARD_BLUE_POMELIA_BUSH = BLOCKS.register("midgard_blue_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_TEAL_POMELIA_BUSH = BLOCKS.register("midgard_teal_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_PINK_POMELIA_BUSH = BLOCKS.register("midgard_pink_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_ORANGE_POMELIA_BUSH = BLOCKS.register("midgard_orange_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> MIDGARD_WHITE_POMELIA_BUSH = BLOCKS.register("midgard_white_pomelia_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));
	
	public static final RegistryObject<Block> IXIA_VIRIDIFLORA_TEAL_BUSH = BLOCKS.register("ixia_viridiflora_teal_bush", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.ROSE_BUSH)));

	public static final RegistryObject<Block> RED_SUNFLOWER = BLOCKS.register("red_sunflower", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.SUNFLOWER)));
	
	public static final RegistryObject<Block> PURPLE_SUNFLOWER = BLOCKS.register("purple_sunflower", 
			() -> new TallFlowerBlock(Block.Properties.from(Blocks.SUNFLOWER)));

	public static final RegistryObject<Block> SWEET_PEA = BLOCKS.register("sweet_pea",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.FIRE_RESISTANCE, 20, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> CHARDON = BLOCKS.register("chardon",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> FUCHSIA_BISTORT = BLOCKS.register("fuchsia_bistort",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PINK_BISTORT = BLOCKS.register("pink_bistort",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> GUZMANIA_RED = BLOCKS.register("guzmania_red",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> KANGAROO_PAW_PINK = BLOCKS.register("kangaroo_paw_pink",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> KANGAROO_PAW_ORANGE = BLOCKS.register("kangaroo_paw_orange",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> GUZMANIA_PINK = BLOCKS.register("guzmania_pink",
			() -> new YggdrasilFlowerBlock(PlantType.Desert,new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	public static final RegistryObject<Block> FISH_HOOK = BLOCKS.register("fish_hook",
			() -> new YggdrasilFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	
	public static final RegistryObject<Block> FIRELILY = BLOCKS.register("firelily",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> ALPINE_BETONY = BLOCKS.register("alpine_betony",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PINK_CALLUNA = BLOCKS.register("pink_calluna",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> EDELWEISS = BLOCKS.register("edelweiss",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> WHITE_WOLFS_BANE = BLOCKS.register("white_wolfs_bane",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> YELLOW_WOLFS_BANE = BLOCKS.register("yellow_wolfs_bane",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PURPLE_WOLFS_BANE = BLOCKS.register("purple_wolfs_bane",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> DESERT_GRASS = BLOCKS.register("desert_grass",
			() -> new YggdrasilGrass(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND} , Block.Properties.from(Blocks.GRASS))) ;
	
	public static final RegistryObject<Block> PURPLE_SEA_HORSE = BLOCKS.register("purple_sea_horse",
			() -> new MidgardSeaGrassBlock(Block.Properties.from(Blocks.SEAGRASS)));

	public static final RegistryObject<Block> HAWORTHIA_HAWORTHIOPSIS = BLOCKS.register("haworthia_haworthiopsis",
			() -> new YggdrasilGrass(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND} , Block.Properties.from(Blocks.GRASS))) ;
	
	public static final RegistryObject<Block> HYACINTH_BLUE = BLOCKS.register("hyacinth_blue",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> HYACINTH_ORANGE = BLOCKS.register("hyacinth_orange",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_PINK = BLOCKS.register("hyacinth_pink",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_RED = BLOCKS.register("hyacinth_red",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_WHITE = BLOCKS.register("hyacinth_white",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_YELLOW = BLOCKS.register("hyacinth_yellow",
			() -> new YggdrasilFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
		
	public static final RegistryObject<Block> WHITE_SAND = BLOCKS.register("white_sand", 
			() -> new SandBlock(15527400, Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));

	public static final RegistryObject<Block> BLACK_SAND = BLOCKS.register("black_sand", 
			() -> new SandBlock(1710618, Block.Properties.create(Material.SAND, MaterialColor.SAND).hardnessAndResistance(0.5F).sound(SoundType.SAND)));

	public static final RegistryObject<Block> TEAK_WOOD_LOG = BLOCKS.register("teak_wood_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	/*
	 *  MUSPELHEIM
	 */		
	
	public static final RegistryObject<Block> SULFUR_CRYSTAL_BLOCK = BLOCKS.register("sulfur_crystal_block",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F).sound(SoundType.STONE)));

	public static final RegistryObject<Block> SULFUR_CRYSTAL = BLOCKS.register("sulfur_crystal",
			() -> new YggdrasilSulfurCrystal(Block.Properties.from(Blocks.STONE))) ;


	
}


