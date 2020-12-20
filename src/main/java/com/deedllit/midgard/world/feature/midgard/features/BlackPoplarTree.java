package com.deedllit.midgard.world.feature.midgard.features;

import java.util.Random;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.block.trees.MidgardBigTreeConfig;
import com.deedllit.midgard.init.FeatureInit;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class BlackPoplarTree extends MidgardBigTreeConfig {

	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getFeature(Random random) {
		Midgard.LOGGER.info("BlackPoplarTree - getFeature");
	
		return FeatureInit.BLACK_POPLAR_SMALL;
	}

	
	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getBigFeature(Random random) {
		Midgard.LOGGER.info("BlackPoplarTree - getBigFeature");

		return null;
	}
	
	
}
