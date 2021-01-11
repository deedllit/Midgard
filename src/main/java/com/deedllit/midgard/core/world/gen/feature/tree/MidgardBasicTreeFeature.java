package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.util.helpers.RandomHelper;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardBasicTreeFeature extends MidgardAbstractTreeFeature {


	public static class Builder extends InnerBuilder<Builder, MidgardBasicTreeFeature> {
        @Override
        public MidgardBasicTreeFeature create() {
            return new MidgardBasicTreeFeature(this.placeOn, this.replace, this.log, this.leaves, this.alternativeLeaves, this.vine, this.trunkFruit, this.minSize, this.maxSize, this.minSpawnHeight, this.maxSpawnHeight);
        }
    }

    protected static abstract class InnerBuilder<T extends BuilderBase, F extends MidgardBasicTreeFeature> extends BuilderBase<T, F>{
        public InnerBuilder() {
            this.placeOn = (world, pos) ->
            {
                return world.getBlockState(pos).canProvidePower();
            };
            
            this.replace = (world, pos) -> {
            	return world.getBlockState(pos).canBeReplacedByLeaves(world, pos) ; 
            };
            
            
        	this.minSize = 4 ;         	
        	this.maxSize = 7 ; 
			this.minSpawnHeight = 0 ;
			this.maxSpawnHeight = 1000 ; 
  
        	
        }
    }
    
    public MidgardBasicTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine, BlockState trunkFruit,
			int minSize, int maxSize, int minSpawnHeight, int maxSpawnHeight) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		
	}
    
    @Override
    protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world, Random rand,
    		BlockPos positionIn, MutableBoundingBox boundingBoxIn) {

		Midgard.LOGGER.info("MidgardBasicTreeFeature - placeTree");
    	
		int height = RandomHelper.getNextIntBetween(rand, this.minSize, this.maxSize) ; 

		return false ; 
		
    }

    
}
