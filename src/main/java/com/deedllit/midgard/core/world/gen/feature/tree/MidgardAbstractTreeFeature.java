package com.deedllit.midgard.core.world.gen.feature.tree;

import java.util.Random;
import java.util.Set;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.block.IBlockPosQuery;
import com.deedllit.midgard.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
		protected BlockState leaves ; 
		protected BlockState log ; 
		protected BlockState vine ; 
		protected BlockState trunkFruit ; 

		
		protected int minSize ;
		protected int maxSize ; 

		public BuilderBase() {
			this.log = Blocks.OAK_LOG.getDefaultState();
			this.leaves = Blocks.OAK_LEAVES.getDefaultState();
			this.vine = Blocks.AIR.getDefaultState();
			this.trunkFruit = Blocks.AIR.getDefaultState();
		}
		
		
		public T log(BlockState log) {this.log = log; return (T)this; }
        public T leaves(BlockState leaves) {this.leaves = leaves; return (T)this; }
        public T vine(BlockState vine) {this.vine = vine; return (T)this; }		
        abstract F create();
	}
	
	protected IBlockPosQuery placeOn ;
	protected BlockState leaves ; 
	protected BlockState log ; 
	protected BlockState vine ; 
	protected BlockState trunkFruit ; 

	protected int minSize ;
	protected int maxSize ; 
		
	protected  MidgardAbstractTreeFeature(IBlockPosQuery placeOn, BlockState leaves, BlockState log, BlockState vine, BlockState trunkFruit, int minSize, int maxSize ) {
		super(BaseTreeFeatureConfig::deserialize);
		
		this.placeOn = placeOn ; 
		this.leaves = leaves ; 
		this.log = log ; 
		this.vine = vine ; 
		this.trunkFruit = trunkFruit ; 
		
		this.minSize = minSize ;
		this.maxSize = maxSize ; 
		
		
	}

	@Override
		protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn,
				Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn,
				BaseTreeFeatureConfig configIn) {
			
		Midgard.LOGGER.info("PLACE IN Midgard Abstract");
		
		return false;
		}
	


}
