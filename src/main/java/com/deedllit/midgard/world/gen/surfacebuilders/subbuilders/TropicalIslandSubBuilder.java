package com.deedllit.midgard.world.gen.surfacebuilders.subbuilders;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class TropicalIslandSubBuilder {

	private BlockState grass ; 
	private BlockState stone ; 
	private BlockState defaultFluid ; 
	private BlockState sand ; 
	private BlockState top ;
	private int sandLevelBottom ; 
	private int sandLevelTop ; 
	private int moutainLevelBottom ; 
	private int seaLevel ;
	
	public TropicalIslandSubBuilder() {
	}
		
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config, 
			int sandBottom, int sandTop, int moutainLevel,
			BlockState stone, BlockState grass, BlockState sand) {
	
		SurfaceBuilder.DEFAULT.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);			


		int maxH ; 
		
		if (noise >= 0D) {

			this.seaLevel = seaLevel ;
			this.defaultFluid = defaultFluid ;  
			
			this.stone = stone ; 
			this.grass = grass ; 
			this.sand = sand ; 			
			
	        BlockState blockstate = config.getTop() ; ;
	        BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();
	        int k = x & 15;
	        int l = z & 15;

	        sandLevelBottom = seaLevel + sandBottom ;
	        sandLevelTop = seaLevel + sandTop ;
	        moutainLevelBottom = moutainLevel ; 
	        
			double d = Biome.INFO_NOISE.noiseAt(x * 0.25D, z * 0.25D, false);		
			if(d > 0) {
				sandLevelTop += d * 1 ;
				moutainLevelBottom += d * 5 ;
			}

	        int h ; 
			int v = 4 ;  
			
			if(noise <= 0.5D) {
				maxH = 12  ; 
			} else if(noise <= 0.75D) {
				maxH = 13  ; 
			} else if(noise <= 1.0D) {
				maxH = 14  ; 
			} else if(noise <= 1.25D) {
				maxH = 15  ; 
			} else if(noise <= 1.5D) {
				maxH = 16  ; 
			} else if(noise <= 1.75D) {
				maxH = 17  ; 
			} else if(noise <= 2.0D) {
				maxH = 18  ; 
			} else if(noise <= 2.25D) {
				maxH = 19  ; 
			} else if(noise <= 2.50D) {
				maxH = 20  ; 
			} else if(noise <= 2.75D) {
				maxH = 21 ; 
			} else if(noise <= 3.0D) {
				maxH = 22 ; 
			} else if(noise <= 3.25D) {
				maxH = 24  ; 
				v = 5 ; 
			} else if(noise <= 3.50D) {
				maxH = 38  ; 
				v = 6 ; 
			} else if(noise <= 3.75D) {
				maxH = 40  ; 
				v = 6 ; 
			} else if(noise <= 4.0D) {
				maxH = 46  ; 
				v = 6 ; 
			} else if(noise <= 4.25D) {
				maxH = 52  ; 
				v = 6 ; 
			} else if(noise <= 4.5D) {
				maxH = 58  ; 
				v = 6 ; 
			} else {
				maxH = 64  ; 
				v = 4 ; 
			}
			
			maxH += d * v ;
	        
	        for(int i1 = 5; i1 <= seaLevel; i1++) {
	            blockpos$mutableblockpos.setPos(k, i1, l);            
	            BlockState blockstateCur = chunkIn.getBlockState(blockpos$mutableblockpos);
	            boolean setTop = true ;
	            boolean setBottom = true ;
	            
	        		
        		if (blockstateCur == Blocks.WATER.getDefaultState() || blockstateCur == Blocks.AIR.getDefaultState()) {
        			
        			maxH = Math.max(maxH, i1) ; 

        			h = maxH ;
        			
        			int fhx = i1 + h ; 
        			
        			for(int i2 = 0 ; i2 <= h ; i2++) {
        				
        				int hx = i2 + i1;
        					        				
        				blockstate = this.stone ; 
        				
        				if(i2 == h) {
        					if (hx >= sandLevelBottom && hx <= sandLevelTop) {
        						blockstate = this.sand ;	        						
        					} else if (hx > sandLevelTop && hx < moutainLevelBottom){
        						blockstate = this.grass ; 
        					}
        				} else {
        					if (fhx >= sandLevelBottom && fhx <= sandLevelTop && hx >= sandLevelBottom) {
        						blockstate = this.sand ;	        							        						
        					}
        				}
        				
        	            blockpos$mutableblockpos.setPos(k, i2 + i1, l);    
	                	chunkIn.setBlockState(blockpos$mutableblockpos, blockstate, false);        				
        				
	                	/*
	                	if( i2 + i1 > 100) {
		                	chunkIn.setBlockState(blockpos$mutableblockpos.up(), Fluids.LAVA.getDefaultState().getBlockState(), false);  
	                	}
	                	*/
	                	
	                	if(hx < seaLevel) {
	        				if(setBottom && random.nextInt(5) == 0) {
        						int nx = random.nextInt(h - i2 + 1)  ; 
        						if(nx > 0)
        							addExtraFourColumns(chunkIn, k, hx, l, nx) ;         		        								        						
	        						
	        					setBottom = false ; 
	        				}
	                	} else {
	                		
	        				if(setTop && random.nextInt(5) == 0) {
        						int nx = random.nextInt(h - i2 + 1)  ; 
        						if(nx > 0)
        							addExtraFourColumns(chunkIn, k, hx + random.nextInt(3) - 2, l, nx) ;         		        								        						

        						setTop = false ; 
	        				}
	        				
	                	}	        				

        			}
   
        			break ; 
            	}
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
        BlockState blockstate ; 
        
        int yh = y + n ; 
        
		for(int y2 = 0 ; y2 <= n ; y2++) {
	        int y3 = y2+y ; 

	        blockstate = stone ; 
	        if(y2 > 0) {
				if(y2 == n) {
					if (y3 >= sandLevelBottom && y3 <= sandLevelTop) {
						blockstate = this.sand ;	        			
					} else if (y3 > sandLevelTop && y3 < moutainLevelBottom){
						blockstate = this.grass ; 
					}
				} else {
					if (y3 >= sandLevelBottom && y3 <= sandLevelTop && yh <= sandLevelTop) {
						blockstate = this.sand ;	        			
					}
				}	        	
	        }
	        
	        blockpos$mutableblockpos.setPos(x, y3, z);  
        	chunkIn.setBlockState(blockpos$mutableblockpos, blockstate, false);        				

	        
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
