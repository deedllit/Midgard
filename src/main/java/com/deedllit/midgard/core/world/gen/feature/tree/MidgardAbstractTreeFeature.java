package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.util.helpers.BlockHelper;
import com.deedllit.midgard.util.helpers.RandomHelper;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.IProperty;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;


/*
 * Inspired by BiomeOPlenty : 
 * https://github.com/Glitchfiend/BiomesOPlenty/blob/fab38c4c3527dffebd8d67cf49a5e809280ffb94/src/main/java/biomesoplenty/common/world/gen/feature/tree/BasicTreeFeature.java
 */

public abstract class MidgardAbstractTreeFeature extends AbstractTreeFeature<BaseTreeFeatureConfig> {
	
	protected static abstract class BuilderBase<T extends BuilderBase, F extends MidgardAbstractTreeFeature> {
		protected IBlockPosQuery placeOn ; 
		protected IBlockPosQuery replace ;
		
		protected BlockState log ; 
		protected BlockState leaves ; 
		protected BlockState alternativeLeaves ; 
		protected BlockState vine ; 
		protected BlockState trunkFruit ; 
		
		protected int minSize ;
		protected int maxSize ; 
		
		public BuilderBase() {
			
			this.placeOn = (world, pos) -> world.getBlockState(pos).canSustainPlant(world, pos, Direction.UP, (SaplingBlock)Blocks.OAK_SAPLING);
            this.replace = (world, pos) -> world.getBlockState(pos).canBeReplacedByLeaves(world, pos) 
            		|| world.getBlockState(pos).getBlock().equals(BlockTags.SAPLINGS) 
            		|| world.getBlockState(pos).getBlock() == Blocks.VINE 
            		|| world.getBlockState(pos).getBlock() instanceof BushBlock;
			
			this.log = Blocks.OAK_LOG.getDefaultState();
			this.leaves = Blocks.OAK_LEAVES.getDefaultState();
			this.alternativeLeaves = Blocks.AIR.getDefaultState() ; 
			this.vine = Blocks.AIR.getDefaultState();
			this.trunkFruit = Blocks.AIR.getDefaultState();
			
			this.minSize = 4 ; 
			this.maxSize = 7 ; 			
		}
		
		public T placeOn(IBlockPosQuery a) {this.placeOn = a; return (T)this;}
		public T replace(IBlockPosQuery a) {this.replace = a; return (T)this;}
		
		public T log(BlockState log) {this.log = log; return (T)this; }
        public T leaves(BlockState leaves) {this.leaves = leaves; return (T)this; }
        public T alternativeLeaves(BlockState alternativeLeaves) {this.alternativeLeaves = alternativeLeaves; return (T)this; }
        public T vine(BlockState vine) {this.vine = vine; return (T)this; }		
        public T trunkFruit(BlockState trunkFruit) {this.trunkFruit = trunkFruit; return (T)this; }		
        
        public T minSize(int min) {this.minSize = min; return (T)this;}
        public T maxSize(int max) {this.maxSize = max; return (T)this;}
        
        abstract F create();
	}
	
	protected IBlockPosQuery placeOn ;
	protected IBlockPosQuery replace ;
	
	protected BlockState log ; 
	protected BlockState leaves ; 
	protected BlockState alternativeLeaves ; 
	protected BlockState vine ; 
	protected BlockState trunkFruit ; 

	protected int minSize ;
	protected int maxSize ; 

	protected IProperty logAxis ; 
		
		
	protected  MidgardAbstractTreeFeature(IBlockPosQuery placeOn, IBlockPosQuery replace, BlockState log, BlockState leaves, BlockState alternativeLeaves, BlockState vine, BlockState trunkFruit, int minSize, int maxSize ) {
		super(BaseTreeFeatureConfig::deserialize);
		
		this.placeOn = placeOn ; 
		this.replace = replace ; 
		
		
		this.log = log ; 
		this.leaves = leaves ; 
		this.alternativeLeaves = alternativeLeaves ; 
		this.vine = vine ; 
		this.trunkFruit = trunkFruit ; 
		
		this.minSize = minSize ;
		this.maxSize = maxSize ; 
		
		this.logAxis = BlockHelper.getAxisProperty(this.log) ; 
			
	}
	
	
	protected void generateTrunk(IWorld worldIn, BlockPos pos, MutableBoundingBox boundingBox, Set<BlockPos> changedLogs, int height) {
		
		Midgard.LOGGER.info("MidgardAbstractTreeFeature - generateTrunk random : " + height);


		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

		int x = pos.getX() ;
		int y = pos.getY() ; 
		int z = pos.getZ() ; 
		
		
        blockpos$mutableblockpos.setPos( pos );            
        for(int i = 0 ; i < height ; i++ ) {
        	this.placeBlock(worldIn, blockpos$mutableblockpos.setPos(x, y + i, z), this.log, changedLogs, boundingBox) ;         	
        }
        
		
	}
	
	@Override
	protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn,
			Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, MutableBoundingBox boundingBoxIn,
			BaseTreeFeatureConfig configIn) {
		return placeTree(changedLogs, changedLeaves, (IWorld)generationReader, rand, positionIn, boundingBoxIn ) ;
	}




	/*
	 * NEED TO BE OVERRIDE 
	 */
	protected boolean placeTree(Set<BlockPos> changedLogs, Set<BlockPos> changedLeaves, IWorld world,
			Random rand, BlockPos positionIn, MutableBoundingBox boundingBoxIn) {
		
		Midgard.LOGGER.info("MidgardAbstractTreeFeature - placeTree - must be override");

		return false;
	}

	
	public boolean placeLeaves(IWorld world, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBoxIn) {		
		if(world.getBlockState(pos).canBeReplacedByLeaves(world, pos)) {
			this.setBlockState(world, pos, this.leaves);
			this.placeBlock(world, pos, this.leaves, changedBlocks, boundingBoxIn) ; 
			return true ; 
		}
		
		return false ; 
		
	}
	
	public Direction getRandomDirection(Random rand) {
		return Direction.random(rand) ;  
	}
	
	public BlockPos moveToGround(IWorld world, BlockPos pos) {
		
		while (pos.getY() > 1 && world.isAirBlock(pos) || world.getBlockState(pos).getMaterial() == Material.LEAVES) {
			pos = pos.down();
		}
		
		return pos ; 
		
	}
	
	public boolean placeLog(IWorld world, BlockPos pos, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBoxIn) {
		return this.placeLog(world, pos, null, changedBlocks, boundingBoxIn);
	}
	
    public boolean placeLog(IWorld world, BlockPos pos, Direction.Axis axis, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBoxIn) {

		BlockState directedLog = (this.logAxis != null && axis != null) ? this.log.with(this.logAxis, axis) : this.log;		
		//BlockState directedLog = (this.logAxis != null && axis != null) ? this.log : this.log;

		if (this.replace.matches(world, pos)) {
            this.placeBlock(world, pos, directedLog, changedBlocks, boundingBoxIn);
            return true;
        }
        return false;
    }
		
     
    public boolean placeBlock(IWorld world, BlockPos pos, BlockState state, Set<BlockPos> changedBlocks, MutableBoundingBox boundingBoxIn) {		
		if (!isAirOrLeaves(world, pos) && !isVine(world, pos) && !isWater(world, pos)) {
            return false;
        } else {
            this.setBlockState(world, pos, state, boundingBoxIn);
            changedBlocks.add(pos.toImmutable());
            return true;
        }
	}

	

}
