package com.deedllit.midgard.world.feature.midgard.features;

import java.util.Random;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.block.trees.MidgardBigTreeConfig;
import com.deedllit.midgard.init.FeatureInit;

import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class MangroveTree extends MidgardBigTreeConfig {

	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getFeature(Random random) {
		Midgard.LOGGER.info("BlackPoplarTree - getFeature");
	
		return FeatureInit.MANGROVE_TREE;
	}

	
	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getBigFeature(Random random) {
		Midgard.LOGGER.info("BlackPoplarTree - getBigFeature");

		return null;
	}
	
	
}