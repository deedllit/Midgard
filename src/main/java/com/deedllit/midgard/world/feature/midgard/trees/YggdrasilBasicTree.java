package com.deedllit.midgard.world.feature.midgard.trees;


import net.minecraft.block.BlockState;

public class YggdrasilBasicTree extends YggdrasilTreeBase {

    public YggdrasilBasicTree(BlockState log, BlockState leaves, BlockState fruit, int minHeight, int maxHeight) {
		super(log, leaves, fruit, minHeight, maxHeight);
	}


	public static class Builder extends InnerBuilder<YggdrasilBasicTree.Builder, YggdrasilBasicTree>
    {    	
    		
        @Override
        public YggdrasilBasicTree create() {
        	return new YggdrasilBasicTree(this.log, this.leaves, this.fruit, this.minHeight, this.maxHeight) ; 
        }
        
      	
    }

	 protected static abstract class InnerBuilder<T extends BuilderBase, F extends YggdrasilTreeBase> extends BuilderBase<T, F> {
		 
		 
		 
	 }
	 
	
}
