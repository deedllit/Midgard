package com.deedllit.midgard.world.feature.midgard.structures;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.util.holder.PreBuildBlockStateHolder;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockStateMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MidgardBahayKubo extends Feature<NoFeatureConfig> {

	private static final BlockStateMatcher IS_GRASS = BlockStateMatcher.forBlock(Blocks.GRASS_BLOCK);
	private static final BlockStateMatcher IS_WHITE_SAND = BlockStateMatcher.forBlock(BlockInit.WHITE_SAND.get());

	private PreBuildBlockStateHolder blockStateHolder;

	public MidgardBahayKubo(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	private boolean checkPos(IWorld worldIn, BlockPos pos, long x, long y, long z, BlockState newBlock,
			boolean needBeEmtpy) {

		if (needBeEmtpy) {
			if (worldIn.getBlockState(pos.add(x, y, z)) != Blocks.AIR.getDefaultState()) {
				return false;
			}
		}

		blockStateHolder.add(x, y, z, newBlock);
		return true;
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {

		BlockState planks = Blocks.JUNGLE_PLANKS.getDefaultState() ; 
		
		for (pos = pos.up(); worldIn.isAirBlock(pos) && pos.getY() > 2; pos = pos.down()) {
			;
		}

		blockStateHolder = new PreBuildBlockStateHolder();
		
		if (!IS_GRASS.test(worldIn.getBlockState(pos)) && !IS_WHITE_SAND.test(worldIn.getBlockState(pos)))
			return false;

		// house
		for (int x = -2; x <= 2; x++) {
			for (int y = -2; y <= 2; y++) {

				if (!checkPos(worldIn, pos, x, 4, y, planks, true))
					return false;

				if (!checkPos(worldIn, pos, x, 8, y, planks, true))
					return false;

			}
		}
		
		return true;
	}

}
