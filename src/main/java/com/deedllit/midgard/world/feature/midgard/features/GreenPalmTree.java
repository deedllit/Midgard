package com.deedllit.midgard.world.feature.midgard.features;

import java.util.Random;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.block.trees.MidgardBigTreeConfig;
import com.deedllit.midgard.init.FeatureInit;

import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class GreenPalmTree extends MidgardBigTreeConfig {

	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getFeature(Random random) {
		Midgard.LOGGER.info("GreenPalmTree - getFeature");



		
		return FeatureInit.GREEN_PLAM_SMALL;
	}

	
	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getBigFeature(Random random) {
		Midgard.LOGGER.info("GreenPalmTree - getBigFeature");

		return null;
	}
	
	
}
