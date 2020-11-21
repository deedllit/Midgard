package com.deedllit.midgard.world.gen.layers;

import java.util.function.LongFunction;

import com.deedllit.midgard.core.world.dimension.midgard.config.VanillaMidgardWorldGenSettings;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.Layer;

public class VanillaMidgardLayer {

	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createAreaFactories(WorldType worldType, VanillaMidgardWorldGenSettings settings, LongFunction<C> contextFactory) {
		return null;
	}
	

	public static Layer createGenLayers(long seed, WorldType worldType, VanillaMidgardWorldGenSettings settings) {
        IAreaFactory<LazyArea> factory = createAreaFactories(worldType, settings, (seedModifier) ->
        {
            return new LazyAreaLayerContextYggdrasil(1, seed, seedModifier);
        });
        return new Layer(factory);
    }
	
}
