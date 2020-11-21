package com.deedllit.mythologycraft.world.layer;

import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftAreaTransformer0;
import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftContextExtended;

import net.minecraft.util.math.MathHelper;

public enum RainfallRandomLayer implements IMythologycraftAreaTransformer0 {
    INSTANCE;

    @Override
    public int applyPixel(IMythologycraftContextExtended context, int x, int z)
    {
        return context.random(12);
    }

}