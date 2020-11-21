package com.deedllit.midgard.util.holder;

import java.util.ArrayList;

import net.minecraft.block.BlockState;

public class PreBuildBlockStateHolder {

	private ArrayList<BlockStatePosHolder> blocks ;  
	
	public PreBuildBlockStateHolder() {
		blocks = new ArrayList<BlockStatePosHolder>() ;
	}
	
	public void add(long x, long y, long z, BlockState blockState) {
		blocks.add( new BlockStatePosHolder(x,y,z,blockState)) ; 
	}
	
	public void add(BlockStatePosHolder blockStatePosHolder) {
		blocks.add(blockStatePosHolder)  ; 
	}
	
	public ArrayList<BlockStatePosHolder> getList() {
		return blocks ; 
	}
	
}
