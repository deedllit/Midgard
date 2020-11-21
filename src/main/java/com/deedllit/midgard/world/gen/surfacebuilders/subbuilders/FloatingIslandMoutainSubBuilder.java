package com.deedllit.midgard.world.gen.surfacebuilders.subbuilders;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class FloatingIslandMoutainSubBuilder {

	private BlockState top  ; 
	private BlockState under  ; 
	private BlockState defaultFluid ; 
	
	public FloatingIslandMoutainSubBuilder() {
	}

	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config, double h, boolean addCorner) {

		this.top = config.getTop() ; 
		this.under = Blocks.STONE.getDefaultState() ; 
		this.defaultFluid = defaultFluid ; 
				
		BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        int k = x & 15;
        int l = z & 15;
        boolean found = false ;  
        boolean setTop = addCorner ;
        
		int n = (int) (noise / h) ; 
		
		/*
		if(n < 0) {
			n *= -1 ; 
			n += 40 ; 			
		}
		*/
		n = Math.abs(n) ; 
		
        for(int i1 = 5; i1 <= 100; i1++) {
            blockpos$mutableblockpos.setPos(k, i1, l);            
            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
                    		
    		if (blockstateCur == Blocks.WATER.getDefaultState() || blockstateCur == Blocks.AIR.getDefaultState()) {
   				if(found) {
   					
   					//Add stone on top island
   					for(int y2 = 0 ; y2 <= n ; y2++) {
   				        int y3 = y2+i1 ; 
   				        
   				        blockpos$mutableblockpos.setPos(x, y3, z);  
   				        
   				        if(y2 == n) {
   					        if (y3 < 120)
   					        	chunkIn.setBlockState(blockpos$mutableblockpos, top, false);        				
   					        else
   					        	chunkIn.setBlockState(blockpos$mutableblockpos, under, false);        					        	
   				        } else {
   				        	chunkIn.setBlockState(blockpos$mutableblockpos, under, false);        					        		        	
   				        }
   				    
        				if(setTop && random.nextInt(5) == 0) {
    						int nx = random.nextInt(y3 - y2 + 1)  ; 
    						if(nx > 0)
    							addExtraFourColumns(chunkIn, k, y3, l, nx) ;         		        								        						

        					setTop = false ; 
        				}

   				        
   					}
   					
   	    			//addExtraColumn(chunkIn, x,i1, z,n) ;  
   	    			//addExtraFourColumns(chunkIn, x,i1, z,n) ;
   	    			break ; 
   				}
    		} else {
    			found = true ; 
    		}
        }
		
		
	}

	private void addExtraFourColumns(IChunk chunkIn, int x, int y, int z, int n ) {
		
		if(x-1 >= 0)
			this.addExtraColumn(chunkIn, x-1, y, z, n) ; 

		if(x+1 <= 15)
			this.addExtraColumn(chunkIn, x+1, y, z, n) ; 

		if(z-1 >= 0)
			this.addExtraColumn(chunkIn, x, y, z-1, n) ; 

		if(z+1 <= 15)
			this.addExtraColumn(chunkIn, x, y, z+1, n) ; 

	}
	
	private void addExtraColumn(IChunk chunkIn, int x, int y, int z, int n ) {
				
		if(canAdd(chunkIn, x, y, z, n) == false)
			return ; 		
		
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
                
		for(int y2 = 0 ; y2 <= n ; y2++) {
	        int y3 = y2+y ; 
	        
	        blockpos$mutableblockpos.setPos(x, y3, z);  
	        
	        if(y2 == n) {
		        if (y3 < 120)
		        	chunkIn.setBlockState(blockpos$mutableblockpos, top, false);        				
		        else
		        	chunkIn.setBlockState(blockpos$mutableblockpos, under, false);        					        	
	        } else {
	        	chunkIn.setBlockState(blockpos$mutableblockpos, under, false);        					        		        	
	        }
	        	

	        
		}
	}
	
	private boolean canAdd(IChunk chunkIn, int x, int y, int z, int n) {
        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
        blockpos$mutableblockpos.setPos(x, y, z);   
        BlockState blockstate = chunkIn.getBlockState(blockpos$mutableblockpos.down());

        if (blockstate != Blocks.AIR.getDefaultState() && blockstate != defaultFluid) {
        	return false ;
        }

        blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
        
        for(int y2 = 1 ; y2 <= n ; y2++) {
            
	        if (blockstate != Blocks.AIR.getDefaultState() && blockstate != defaultFluid) {
	        	return false ;
	        }
            
	        blockpos$mutableblockpos.setPos(x, y+y2, z);   
            blockstate = chunkIn.getBlockState(blockpos$mutableblockpos);
		}
		
		return true ; 
	}
	
}
