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

public class BlueSpruceTree extends MidgardBigTreeConfig {

	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getFeature(Random random) {
		Midgard.LOGGER.info("BlueSpruceTree - getFeature");

		int i = random.nextInt(30) ; 
		
		if(i == 0) {
			return FeatureInit.BLUE_SPRUCE_GIANT;
		} 
		
		if(i < 10) {
			return FeatureInit.BLUE_SPRUCE_MEDIUM;
		} 

		
		return FeatureInit.BLUE_SPRUCE_SMALL;
	}

	
	@Override
	protected Feature<? extends BaseTreeFeatureConfig> getBigFeature(Random random) {
		Midgard.LOGGER.info("BlueSpruceTree - getBigFeature");

		return null;
	}
	
	
}
