package com.deedllit.midgard.core.world.gen.feature.crop;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BlockInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;

public class RiceFeature extends Feature<RiceFeatureConfig> {

	public RiceFeature(Function<Dynamic<?>, ? extends RiceFeatureConfig> configFactoryIn) {
		super(configFactoryIn);
	}

	@Override
	public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
			BlockPos pos, RiceFeatureConfig config) {
		
		int count = 0;
		int w = worldIn.getSeaLevel() - 1 ; 
		
		for(int j = 0; j < config.count; ++j) {
	         int k = rand.nextInt(8) - rand.nextInt(8);
	         int l = rand.nextInt(8) - rand.nextInt(8);
	         int n = 10 + rand.nextInt(20);	//how many blocks above sea level 
	         BlockPos blockpos = new BlockPos(pos.getX() + k, w, pos.getZ() + l);

	         
             for(int i = 0; i <= n; i++) {
    	         if (worldIn.getBlockState(blockpos).getBlock() == Blocks.WATER) {
    		         Block ground = worldIn.getBlockState(blockpos).getBlock() ;
    		         
    		         if (BlockInit.MIDGARD_RICE_BOTTOM_CROP.get().getDefaultState().isValidPosition(worldIn, blockpos)) {    		        	 
                         worldIn.setBlockState(blockpos, BlockInit.MIDGARD_RICE_BOTTOM_CROP.get().getDefaultState(), 2);
                         ++count ; 
                         break ; 
    		         }
    		         
            	 blockpos = blockpos.up() ;
    	         }
             }
	         
		}
		
		
		return count > 0 ;
	}



}
