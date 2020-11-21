package com.deedllit.midgard.world.feature.flowers;

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

public class MidgardDesertFlowerBlockStateProvider extends BlockStateProvider {

	private static final BlockState[] BUSH = new BlockState[]{Blocks.DEAD_BUSH.getDefaultState()};
	private static final BlockState[] FLOWER = new BlockState[]{
			BlockInit.FISH_HOOK.get().getDefaultState(), 
			BlockInit.GUZMANIA_PINK.get().getDefaultState(), 
			BlockInit.GUZMANIA_RED.get().getDefaultState()};

	
	public MidgardDesertFlowerBlockStateProvider() {
		super(BlockStateProviderType.PLAIN_FLOWER_PROVIDER);	
	}

	public <T> MidgardDesertFlowerBlockStateProvider(Dynamic<T> p_i225857_1_) {
		this();
	}


	@Override
	public <T> T serialize(DynamicOps<T> p_218175_1_) {
		return null;
	}

	@Override
	public BlockState getBlockState(Random randomIn, BlockPos blockPosIn) {
	      double d0 = Biome.INFO_NOISE.noiseAt((double)blockPosIn.getX() / 200.0D, (double)blockPosIn.getZ() / 200.0D, false);
	      if (d0 < -0.8D) {
	         return BUSH[randomIn.nextInt(BUSH.length)];
	      } else {
	         return randomIn.nextInt(5) > 0 ? FLOWER[randomIn.nextInt(FLOWER.length)] : Blocks.DEAD_BUSH.getDefaultState();
	      }
	} 
	
}
