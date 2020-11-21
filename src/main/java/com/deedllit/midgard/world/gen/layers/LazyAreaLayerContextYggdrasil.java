package com.deedllit.midgard.world.gen.layers;

import net.minecraft.world.gen.LazyAreaLayerContext;

public class LazyAreaLayerContextYggdrasil extends LazyAreaLayerContext {

	private long worldSeed;
	
    public LazyAreaLayerContextYggdrasil(int maxCacheSize, long seed, long seedModifier) {
        super(maxCacheSize, seed, seedModifier);
        this.worldSeed = seed;
    }

    public long getWorldSeed() {
		return this.worldSeed;
	}

}