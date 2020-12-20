package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.block.*;
import com.deedllit.midgard.common.block.fruits.*;
import com.deedllit.midgard.common.block.midgard.*;
import com.deedllit.midgard.common.objects.blocks.PedestalItemBlock;
import com.deedllit.midgard.core.block.MidgardSeaGrassBlock;
import com.deedllit.midgard.init.objects.blocks.*;
import com.deedllit.midgard.world.feature.midgard.features.*;
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
			() -> new MidgardPaneBlock(Block.Properties.create(Material.IRON, MaterialColor.AIR).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).notSolid()));
	
	public static final RegistryObject<Block> LEAD_BARS = BLOCKS.register("lead_bars",
			() -> new MidgardPaneBlock(Block.Properties.create(Material.IRON, MaterialColor.AIR).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL).notSolid()));

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
	
	
	//SKULL
	
	public static final RegistryObject<Block> COBBLESTONE_SKULLS = BLOCKS.register("cobblestone_skulls",
			() -> new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2.0F, 6.0F)));
	
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
	
	
	//PAPAYA TREE

	public static final RegistryObject<Block> PAPAYA_LOG = BLOCKS.register("papaya_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
						
	public static final RegistryObject<Block> PAPAYA_LEAVES = BLOCKS.register("papaya_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> PAPAYA_SAPLING = BLOCKS.register("papaya_sapling",
			() -> new MidgardSaplingBlock(new PapayaTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));
	
	public static final RegistryObject<Block> PAPAYA = BLOCKS.register("papaya",
			() -> new PapayaFruitBlock(Block.Properties.from(Blocks.COCOA)));

	public static final RegistryObject<Block> PAPAYA_EMERALD = BLOCKS.register("papaya_emerald",
			() -> new PapayaFruitBlock(Block.Properties.from(Blocks.COCOA)));

	//BANANA TREE

	public static final RegistryObject<Block> BANANA_LOG = BLOCKS.register("banana_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG).hardnessAndResistance(1.0F)));
						
	public static final RegistryObject<Block> BANANA_LEAVES = BLOCKS.register("banana_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> BANANA_SAPLING = BLOCKS.register("banana_sapling",
			() -> new MidgardSaplingBlock(new BananaTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));
	
	public static final RegistryObject<Block> BANANA = BLOCKS.register("banana",
			() -> new BananaFruitBlock(Block.Properties.from(Blocks.COCOA)));

	//PALM TREE

	public static final RegistryObject<Block> PALM_LOG = BLOCKS.register("palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_PALM_LOG = BLOCKS.register("stripped_palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> PALM_WOOD = BLOCKS.register("palm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_PALM_WOOD = BLOCKS.register("stripped_palm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> PALM_PLANKS = BLOCKS.register("palm_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> PALM_STAIRS = BLOCKS.register("palm_stairs",
			() -> new StairsBlock(() -> BlockInit.PALM_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> PALM_FENCE = BLOCKS.register("palm_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> PALM_FENCE_GATE = BLOCKS.register("palm_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> PALM_BUTTON = BLOCKS.register("palm_button",
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> PALM_PRESSURE_PLATE = BLOCKS.register("palm_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
					
	public static final RegistryObject<Block> PALM_LEAVES = BLOCKS.register("palm_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> PALM_SAPLING = BLOCKS.register("palm_sapling",
			() -> new MidgardSaplingBlock(new PalmTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));
	
	//GREEN_PALM TREE

	public static final RegistryObject<Block> GREEN_PALM_LOG = BLOCKS.register("green_palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_GREEN_PALM_LOG = BLOCKS.register("stripped_green_palm_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> GREEN_PALM_WOOD = BLOCKS.register("green_palm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_GREEN_PALM_WOOD = BLOCKS.register("stripped_green_palm_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> GREEN_PALM_PLANKS = BLOCKS.register("green_palm_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> GREEN_PALM_STAIRS = BLOCKS.register("green_palm_stairs",
			() -> new StairsBlock(() -> BlockInit.GREEN_PALM_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> GREEN_PALM_FENCE = BLOCKS.register("green_palm_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> GREEN_PALM_FENCE_GATE = BLOCKS.register("green_palm_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> GREEN_PALM_BUTTON = BLOCKS.register("green_palm_button",
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> GREEN_PALM_PRESSURE_PLATE = BLOCKS.register("green_palm_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
					
	public static final RegistryObject<Block> GREEN_PALM_LEAVES = BLOCKS.register("green_palm_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> GREEN_PALM_SAPLING = BLOCKS.register("green_palm_sapling",
			() -> new MidgardSaplingBlock(new GreenPalmTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));

	
	//BLUE_SPRUCE TREE

	public static final RegistryObject<Block> BLUE_SPRUCE_LOG = BLOCKS.register("blue_spruce_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_BLUE_SPRUCE_LOG = BLOCKS.register("stripped_blue_spruce_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> BLUE_SPRUCE_WOOD = BLOCKS.register("blue_spruce_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_BLUE_SPRUCE_WOOD = BLOCKS.register("stripped_blue_spruce_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> BLUE_SPRUCE_PLANKS = BLOCKS.register("blue_spruce_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> BLUE_SPRUCE_STAIRS = BLOCKS.register("blue_spruce_stairs",
			() -> new StairsBlock(() -> BlockInit.BLUE_SPRUCE_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> BLUE_SPRUCE_FENCE = BLOCKS.register("blue_spruce_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLUE_SPRUCE_FENCE_GATE = BLOCKS.register("blue_spruce_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> BLUE_SPRUCE_BUTTON = BLOCKS.register("blue_spruce_button",
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLUE_SPRUCE_PRESSURE_PLATE = BLOCKS.register("blue_spruce_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
					
	public static final RegistryObject<Block> BLUE_SPRUCE_LEAVES = BLOCKS.register("blue_spruce_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));

	public static final RegistryObject<Block> BLUE_SPRUCE_SAPLING = BLOCKS.register("blue_spruce_sapling",
			() -> new MidgardSaplingBlock(new BlueSpruceTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));

						
	
	//NORWAY_SPRUCE TREE

	public static final RegistryObject<Block> NORWAY_SPRUCE_LOG = BLOCKS.register("norway_spruce_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));
	
	public static final RegistryObject<Block> STRIPPED_NORWAY_SPRUCE_LOG = BLOCKS.register("stripped_norway_spruce_log",
			() -> new LogBlock(MaterialColor.WOOD, Block.Properties.from(Blocks.DARK_OAK_LOG)));

	public static final RegistryObject<Block> NORWAY_SPRUCE_WOOD = BLOCKS.register("norway_spruce_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> STRIPPED_NORWAY_SPRUCE_WOOD = BLOCKS.register("stripped_norway_spruce_wood",
			() -> new RotatedPillarBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD).hardnessAndResistance(2.0F).sound(SoundType.WOOD)));

	public static final RegistryObject<Block> NORWAY_SPRUCE_PLANKS = BLOCKS.register("norway_spruce_planks",
			() -> new Block(Block.Properties.from(Blocks.DARK_OAK_PLANKS)));

	public static final RegistryObject<Block> NORWAY_SPRUCE_STAIRS = BLOCKS.register("norway_spruce_stairs",
			() -> new StairsBlock(() -> BlockInit.NORWAY_SPRUCE_PLANKS.get().getDefaultState(),
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> NORWAY_SPRUCE_FENCE = BLOCKS.register("norway_spruce_fence",
			() -> new FenceBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> NORWAY_SPRUCE_FENCE_GATE = BLOCKS.register("norway_spruce_fence_gate",
			() -> new FenceGateBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));

	public static final RegistryObject<Block> NORWAY_SPRUCE_BUTTON = BLOCKS.register("norway_spruce_button",
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> NORWAY_SPRUCE_PRESSURE_PLATE = BLOCKS.register("norway_spruce_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
					
	public static final RegistryObject<Block> NORWAY_SPRUCE_LEAVES = BLOCKS.register("norway_spruce_leaves",
			() -> new LeavesBlock(Block.Properties.from(Blocks.OAK_LEAVES)));
	
	public static final RegistryObject<Block> NORWAY_SPRUCE_SAPLING = BLOCKS.register("norway_spruce_sapling",
			() -> new MidgardSaplingBlock(new NorwaySpruceTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));

	
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
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ELM_PRESSURE_PLATE = BLOCKS.register("elm_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
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
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> ASH_PRESSURE_PLATE = BLOCKS.register("ash_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
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
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> WHITE_POPLAR_PRESSURE_PLATE = BLOCKS.register("white_poplar_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
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
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> BLACK_POPLAR_PRESSURE_PLATE = BLOCKS.register("black_poplar_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> POPLAR_SAPLING = BLOCKS.register("poplar_sapling",
			() -> new MidgardSaplingBlock(new BlackPoplarTree(),  Block.Properties.from(Blocks.OAK_SAPLING)));
	
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
			() -> new MidgardWoodButtonBlock(Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_PRESSURE_PLATE = BLOCKS.register("midgard_mangrove_pressure_plate",
			() -> new MidgardPressurePlateBlock(Sensitivity.EVERYTHING,
					Block.Properties.create(Material.WOOD, MaterialColor.WOOD)));
	
	public static final RegistryObject<Block> MIDGARD_MANGROVE_LEAVES = BLOCKS.register("midgard_mangrove_leaves",
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
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.FIRE_RESISTANCE, 20, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> CHARDON = BLOCKS.register("chardon",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> FUCHSIA_BISTORT = BLOCKS.register("fuchsia_bistort",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PINK_BISTORT = BLOCKS.register("pink_bistort",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 1, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> GUZMANIA_RED = BLOCKS.register("guzmania_red",
			() -> new MidgardFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> KANGAROO_PAW_PINK = BLOCKS.register("kangaroo_paw_pink",
			() -> new MidgardFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> KANGAROO_PAW_ORANGE = BLOCKS.register("kangaroo_paw_orange",
			() -> new MidgardFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;

	public static final RegistryObject<Block> GUZMANIA_PINK = BLOCKS.register("guzmania_pink",
			() -> new MidgardFlowerBlock(PlantType.Desert,new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	public static final RegistryObject<Block> FISH_HOOK = BLOCKS.register("fish_hook",
			() -> new MidgardFlowerBlock(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND}, Effects.REGENERATION, 1, Block.Properties.from(Blocks.ALLIUM))) ;
	
	
	public static final RegistryObject<Block> FIRELILY = BLOCKS.register("firelily",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> LAVENDER = BLOCKS.register("lavender",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> ALPINE_BETONY = BLOCKS.register("alpine_betony",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PINK_CALLUNA = BLOCKS.register("pink_calluna",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> EDELWEISS = BLOCKS.register("edelweiss",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.REGENERATION, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> WHITE_WOLFS_BANE = BLOCKS.register("white_wolfs_bane",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> YELLOW_WOLFS_BANE = BLOCKS.register("yellow_wolfs_bane",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> PURPLE_WOLFS_BANE = BLOCKS.register("purple_wolfs_bane",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> DESERT_GRASS = BLOCKS.register("desert_grass",
			() -> new YggdrasilGrass(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND} , Block.Properties.from(Blocks.GRASS))) ;
	
	public static final RegistryObject<Block> PURPLE_SEA_HORSE = BLOCKS.register("purple_sea_horse",
			() -> new MidgardSeaGrassBlock(Block.Properties.from(Blocks.SEAGRASS)));

	public static final RegistryObject<Block> HAWORTHIA_HAWORTHIOPSIS = BLOCKS.register("haworthia_haworthiopsis",
			() -> new YggdrasilGrass(PlantType.Desert, new Block[] {Blocks.SAND, Blocks.RED_SAND} , Block.Properties.from(Blocks.GRASS))) ;
	
	public static final RegistryObject<Block> HYACINTH_BLUE = BLOCKS.register("hyacinth_blue",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;

	public static final RegistryObject<Block> HYACINTH_ORANGE = BLOCKS.register("hyacinth_orange",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_PINK = BLOCKS.register("hyacinth_pink",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_RED = BLOCKS.register("hyacinth_red",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_WHITE = BLOCKS.register("hyacinth_white",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
	public static final RegistryObject<Block> HYACINTH_YELLOW = BLOCKS.register("hyacinth_yellow",
			() -> new MidgardFlowerBlock(PlantType.Plains, Blocks.GRASS, Effects.POISON, 2, Block.Properties.from(Blocks.POPPY))) ;
	
		
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
			() -> new MidgardSulfurCrystal(Block.Properties.from(Blocks.STONE))) ;


	
}


