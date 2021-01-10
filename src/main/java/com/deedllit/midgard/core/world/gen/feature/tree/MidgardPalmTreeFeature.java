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
import net.minecraft.block.CocoaBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardPalmTreeFeature extends MidgardAbstractTreeFeature {

	public static class Builder extends BuilderBase<Builder, MidgardPalmTreeFeature> {
		
		protected double baseCarving ;
		protected double baseCarvingExtra ;
		protected boolean extraCavring ;
		
		public Builder() {
			this.minSize = 8;
			this.maxSize = 13;
			this.log = BlockInit.PALM_LOG.get().getDefaultState();
			this.leaves = BlockInit.PALM_LEAVES.get().getDefaultState();
			this.minSpawnHeight = 0 ;
			this.maxSpawnHeight = 70 ; 
			
			this.placeOn = (world, pos) -> {
				
				Block cur = world.getBlockState(pos).getBlock();
				return(world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING) || 
						(BlockTags.SAND.contains(cur))) ; 
			} ; 
			
			this.extraCavring = true ; 
			this.baseCarving = 1.3D ;
			this.baseCarvingExtra = 1.1D ;
		}

				
		@Override
		public MidgardPalmTreeFeature create() {
			return new MidgardPalmTreeFeature(placeOn, replace, log, leaves, vine, alternativeLeaves, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight, baseCarving, baseCarvingExtra, extraCavring );
		}
		
		
		public Builder baseCarving(double baseCarving) {this.baseCarving = baseCarving; return this;}
		public Builder baseCarvingExtra(double baseCarvingExtra) {this.baseCarvingExtra = baseCarvingExtra; return this;}
		public Builder extraCavring(boolean extraCavring) {this.extraCavring = extraCavring; return this;}

	}

	protected double baseCarving ;
	protected double baseCarvingExtra ;
	protected boolean extraCavring ; 
	
	public MidgardPalmTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine,
			BlockState trunkFruit, int minSize, int maxSize, int minSpawnHeight, int maxSpawnHeight, double baseCarving, double baseCarvingExtra, boolean extraCavring) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		
		this.baseCarving = baseCarving ;
		this.baseCarvingExtra = baseCarvingExtra ; 
		this.extraCavring = extraCavring ; 
		//this.trunkFruit = BlockInit.PAPAYA_FRUIT.get().getDefaultState() ; 

	}
		
	@Override
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {
		

		//Move to ground and check for placement
		BlockPos posStart = this.moveToGround(world, positionIn);
        if (!this.placeOn.matches(world, posStart)) {
            return false;
        }
        
        if(isNotAllowedSpawnHeight(posStart)) 
			return false ; 
        
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
		
        double curveMultiplier = this.baseCarving + (rand.nextInt(5) - 2) * 0.05D ;
        double secondCurveMultiplier = this.baseCarvingExtra + (rand.nextInt(5) - 2) * 0.05D ;
		double curveOffset = rand.nextInt(40) / 100D; ;
		
		BlockPos offsetPos = posStart ; 
		BlockPos lastPos = posStart ; 
		
		for(int step = 0; step <= heightMinusTop; step++) {
			
			if(isCurved) {
				lastPos = offsetPos.up(step).offset(dir, (int) Math.sqrt(curveOffset)) ; 
				
				this.placeLog(world, lastPos, changedLogs, boundingBoxIn);				
				
				curveOffset *= curveMultiplier;
				
				//Chance to curve faster
				if (this.extraCavring && rand.nextInt(25) == 0) {
					curveOffset *= secondCurveMultiplier;					
				}
				
			}  else {
				lastPos = offsetPos.up(step)  ; 
				this.placeLog(world, lastPos, changedLogs, boundingBoxIn);				
			}

			
			
			if(this.trunkFruit != Blocks.AIR.getDefaultState() && step == heightMinusTop && rand.nextInt(4) == 0) {
				int r = rand.nextInt(15) + 1 ;
								
				if((r & 1) == 1) {
					this.generateTrunkFruit(world, rand.nextInt(3), lastPos.north(), Direction.SOUTH) ; 					
				}

				if((r & 2) == 2) {
					this.generateTrunkFruit(world, rand.nextInt(3), lastPos.south(), Direction.NORTH) ; 					
				}

				if((r & 4) == 4) {
					this.generateTrunkFruit(world, rand.nextInt(3), lastPos.west(), Direction.EAST) ; 
				}
				
				if((r & 8) == 8) {
					this.generateTrunkFruit(world, rand.nextInt(3), lastPos.east(), Direction.WEST) ; 														
				}
			}
			
		}
			 	
		

		
		
		this.generateLeaves(world, rand, lastPos.up(), changedLeaves, boundingBoxIn, leavesRadius)  ; 
		
		
		return true ; 
				
	}
	
    private void generateTrunkFruit(IWorld worldIn, int age, BlockPos pos, Direction direction)
    {
    	
		
		if(this.trunkFruit != Blocks.AIR.getDefaultState()) {
	    	this.setBlockState(worldIn, pos, this.trunkFruit.with(CocoaBlock.AGE, age).with(CocoaBlock.HORIZONTAL_FACING, direction));			
		}
		

    	
    	
    	
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
