package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.util.helpers.RandomHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardPalmTreeFeature extends MidgardAbstractTreeFeature {

	public static class Builder extends BuilderBase<Builder, MidgardPalmTreeFeature> {

		protected int trunkSize = 1;
		protected boolean increaseTrunk = false;

		public Builder() {
			this.minSize = 8;
			this.maxSize = 13;
			this.log = BlockInit.PALM_LOG.get().getDefaultState();
			this.leaves = BlockInit.PALM_LEAVES.get().getDefaultState();
			this.vine = Blocks.VINE.getDefaultState();
			
			this.placeOn = (world, pos) -> {
				
				Block cur = world.getBlockState(pos).getBlock();
				return(world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING) || 
						(BlockTags.SAND.contains(cur))) ; 
			} ; 
			
		}

				
		@Override
		public MidgardPalmTreeFeature create() {
			return new MidgardPalmTreeFeature(placeOn, replace, log, leaves, vine, alternativeLeaves, trunkFruit, minSize, maxSize, trunkSize, increaseTrunk);
		}

	}

	private int trunkSize = 1;
	private boolean increaseTrunk = false;

	public MidgardPalmTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine,
			BlockState trunkFruit, int minSize, int maxSize, int trunkSize, boolean increaseTrunk) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize);
		
		this.increaseTrunk = increaseTrunk ; 
		this.trunkSize = trunkSize;
	}
		
	@Override
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {

		Midgard.LOGGER.info("MidgardPalmTreeFeature - placeTree");

		//Move to ground and check for placement
		BlockPos posStart = this.moveToGround(world, positionIn);
        if (!this.placeOn.matches(world, posStart)) {
            return false;
        }
        
		
		int height = RandomHelper.getNextIntBetween(rand, this.minSize, this.maxSize) ; 		
		
		if (height < 8) {
			return false;
		}
		 
		int leavesRadius = 2 ;
		
		if(height < 10) {
			leavesRadius = 1 ; 
		}
		
		int heightMinusTop = height - 2 ;
		
		boolean isCurved = true ; 
		Direction dir = this.getRandomDirection(rand)  ;
		
		if(dir == Direction.DOWN || dir == Direction.UP) {
			isCurved = false ; 
		} else {
			//More chance to curve to east
			if (rand.nextInt(10) == 0) {
				dir = Direction.EAST ; 
			}		
		}
		
        double curveMultiplier = 1.30D + (rand.nextInt(5) - 2) * 0.05D ;
        double secondCurveMultiplier = 1.1D + (rand.nextInt(5) - 2) * 0.05D ;
		double curveOffset = rand.nextInt(36) / 100D; ;
		
		BlockPos offsetPos = posStart ; 
		BlockPos lastPos = posStart ; 
		
		for(int step = 0; step <= heightMinusTop; step++) {
			
			if(isCurved) {
				lastPos = offsetPos.up(step).offset(dir, (int) Math.sqrt(curveOffset)) ; 
				this.placeLog(world, lastPos, changedLogs, boundingBoxIn);
			
				curveOffset *= curveMultiplier;
				
				//Chance to curve faster
				if (rand.nextInt(25) == 0) {
					curveOffset *= secondCurveMultiplier;					
				}
				
			}  else {
				lastPos = offsetPos.up(step)  ; 
				this.placeLog(world, lastPos, changedLogs, boundingBoxIn);				
			}
					
			
		}
			 
		
		
		this.generateLeaves(world, rand, lastPos.up(), changedLeaves, boundingBoxIn, leavesRadius)  ; 
		
		return true ; 
				
	}
	


	private void generateLeaves(IWorld world, Random rand, BlockPos pos, Set<BlockPos> changedLeaves, MutableBoundingBox boundingBoxIn, int leavesRadius) {
		
		this.placeLeaves(world, pos, changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.up(), changedLeaves, boundingBoxIn) ; 
		
		this.placeLeaves(world, pos.east(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.north(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.south(), changedLeaves, boundingBoxIn) ; 

		this.placeLeaves(world, pos.east().north(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.east().south(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west().north(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west().south(), changedLeaves, boundingBoxIn) ; 
		
		this.placeLeaves(world, pos.east(2), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west(2), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.north(2), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.south(2), changedLeaves, boundingBoxIn) ; 	

		this.placeLeaves(world, pos.east(2).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west(2).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.north(2).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.south(2).down(), changedLeaves, boundingBoxIn) ; 

		this.placeLeaves(world, pos.east(3).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.west(3).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.north(3).down(), changedLeaves, boundingBoxIn) ; 
		this.placeLeaves(world, pos.south(3).down(), changedLeaves, boundingBoxIn) ; 

		if(leavesRadius == 2) {
			this.placeLeaves(world, pos.east(3).down(2), changedLeaves, boundingBoxIn) ; 			
			this.placeLeaves(world, pos.west(3).down(2), changedLeaves, boundingBoxIn) ; 			
			this.placeLeaves(world, pos.north(3).down(2), changedLeaves, boundingBoxIn) ; 			
			this.placeLeaves(world, pos.south(3).down(2), changedLeaves, boundingBoxIn) ; 					
		}
	
		

	
	}
	
	
}
