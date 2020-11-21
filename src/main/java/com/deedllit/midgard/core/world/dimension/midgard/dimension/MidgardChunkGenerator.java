package com.deedllit.midgard.core.world.dimension.midgard.dimension;

import java.util.List;

import com.deedllit.midgard.core.world.dimension.midgard.generator.MidgardGenSettings;

import net.minecraft.entity.EntityClassification;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.OctavesNoiseGenerator;

//CTRL SHIFT + T for original setting
//EndChunkGenerator
//NetherChuckGenerator
//OverworldChuckGenerator

public class MidgardChunkGenerator extends NoiseChunkGenerator<MidgardGenSettings> {
	
	/*
	private static final float[] field_222576_h = Util.make(new float[25], (p_222575_0_) -> {
		for (int i = -2; i <= 2; ++i) {
			for (int j = -2; j <= 2; ++j) {
				float f = 10.0F / MathHelper.sqrt((float) (i * i + j * j) + 0.2F);
				p_222575_0_[i + 2 + (j + 2) * 5] = f;
			}
		}

	});
	*/
	private final OctavesNoiseGenerator depthNoise;
	private final boolean isAmplified;
	
	public MidgardChunkGenerator(IWorld worldIn, BiomeProvider provider, MidgardGenSettings settingsIn) {
		super(worldIn, provider, 80, 160, 256, settingsIn, true);
		this.randomSeed.skip(2620);
		this.depthNoise = new OctavesNoiseGenerator(this.randomSeed, 15, 0);
		this.isAmplified = worldIn.getWorldInfo().getGenerator() == WorldType.AMPLIFIED;
	}

	@SuppressWarnings("unused")
	protected void fillNoiseColumn(double[] noiseColumn, int noiseX, int noiseZ) {
		double d0 = (double) 684.412F;
		double d1 = (double) 684.412F;
		double d2 = 8.555149841308594D;
		double d3 = 4.277574920654297D;
		int i = -10;
		int j = 3;
		this.calcNoiseColumn(noiseColumn, noiseX, noiseZ, (double) 684.412F, (double) 684.412F, 8.555149841308594D,
				4.277574920654297D, 3, -10);
	}

	@Override
	public List<Biome.SpawnListEntry> getPossibleCreatures(EntityClassification creatureType, BlockPos pos) {
		return super.getPossibleCreatures(creatureType, pos);
	}


	public int getGroundHeight() {
		return 62 ;
	}

	/*
    public int getSeaLevel() {
        return 0;
    }
	*/
	
	@Override
	protected double[] getBiomeNoiseColumn(int noiseX, int noiseZ) {
	      return new double[]{(double)this.biomeProvider.func_222365_c(noiseX, noiseZ), 0.0D};
	}

	@Override
	protected double func_222545_a(double p_222545_1_, double p_222545_3_, int p_222545_5_) {
		double d1 = ((double) p_222545_5_ - (8.5D + p_222545_1_ * 8.5D / 8.0D * 4.0D)) * 12.0D * 128.0D / 256.0D
				/ p_222545_3_;
		if (d1 < 0.0D) {
			d1 *= 4.0D;
		}

		return d1;
	}

		
}