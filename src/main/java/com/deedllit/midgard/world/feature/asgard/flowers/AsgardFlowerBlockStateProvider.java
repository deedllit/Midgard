package com.deedllit.midgard.world.feature.asgard.flowers;

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

public class AsgardFlowerBlockStateProvider extends BlockStateProvider {

	private static final BlockState[] PINK = new BlockState[]{Blocks.PEONY.getDefaultState(), Blocks.PINK_TULIP.getDefaultState(), BlockInit.SWEET_PEA.get().getDefaultState()};
	private static final BlockState[] MANGENTA = new BlockState[]{Blocks.LILAC.getDefaultState(), BlockInit.CHARDON.get().getDefaultState()};

	
	public AsgardFlowerBlockStateProvider() {
		super(BlockStateProviderType.PLAIN_FLOWER_PROVIDER);	
	}

	public <T> AsgardFlowerBlockStateProvider(Dynamic<T> p_i225857_1_) {
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
	         return PINK[randomIn.nextInt(PINK.length)];
	      } else {
	         return randomIn.nextInt(5) > 0 ? MANGENTA[randomIn.nextInt(MANGENTA.length)] : BlockInit.PURPLE_WOLFS_BANE.get().getDefaultState();
	      }
	} 

}
