package com.deedllit.mythologycraft.world.layer;

import com.deedllit.mythologycraft.world.biome.MythologycraftClimates;

import net.minecraft.util.math.MathHelper;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum ClimateLayer implements IAreaTransformer2, IDimOffset0Transformer {
    INSTANCE;

    private final int[] climateMapping;

    ClimateLayer() {
        this.climateMapping = MythologycraftClimates.getClimateMappingInts();
    }

    @Override
    public int apply(INoiseRandom context, IArea area1, IArea area2, int x, int z) {
        int temperature = area1.getValue(x, z);
        int rainfall = area2.getValue(x, z);

        int index = ( MathHelper.clamp(temperature, 0, 8) * 12 ) + MathHelper.clamp(rainfall, 0, 11);
        return this.climateMapping[index];
    }
    
}
