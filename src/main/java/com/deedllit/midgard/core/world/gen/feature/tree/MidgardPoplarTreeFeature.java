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
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardPoplarTreeFeature extends MidgardAbstractTreeFeature { 
	
	public static class Builder extends BuilderBase<Builder, MidgardPoplarTreeFeature> {
				
		public Builder() {
			this.minSize = 15;
			this.maxSize = 28;
			this.log = BlockInit.BLACK_POPLAR_LOG.get().getDefaultState();
			this.leaves = BlockInit.PALM_LEAVES.get().getDefaultState();
			this.minSpawnHeight = 0 ;
			this.maxSpawnHeight = 1000 ; 
			
			this.placeOn = (world, pos) -> {
				
				Block cur = world.getBlockState(pos).getBlock();
				return(world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)) ; 
			} ; 
			
		}

				
		@Override
		public MidgardPoplarTreeFeature create() {
			return new MidgardPoplarTreeFeature(placeOn, replace, log, leaves, vine, alternativeLeaves, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		}
		
	}
	
	public MidgardPoplarTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine,
			BlockState trunkFruit, int minSize, int maxSize, int minSpawnHeight, int maxSpawnHeight) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		
	}
	
	@Override
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {
		
		//Move to ground and check for placement
		BlockPos posStart = this.moveToGround(world, positionIn);
        if (!this.placeOn.matches(world, posStart)) {
            return false;
        }
        
		int height = RandomHelper.getNextIntBetween(rand, this.minSize, this.maxSize) ; 		
		
		if (height < 5) {
			return false;
		}
		
		//int bottomHeight = height / (3 + rand.nextInt(2)) ; 
			
		
		int chance = 50 ; 
		
		int bottomHeight = height / 3 ; 
		int leavesHeight = height - bottomHeight ; 
		
		BlockPos offsetPos = posStart ; 

		//Bottom tree, without leaves
        for(int i = 0; i < bottomHeight; i++) {
            this.placeLog(world, offsetPos, changedLogs, boundingBoxIn);
            offsetPos = offsetPos.up();
                        
        }
        
        int lastR = rand.nextInt(15) + 1  ; 
        
        //Top tree, logs and leaves
        for(int i = 0; i < leavesHeight ; i++)  {
        	

        	int newR =  rand.nextInt(16) ;
        	int r =  rand.nextInt(16) | lastR | newR ; 
			lastR = newR ; 
            
        	if (leavesHeight - i > 4) { 	
        		
        		/*
                if(rand.nextInt(chance) == 0) {
                	chance *= 2 ; 
                	offsetPos = offsetPos.east();
                	this.placeLeavesLayer(world, offsetPos, 2, r, changedLeaves, boundingBoxIn) ;
                } else {
                	chance += 1 ; 
                	this.placeLeavesLayer(world, offsetPos, 1, r, changedLeaves, boundingBoxIn) ;                	
                }
        		*/
            	this.placeLeavesLayer(world, offsetPos, 1, r, changedLeaves, boundingBoxIn) ;                	        		
            	this.placeLog(world, offsetPos, changedLogs, boundingBoxIn);
            	
        	}
    		else if (leavesHeight - i > 2) { 	        		
            	this.placeLog(world, offsetPos, changedLogs, boundingBoxIn);
            	this.placeLeavesLayer(world, offsetPos, 2, r, changedLeaves, boundingBoxIn) ;
    		}
            else {
        		this.placeLeaves(world, offsetPos, changedLeaves, boundingBoxIn);            	
            }
            
            
            offsetPos = offsetPos.up();
        }        
        

		return true ; 
	}

   public void placeLeavesLayer(IWorld world, BlockPos pos, int size, int r, Set<BlockPos> changedLeaves, MutableBoundingBox boundingBoxIn) {
	     
	   if(size == 1) {
			if((r & 1) == 1) {
	            this.placeLeaves(world, pos.north(), changedLeaves, boundingBoxIn);
			}
	
			if((r & 2) == 2) {
	            this.placeLeaves(world, pos.south(), changedLeaves, boundingBoxIn);
			}
	
			if((r & 4) == 4) {
	            this.placeLeaves(world, pos.east(), changedLeaves, boundingBoxIn);
			}
			
			if((r & 8) == 8) {
	            this.placeLeaves(world, pos.west(), changedLeaves, boundingBoxIn);
			}
	   } else {
			if((r & 1) == 1) {
                this.placeLeaves(world, pos.north(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.north(2), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.north().east(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.north().west(), changedLeaves, boundingBoxIn);
			}

			if((r & 2) == 2) {
                this.placeLeaves(world, pos.south(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.south(2), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.south().east(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.south().west(), changedLeaves, boundingBoxIn);
			}

			if((r & 4) == 4) {
                this.placeLeaves(world, pos.east(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.east(2), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.east().north(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.east().south(), changedLeaves, boundingBoxIn);
			}
			
			if((r & 8) == 8) {
                this.placeLeaves(world, pos.west(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.west(2), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.west().north(), changedLeaves, boundingBoxIn);
                this.placeLeaves(world, pos.west().south(), changedLeaves, boundingBoxIn);
			}
	   }
	   
   }
	
}
