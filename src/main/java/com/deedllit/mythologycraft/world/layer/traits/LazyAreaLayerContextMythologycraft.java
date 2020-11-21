package com.deedllit.mythologycraft.world.layer.traits;

import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.LazyArea;

public class LazyAreaLayerContextMythologycraft extends LazyAreaLayerContext implements IMythologycraftContextExtended<LazyArea> {
    
	private long worldSeed;

    public LazyAreaLayerContextMythologycraft(int maxCacheSize, long seed, long seedModifier) {
        super(maxCacheSize, seed, seedModifier);
        this.worldSeed = seed;
    }

    @Override
    public long getWorldSeed() {
        return this.worldSeed;
    }
}
