package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.core.world.gen.feature.tree.MidgardAbstractTreeFeature.BuilderBase;
import com.deedllit.midgard.core.world.gen.feature.tree.MidgardConiferTreeFeature.Builder;
import com.deedllit.midgard.util.helpers.RandomHelper;
import com.deedllit.midgard.util.math.MidPointCircle;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;

public class MidgardMangroveTreeFeature extends MidgardAbstractTreeFeature {

	public static class Builder extends BuilderBase<Builder, MidgardMangroveTreeFeature> {

		protected int maxRootLenght = 5;
		
		public Builder() {
			this.minSize = 8;
			this.maxSize = 12;
			this.log = Blocks.SPRUCE_LOG.getDefaultState();
			this.leaves = Blocks.SPRUCE_LEAVES.getDefaultState();
			this.vine = Blocks.VINE.getDefaultState();
			this.minSpawnHeight = 0 ;
			this.maxSpawnHeight = 1000 ; 
			
			this.placeOn = (world, pos) -> world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING)
				|| world.getBlockState(pos).getBlock() == Blocks.WATER ;
			
            this.replace = (world, pos) -> world.getBlockState(pos).canBeReplacedByLeaves(world, pos) 
            		|| world.getBlockState(pos).getBlock().equals(BlockTags.SAPLINGS) 
            		|| world.getBlockState(pos).getBlock() == Blocks.VINE 
            		|| world.getBlockState(pos).getBlock() == Blocks.WATER
            		|| world.getBlockState(pos).getBlock() instanceof BushBlock;
		}
		
		@Override
		public MidgardMangroveTreeFeature create() {
			return new MidgardMangroveTreeFeature(placeOn, replace, log, leaves, vine, alternativeLeaves, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight, maxRootLenght);
		}

	}
	
	private int maxRootLenght ; 
	
	public MidgardMangroveTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine,
			BlockState trunkFruit, int minSize, int maxSize, int minSpawnHeight, int maxSpawnHeight, int maxRootLenght) {
		super(placeOn, replace, log, leaves, alternativeLeaves, vine, trunkFruit, minSize, maxSize, minSpawnHeight, maxSpawnHeight);
		
		this.maxRootLenght = maxRootLenght ; 
		
	}
	
	@Override
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {
		
		Midgard.LOGGER.info("MidgardMangroveTreeFeature - placeTree");
		int height = RandomHelper.getNextIntBetween(rand, this.minSize, this.maxSize) ; 		
		int leaveSize = rand.nextInt(1) + 2 ; 
		int maxRootSize = 5 ; 
		int deep = 99 ; 
		
		if(height < 6) 
			return false ; 
		
		//Move to ground and check for placement
		BlockPos posStart = this.moveToGround(world, positionIn);
        if (!this.placeOn.matches(world, posStart)) {
            return false;
        }
        

        //Avoid too long root tree
        for(int i = 0 ; i<maxRootSize + 1 ; i++) {
        	if(world.getBlockState(posStart.down(i)).getBlock() != Blocks.WATER) {
        		break;
        	}
        	deep  = i ; 
        }
        
        if(deep > maxRootSize)
        	return false ; 
        	        
		int aboveFloor = 0 ;
		
		if(maxRootSize-deep > 0)
			aboveFloor = rand.nextInt(maxRootSize-deep) + 1; 
        
        
		aboveFloor = Math.max(3, aboveFloor) ; 
		
        posStart = posStart.up(aboveFloor) ;

        
        //Place trunk
        for(int i = 0 ; i < height - leaveSize ; i++) {
            this.placeLog(world, posStart.up(i), changedLogs, boundingBoxIn);		        	
        }
        
        
        int h = 1 ; 

        int r = rand.nextInt(3) ;

        int dE = 1 ;
        int incE = 0 ;
        int dW = 1 ; 
        int incW = 0 ;
        int dS = 1 ;
        int incS = 0  ;
        int dN = 1 ; 
        int incN = 0  ;
        
        boolean growN = true ; 
        boolean growS = true ; 
        boolean growE = true ;
        boolean growW = true ; 
        
        r = 0 ;
        
        //Build root
        //for(int i = 0 ; i < maxRootLenght ; i++) {
        do {
        
        	if(growE && (world.getBlockState(posStart.down(h).east(dE)).getBlock() == Blocks.WATER || world.getBlockState(posStart.down(h).east(dE)).getBlock() == Blocks.AIR)) {
        		this.placeLog(world, posStart.down(h).east(dE), changedLogs, boundingBoxIn);		        		
        	} else {
        		growE = false ; 
        	}
            
        	if(growW && (world.getBlockState(posStart.down(h).west(dW)).getBlock() == Blocks.WATER || world.getBlockState(posStart.down(h).west(dW)).getBlock() == Blocks.AIR)) {
        		this.placeLog(world, posStart.down(h).west(dW), changedLogs, boundingBoxIn);		        	        		
        	} else {
        		growW = false ; 
        	}
        	
        	if(growN && (world.getBlockState(posStart.down(h).north(dN)).getBlock() == Blocks.WATER || world.getBlockState(posStart.down(h).north(dN)).getBlock() == Blocks.AIR)) {
        		this.placeLog(world, posStart.down(h).north(dN), changedLogs, boundingBoxIn);		        	        		
        	} else {
        		growN = false ; 
        	}
        	
        	if(growS && (world.getBlockState(posStart.down(h).south(dS)).getBlock() == Blocks.WATER || world.getBlockState(posStart.down(h).south(dS)).getBlock() == Blocks.AIR)) {
        		this.placeLog(world, posStart.down(h).south(dS), changedLogs, boundingBoxIn);		        	            	        		
        	} else {
        		growS = false ; 
        	}

            

            
            if(r == 0) {
                //random shape
            	
            	if(moveASide(rand, incE)) {
               		dE++ ; 
            		incE = 0 ;
            	} else {
            		incE++ ;
            	}
            	if(moveASide(rand, incW)) {
               		dW++ ; 
            		incW = 0 ;
            	} else {
            		incW++ ;
            	}
            	if(moveASide(rand, incN)) {
               		dN++ ; 
            		incN = 0 ;
            	} else {
            		incN++ ;
            	}
            	if(moveASide(rand, incS)) {
               		dS++ ; 
            		incS = 0 ;
            	} else {
            		incS++ ;
            	}


            } else {
            	//mirror shape
            	
            	if(moveASide(rand, incE)) {
               		incE = 0 ;

               		dE++ ; 
                    dW++ ; 
                    dS++ ; 
                    dN++ ; 
            	} else {
            		incE ++ ;
            	}
           	 
            	
            }
            
            h++;
                        
        } while(growN || growS || growE || growW) ;
        
        
        
        //Place leaves
        posStart = posStart.up(height-3) ;

        
        ArrayList<BlockPos> leavesPos3 = new ArrayList<BlockPos>() ;
        ArrayList<BlockPos> leavesPos2 = new ArrayList<BlockPos>() ;
        ArrayList<BlockPos> leavesPos1 = new ArrayList<BlockPos>() ;
        ArrayList<BlockPos> leavesPos0 = new ArrayList<BlockPos>() ;
        
        MidPointCircle.DrawCircle( posStart, leavesPos3, 3) ; 
        MidPointCircle.DrawCircle( posStart, leavesPos2, 2) ; 
        MidPointCircle.DrawCircle( posStart, leavesPos1, 1) ; 

        
        leavesPos0.add(posStart.east()) ; 
        leavesPos0.add(posStart.west()) ; 
        leavesPos0.add(posStart.north()) ; 
        leavesPos0.add(posStart.south()) ; 
        leavesPos0.add(posStart) ; 

        
        leavesPos1.add(posStart) ; 

        leavesPos2.addAll(leavesPos1) ; 

        leavesPos3.addAll(leavesPos2) ; 
        
        

        int rTop = rand.nextInt(3) ; 
        int rBot = rand.nextInt(3) ; 
        
        for(BlockPos p : leavesPos3) {
          this.placeLeaves(world, p, changedLeaves, boundingBoxIn);		        	        	
          if(rTop == 0)
        	  this.placeLeaves(world, p.add(0, 1, 0), changedLeaves, boundingBoxIn);		        	        	
       	}
        
        
        for(BlockPos p : leavesPos2) {
            this.placeLeaves(world, p.add(0, -1, 0), changedLeaves, boundingBoxIn);		        	        	
            if(rTop != 0)
          	  this.placeLeaves(world, p.add(0, 1, 0), changedLeaves, boundingBoxIn);		        	        	
         	}
        
        
        
        for(BlockPos p : leavesPos1) {
            this.placeLeaves(world, p.add(0, 2, 0), changedLeaves, boundingBoxIn);		        	        	
            if(rBot == 0)
            		this.placeLeaves(world, p.add(0, -2, 0), changedLeaves, boundingBoxIn);		        	        
            	
         	}

        
        if(rBot != 0 || height > 6) {
            for(BlockPos p : leavesPos0) {
            	
            	if(rBot != 0)
                	this.placeLeaves(world, p.add(0, -2, 0), changedLeaves, boundingBoxIn);		        	        	
            	
                if(height > 6)
                	this.placeLeaves(world, p.add(0, -3, 0), changedLeaves, boundingBoxIn);		        	        	

            }        	
        }
        
        return true ; 
	}
	
	
	private boolean moveASide(Random rand, int i) {
		if(rand.nextInt(6-i) == 0 || i == 1 ) {
			return true ; 
		}
		
		return false ; 
	
	}
	
	
}
