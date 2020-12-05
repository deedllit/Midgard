package com.deedllit.midgard.common.block.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.trees.BigTree;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeTreeFeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;

public abstract class MidgardBigTreeConfig extends BigTree {
	
	
    @Override
    @Nullable
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean hasFlowers) {
        return null;
    }

	
    @Override
    @Nullable
    protected ConfiguredFeature<HugeTreeFeatureConfig, ?> getHugeTreeFeature(Random random) {
        return null;
    }
	
	
    protected abstract Feature<? extends BaseTreeFeatureConfig> getFeature(Random random);
    protected abstract Feature<? extends BaseTreeFeatureConfig> getBigFeature(Random random);
	
        
    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<?> chunkGeneratorIn, BlockPos blockPosIn,
    		BlockState blockStateIn, Random randomIn) {
		
    	Midgard.LOGGER.info("MidgardBigTreeConfig - place");

        for(int i = 0; i >= -1; --i) {
            for(int j = 0; j >= -1; --j) {
               if (canBigTreeSpawnAt(blockStateIn, worldIn, blockPosIn, i, j)) {
            	  Midgard.LOGGER.info("MidgardBigTreeConfig - place big one");
                  return this.func_227017_a_(worldIn, chunkGeneratorIn, blockPosIn, blockStateIn, randomIn, i, j);
               }
            }
         }
        
        Feature<BaseTreeFeatureConfig> feature = (Feature<BaseTreeFeatureConfig>)this.getFeature(randomIn);

        if (feature == null) {
        	return false; 
        } else {
        	
        	Midgard.LOGGER.info("MidgardBigTreeConfig - place -  small one");
        	worldIn.setBlockState(blockPosIn, Blocks.AIR.getDefaultState(), 4) ;
                	
        	if(feature.place(worldIn, chunkGeneratorIn, randomIn, blockPosIn, DefaultBiomeFeatures.OAK_TREE_CONFIG)) {
        		return true ;
        	} else {
            	worldIn.setBlockState(blockPosIn, blockStateIn, 4);
                return false;        		
        	}
        	
        }
        
      }
    
 
    
    
    
    
    
}
