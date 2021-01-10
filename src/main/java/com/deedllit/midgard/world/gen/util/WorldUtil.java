package com.deedllit.midgard.world.gen.util;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;

public class WorldUtil {

	public static int getFloorLevel(IChunk chunkIn, BlockPos pos) {
		
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
		blockpos$mutable.setPos(pos.getX(), pos.getY(), pos.getZ()) ; 
		
		WorldUtil.reachFloor(chunkIn, blockpos$mutable) ;
		
		return blockpos$mutable.getY() ; 
	}
	
	public static void reachFloor(IChunk chunkIn, BlockPos.Mutable blockpos$mutable) {
	
        if(chunkIn.getBlockState(blockpos$mutable).isAir()) {
            while(chunkIn.getBlockState(blockpos$mutable).isAir()) {
    			blockpos$mutable.move(Direction.DOWN) ;         	
            }        	
        } else {
            while(!chunkIn.getBlockState(blockpos$mutable).isAir()) {              	
    			blockpos$mutable.move(Direction.UP) ;         	
            }        	        	
        }
		
	}
	
}
