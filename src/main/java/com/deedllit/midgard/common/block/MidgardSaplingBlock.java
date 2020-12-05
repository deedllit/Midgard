package com.deedllit.midgard.common.block;

import java.util.Random;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.trees.Tree;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

/*
 * Copy of SaplingBlock
 */

public class MidgardSaplingBlock extends SaplingBlock implements IGrowable {

	public static final IntegerProperty STAGE = BlockStateProperties.STAGE_0_1;
	public static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
	private final Tree tree;

	public MidgardSaplingBlock(Tree treeIn, Properties properties) {
		super(treeIn, properties);
		this.tree = treeIn;
	}

	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE;
	}
	
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		Midgard.LOGGER.info("MidgardSapling - tick");
		
		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		if (worldIn.getLight(pos.up()) >= 9 && rand.nextInt(7) == 0) {
			this.placeTree(worldIn, pos, state, rand);
		}

	}

	/**
	 * place a tree in the world at the given position
	 */
	@Override
	public void placeTree(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand) {
		Midgard.LOGGER.info("MidgardSapling - placeTree");

		if (state.get(STAGE) == 0) {
			worldIn.setBlockState(pos, state.cycle(STAGE), 4);
		} else {
			if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(worldIn, rand, pos))
				return;
			this.tree.place(worldIn, worldIn.getChunkProvider().getChunkGenerator(), pos, state, rand);
		}

	}

	/**
	 * Whether this IGrowable can grow
	 */
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		
		Midgard.LOGGER.info("MidgardSapling - canGrow");
		
		return true;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		Midgard.LOGGER.info("MidgardSapling - canUseBonemeal");
		return (double) worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		Midgard.LOGGER.info("MidgardSapling - grow");
		this.placeTree(worldIn, pos, state, rand);
	}

	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(STAGE);
	}
	
}
