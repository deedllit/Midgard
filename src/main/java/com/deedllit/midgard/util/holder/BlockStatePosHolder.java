package com.deedllit.midgard.util.holder;

import net.minecraft.block.BlockState;

public class BlockStatePosHolder {

	private long x ;
	private long y ;
	private long z ; 
	private BlockState blockState ; 
	
	public BlockStatePosHolder(long x, long y, long z, BlockState blockState ) {
		this.x = x ;
		this.y = y ;
		this.z = z ;
		this.blockState = blockState ; 
	}
	
	
	public long getX() {
		return x ; 
	}
	
	public long getY() {
		return y ; 
	}

	public long getZ() {
		return z ; 
	}
	
	public BlockState getBlockState() {
		return blockState ; 
	}
	
}
