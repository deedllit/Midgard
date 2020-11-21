package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.init.BlockInit;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class RiceFieldSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

	public RiceFieldSurfaceBuilder(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {

		SurfaceBuilder.SWAMP.buildSurface(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, config);

	    int i = x & 15;
	    int j = z & 15;
		double d = Biome.INFO_NOISE.noiseAt(x * 0.125D, z * 0.125D, false);		
		
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
					
		blockpos$mutable.setPos(i, seaLevel-1, j);
		BlockState blockstateWater = chunkIn.getBlockState(blockpos$mutable);
		blockpos$mutable.setPos(i, seaLevel-1, j);
		BlockState blockstateGround = chunkIn.getBlockState(blockpos$mutable.down());

		if (blockstateWater.getBlock() == Blocks.WATER && blockstateGround.getBlock() == Blocks.DIRT && d <= 0 ) {
			blockstateWater = BlockInit.MIDGARD_RICE_BOTTOM_CROP.get().getDefaultState() ; 
			chunkIn.setBlockState(blockpos$mutable, blockstateWater, false);
		}
		
	}

}
