package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;

//https://github.com/Glitchfiend/BiomesOPlenty/blob/fab38c4c3527dffebd8d67cf49a5e809280ffb94/src/main/java/biomesoplenty/common/world/gen/feature/tree/BasicTreeFeature.java

public class MidgardBasicTreeFeature extends MidgardAbstractTreeFeature {


	public static class Builder extends InnerBuilder<Builder, MidgardBasicTreeFeature> {
        @Override
        public MidgardBasicTreeFeature create() {
            return new MidgardBasicTreeFeature(this.placeOn, this.log, this.leaves, this.vine, this.trunkFruit, this.minSize, this.maxSize);
        }
    }

    protected static abstract class InnerBuilder<T extends BuilderBase, F extends MidgardBasicTreeFeature> extends BuilderBase<T, F>{
        public InnerBuilder() {
            this.placeOn = (world, pos) ->
            {
                return world.getBlockState(pos).canProvidePower();
            };
        	this.minSize = 4 ;         	
        	this.maxSize = 7 ; 
        }
    }
    
    protected MidgardBasicTreeFeature(IBlockPosQuery placeOn, BlockState leaves, BlockState log, BlockState vine, BlockState trunkFruit,
			int minSize, int maxSize) {
		super(placeOn, leaves, log, vine, trunkFruit, minSize, maxSize);
		
	}
    

    
    
    @Override
    protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn,
    		Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn,
    		BaseTreeFeatureConfig configIn) {
    	
    	int height = rand.nextInt(this.maxSize - this.minSize) + this.minSize;
    	    	
		Midgard.LOGGER.info("PLACE IN Midgard Basic");

    	return false ; 
    	
    	//return super.place(generationReader, rand, positionIn, p_225557_4_, p_225557_5_, boundingBoxIn, configIn);
    }
    

}
