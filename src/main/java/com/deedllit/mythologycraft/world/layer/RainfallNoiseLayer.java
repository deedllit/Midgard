package com.deedllit.mythologycraft.world.layer;

import com.deedllit.midgard.world.gen.noise.SimplexNoise;
import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftAreaTransformer0;
import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftContextExtended;

public enum RainfallNoiseLayer implements IMythologycraftAreaTransformer0 {
	
    SMALL_ZONES(0.20D),
    MEDIUM_ZONES(0.10D),
    LARGE_ZONES(0.05D);

    private final double scale;

    RainfallNoiseLayer(double scale) {
        this.scale = scale;
    }

    @Override
    public int applyPixel(IMythologycraftContextExtended context, int x, int z) {
        double xOffset = (double)(context.getWorldSeed() & 0xFFFFFF) * 0.000003D;
        double zOffset = (double)(context.getWorldSeed() & 0xFFFFFF) * 0.000004D;
        double noiseVal = SimplexNoise.noise((x + xOffset) * this.scale, (z + zOffset) * this.scale);

        // boundaries were determined empirically by analyzing statistically output from the SimplexNoise function, and splitting into 12 equally likely groups
        if (noiseVal < -0.637D) return 0;
        else if (noiseVal < -0.575D) return 1;
        else if (noiseVal < -0.465D) return 2;
        else if (noiseVal < -0.295D) return 3;
        else if (noiseVal < -0.148D) return 4;
        else if (noiseVal < -0.034D) return 5;
        else if (noiseVal < 0.132D) return 6;
        else if (noiseVal < 0.246D) return 7;
        else if (noiseVal < 0.400D) return 8;
        else if (noiseVal < 0.551D) return 9;
        else if (noiseVal < 0.634D) return 10;
        else return 11;
    }

    
}
