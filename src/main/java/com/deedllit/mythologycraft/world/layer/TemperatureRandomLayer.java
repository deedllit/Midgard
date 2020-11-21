package com.deedllit.mythologycraft.world.layer;

import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftAreaTransformer0;
import com.deedllit.mythologycraft.world.layer.traits.IMythologycraftContextExtended;

//influenced by biomesoplenty mod, https://github.com/Glitchfiend/BiomesOPlenty/
public enum TemperatureRandomLayer implements IMythologycraftAreaTransformer0 {

    INSTANCE;

    @Override
    public int applyPixel(IMythologycraftContextExtended context, int x, int z) {
        return context.random(9);
    }
}