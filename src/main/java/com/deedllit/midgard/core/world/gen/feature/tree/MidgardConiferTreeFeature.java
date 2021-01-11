package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.util.helpers.RandomHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardConiferTreeFeature extends MidgardAbstractTreeFeature {

	public static class Builder extends BuilderBase<Builder, MidgardConiferTreeFeature> {

		protected int trunkSize = 1;
		protected boolean increaseTrunk = false;

		public Builder() {
			this.minSize = 8;
			this.maxSize = 12;
			this.log = Blocks.SPRUCE_LOG.getDefaultState();
			this.leaves = Blocks.SPRUCE_LEAVES.getDefaultState();
			this.vine = Blocks.VINE.getDefaultState();
			this.trunkSize = 1;
			this.increaseTrunk = false ; 
			this.minSpawnHeight = 0 ;
			this.maxSpawnHeight = 1000 ; 
		}
		
		@Override
		public MidgardConiferTreeFeature create() {
			return new MidgardConiferTreeFeature(placeOn, replace, log, leaves, vine, alternativeLeaves, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight, trunkSize, increaseTrunk);
		}

	}

	private int trunkSize = 1;
	private boolean increaseTrunk = false;

	public MidgardConiferTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine,
			BlockState trunkFruit, int minSize, int maxSize, int minSpawnHeight, int maxSpawnHeight, int trunkSize, boolean increaseTrunk) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		
		this.increaseTrunk = increaseTrunk ; 
		this.trunkSize = trunkSize;
	}
		
	
	@Override
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {

		Midgard.LOGGER.info("MidgardTaigaTreeFeature - placeTree");
		int height = RandomHelper.getNextIntBetween(rand, this.minSize, this.maxSize) ; 		
		int baseHeight  = RandomHelper.getNextIntBetween(rand, height / 5,  height / 3) ; 
		int leavesHeight = height - baseHeight;
		if (leavesHeight < 1) {
			return false;
		}

		//Move to ground and check for placement
		BlockPos posStart = this.moveToGround(world, positionIn);
        if (!this.placeOn.matches(world, posStart)) {
            return false;
        }
        
		BlockPos pos ; 
		pos = posStart;
		
		for (int y = 0; y < height - 1; y++) {
			
			
			int trunkStart = 0 ; 
			int trunkEnd = 0 ;
			
			if(increaseTrunk) {
	            int trunkWidth = (this.trunkSize * (height - y) / height) + 1;
	            trunkStart = MathHelper.ceil(0.25D - trunkWidth / 2.0D);
	            trunkEnd = MathHelper.floor(0.25D + trunkWidth / 2.0D);				
			} 
								      
            trunkStart = 0 ; 
            trunkEnd = 0 ; 
            
			for (int x = trunkStart ; x <= trunkEnd ; x++) {
				for (int z = trunkStart; z <= trunkEnd; z++) {					
					this.placeLog(world, pos.add(x,y,z), changedLogs, boundingBoxIn) ;								
				}
			}
		}
		
		
		//top of the tree to put leaves
		pos = posStart.up(height);  
		this.placeLeaves(world, pos, changedLeaves, boundingBoxIn);
		pos.down();
		
		for (int i = 0; i < leavesHeight; i++) {
			
			
			int trunkStart = 0 ; 
			int trunkEnd = 0 ;
			
			if(increaseTrunk) {
	            int trunkWidth = (this.trunkSize * i / height) + 1;
	            trunkStart = MathHelper.ceil(0.25D - trunkWidth / 2.0D);
	            trunkEnd = MathHelper.floor(0.25D + trunkWidth / 2.0D);				
			} 
			            
            int radius = Math.min(Math.min((i + 2) / 3, 3 + (leavesHeight - i)), 6);
            if (i == leavesHeight - 1) {
                radius = 1;
            }     
            
            
            if (radius == 0) {
                this.placeLeaves(world, pos, changedLeaves, boundingBoxIn);
            } else if (radius < 4) {
            	if (i % 2 == 0) {
                	this.generateLeaves(world, rand, pos, radius, trunkStart, trunkEnd, changedLeaves, boundingBoxIn);            		
            	} else {
                	this.generateLeaves(world, rand, pos, radius / 2, trunkStart, trunkEnd, changedLeaves, boundingBoxIn);
            	}
            		 
            } else {
            }
        
            pos = pos.down() ; 
            
		}
				
		return true ; 

				
	}



	private void generateLeaves(IWorld world, Random rand, BlockPos pos, int radius, int trunkStart, int trunkEnd,
			Set<BlockPos> changedLeaves, MutableBoundingBox boundingBoxIn) {

		int start = trunkStart - radius;
        int end = trunkEnd + radius;
		
        for (int x = start; x <= end; x++) {
        	for (int z = start; z <= end; z++) {
        		if ((radius > 0 ) && (x == start || x == end) && (z == start || z == end)) {
        			continue;
        		}
        		
        		int awayFromTrunk = (x < 0 ? trunkStart - x : x - trunkEnd) + (z < 0 ? trunkStart - z : z - trunkEnd);
        		
                if (awayFromTrunk <= 2) {
                    this.placeLeaves(world, pos.add(x, 0, z), changedLeaves, boundingBoxIn);
                }
        	}
        }
        
	}
	
	
}
