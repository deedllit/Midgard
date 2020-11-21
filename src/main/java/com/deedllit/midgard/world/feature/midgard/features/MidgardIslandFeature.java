package com.deedllit.midgard.world.feature.midgard.features;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.world.feature.template.BifrostBuilder;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class MidgardIslandFeature extends Feature<NoFeatureConfig> {

	private BifrostBuilder builder ; 
	private final BlockState[] bs = {Blocks.GRASS_BLOCK.getDefaultState(), Blocks.DIRT.getDefaultState(), Blocks.STONE.getDefaultState()} ; 
	
	public MidgardIslandFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, NoFeatureConfig config) {
		
		if(rand.nextInt(100) > 85)
			return false ; 
		
		int h = rand.nextInt(120) + 45 ; 
		int mirror ;
		
		float f = (float)(rand.nextInt(5) + 7);
	    int c = 0 ; 
	    
	    boolean hasPortal = false ; 
	    boolean canHavePortal = false ; 
	    
	    int portal = rand.nextInt(85-pos.getY()) ; 
	    
	    if(portal < 1)
	    	canHavePortal = true ; 
	    
    	if(rand.nextInt(5) == 0) {
	    	mirror = Math.min(rand.nextInt(8), rand.nextInt(8)) ; 
	    	canHavePortal = false ; 
	    } else {
	    	mirror = 0 ;	    	
	    }
	    
	    for(int i = 0; f > 0.5F; --i) {

	        for(int j = MathHelper.floor(-f); j <= MathHelper.ceil(f); ++j) {
	    		for(int k = MathHelper.floor(-f); k <= MathHelper.ceil(f); ++k) {
	    			if ((float)(j * j + k * k) <= (f + 1.0F) * (f + 1.0F)) {
	            	   
	    				if(c == 0) {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[0]);	    
	    					
	    					if(canHavePortal && hasPortal == false) {
	    					    portal = rand.nextInt(20) ; 
	    					    if(portal == 0) {
		    						builder = new BifrostBuilder() ; 
		    						hasPortal = builder.place(worldIn, rand, pos.add(j, i+h,k));	    					    	
	    					    }
	    					}
	    					
	    					
	    				} else if(c == 1) {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[1]);	
	    				} else {
	    					this.setBlockState(worldIn, pos.add(j, i+h, k), bs[2]);	    					
	    				}

	    				
						if(c < mirror) {
							this.setBlockState(worldIn, pos.add(j, h+c, k), bs[0]);	    
							
							if(worldIn.getBlockState(pos.add(j , h+c-1 , k)) == bs[0]) {
		    					this.setBlockState(worldIn, pos.add(j, h+c-1, k), bs[1]);									
							} else if(worldIn.getBlockState(pos.add(j , h+c-1 , k)) == bs[1]) {
		    					this.setBlockState(worldIn, pos.add(j, h+c-1, k), bs[2]);																	
							}							
						}
							
	    			}
	            }
	        }

	        c++ ; 
	    	f = (float)((double)f - ((double)rand.nextInt(2) + 0.5D));
	         
	    }

	    return true;

	}
}
	

 
