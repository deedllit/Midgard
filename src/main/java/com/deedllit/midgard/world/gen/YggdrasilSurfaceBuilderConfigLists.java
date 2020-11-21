package com.deedllit.midgard.world.gen;

import com.deedllit.midgard.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class YggdrasilSurfaceBuilderConfigLists {

	public static final BlockState STONE = Blocks.STONE.getDefaultState();
	public static final BlockState SAND = Blocks.SAND.getDefaultState();
	public static final BlockState GRAVEL = Blocks.GRAVEL.getDefaultState();

	public static final BlockState MAGMA_BLOCK = Blocks.MAGMA_BLOCK.getDefaultState();
	public static final BlockState SULFUR_BLOCK = BlockInit.SULFUR_BLOCK.get().getDefaultState();
	
	public static SurfaceBuilderConfig STONE_STONE_STONE = new SurfaceBuilderConfig(STONE, STONE, STONE);
	
	
}
