package com.deedllit.mythologycraft.world.layer;

import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftAreaTransformer0;
import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftContextExtended;

import net.minecraft.util.math.MathHelper;

//influenced by biomesoplenty mod, https://github.com/Glitchfiend/BiomesOPlenty/
public enum TemperatureLatitudeLayer implements IMythologycraftAreaTransformer0 {
    INSTANCE;

    private static final double HALF_PERIOD = 16.0D;
    private static final double PERIOD = HALF_PERIOD * 2.0D;
    private static final double OFFSET_VARIATION = HALF_PERIOD / 10.0D;
    private static final double AMPLITUDE = 8.9999D / HALF_PERIOD;

    @Override
    public int applyPixel(IMythologycraftContextExtended context, int x, int z)
    {
        int offset = (int) (context.getWorldSeed() % ((int) (PERIOD * 2)));

        double yOffset = z + offset + ((context.random(1001) - 500) * OFFSET_VARIATION / 500.0D);
        return MathHelper.floor(AMPLITUDE * Math.abs((Math.abs(yOffset % PERIOD) - HALF_PERIOD)));
    }

}