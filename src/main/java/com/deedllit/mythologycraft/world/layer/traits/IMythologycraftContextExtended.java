package com.deedllit.mythologycraft.world.layer.traits;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;

//influenced by biomesoplenty mod, https://github.com/Glitchfiend/BiomesOPlenty/
public interface IMythologycraftContextExtended<R extends IArea> extends IExtendedNoiseRandom<R> {
    long getWorldSeed();
}
