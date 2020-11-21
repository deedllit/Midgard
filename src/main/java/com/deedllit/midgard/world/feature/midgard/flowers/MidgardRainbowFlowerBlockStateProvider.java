package com.deedllit.midgard.world.feature.midgard.flowers;

import java.util.Random;

import com.deedllit.midgard.init.BlockInit;
import com.mojang.datafixers.Dynamic;
import com.mojang.datafixers.types.DynamicOps;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;

public class MidgardRainbowFlowerBlockStateProvider extends BlockStateProvider {

	
	private static final BlockState[] RED = new BlockState[]{Blocks.POPPY.getDefaultState(), BlockInit.RED_SUNFLOWER.get().getDefaultState(), Blocks.RED_TULIP.getDefaultState(), Blocks.ROSE_BUSH.getDefaultState()};
	private static final BlockState[] ORANGE = new BlockState[]{Blocks.ORANGE_TULIP.getDefaultState()};
	private static final BlockState[] YELLOW = new BlockState[]{Blocks.DANDELION.getDefaultState(), Blocks.SUNFLOWER.getDefaultState()};
	private static final BlockState[] GREEN = new BlockState[]{Blocks.TALL_GRASS.getDefaultState()};
	private static final BlockState[] BLUE = new BlockState[]{Blocks.CORNFLOWER.getDefaultState(), Blocks.BLUE_ORCHID.getDefaultState()};
	private static final BlockState[] PINK = new BlockState[]{Blocks.PEONY.getDefaultState(), Blocks.PINK_TULIP.getDefaultState()};
	private static final BlockState[] MANGENTA = new BlockState[]{BlockInit.PURPLE_SUNFLOWER.get().getDefaultState(),  Blocks.LILAC.getDefaultState()};

	
	public MidgardRainbowFlowerBlockStateProvider() {
		super(BlockStateProviderType.PLAIN_FLOWER_PROVIDER);	
	}

	public <T> MidgardRainbowFlowerBlockStateProvider(Dynamic<T> p_i225857_1_) {
		this();
	}


	@Override
	public <T> T serialize(DynamicOps<T> p_218175_1_) {
		return null;
	}

	@Override
	public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
	      double d0 = Biome.INFO_NOISE.noiseAt((double)blockPosIn.getX() / 200.0D, (double)blockPosIn.getZ() / 200.0D, false);
	      	      
	      if(d0 < -2.7D)
	    	  return RED[randomIn.nextInt(RED.length)];
	      else if(d0 < -1.4D)
	    	  return ORANGE[randomIn.nextInt(ORANGE.length)];
	      else if(d0 < 0.1D)
	    	  return YELLOW[randomIn.nextInt(YELLOW.length)];
	      else if(d0 < 1.4D)
	    	  return BLUE[randomIn.nextInt(BLUE.length)];
	      else if(d0 < 2.7D)
	    	  return PINK[randomIn.nextInt(PINK.length)];
	      else if(d0 < 4.0D)
	    	  return MANGENTA[randomIn.nextInt(MANGENTA.length)];
	    	  
    	  return GREEN[randomIn.nextInt(GREEN.length)];

	} 

}
