package com.deedllit.midgard.world.feature.midgard.trees;

import java.util.Random;
import java.util.Set;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.IWorldGenerationReader;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.BaseTreeFeatureConfig;



public class YggdrasilTreeBase extends AbstractTreeFeature<BaseTreeFeatureConfig> {

	protected static abstract class BuilderBase<T extends BuilderBase<?, ?>, F extends YggdrasilTreeBase> {	 
		
        protected BlockState log;
        protected BlockState leaves;
        protected BlockState fruit;
        protected int minHeight;
        protected int maxHeight;
        
        public BuilderBase() {
            this.log = Blocks.OAK_LOG.getDefaultState();
        	this.leaves = Blocks.OAK_LOG.getDefaultState();
            this.fruit = Blocks.AIR.getDefaultState();
        }
        
        @SuppressWarnings("unchecked")
		public T log(BlockState log) {this.log = log; return (T)this;}
        @SuppressWarnings("unchecked")
		public T leaves(BlockState leaves) {this.leaves = leaves; return (T)this;}
        @SuppressWarnings("unchecked")
		public T trunkFruit(BlockState fruit) {this.fruit = fruit; return (T)this;}
        @SuppressWarnings("unchecked")
		public T minHeight(int height) {this.minHeight = height; return (T)this;}
        @SuppressWarnings("unchecked")
		public T maxHeight(int height) {this.maxHeight = height; return (T)this;}
		
        abstract F create();
	}
	
    protected final BlockState log;
    protected final BlockState leaves;
    protected final BlockState fruit;
    protected final int minHeight;
    protected final int maxHeight;
    	
	public YggdrasilTreeBase(BlockState log, 
			BlockState leaves, 
			BlockState fruit, 
			int minHeight, int maxHeight) {
		
		super(BaseTreeFeatureConfig::deserialize);
		
		this.log = log ;
		this.leaves = leaves ;
        this.fruit = fruit;
		this.minHeight = minHeight ; 
		this.maxHeight = maxHeight ; 
	}
	


	@Override
	protected boolean place(IWorldGenerationReader generationReader, Random rand, BlockPos positionIn,
			Set<BlockPos> p_225557_4_, Set<BlockPos> p_225557_5_, MutableBoundingBox boundingBoxIn,
			BaseTreeFeatureConfig configIn) {
		return false;
	}

}
