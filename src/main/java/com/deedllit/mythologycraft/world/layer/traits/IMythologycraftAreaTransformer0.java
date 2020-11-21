package com.deedllit.mythologycraft.world.layer.traits;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;

//influenced by biomesoplenty mod, https://github.com/Glitchfiend/BiomesOPlenty/
public interface IMythologycraftAreaTransformer0 {
    default <R extends IArea> IAreaFactory<R> run(IExtendedNoiseRandom<R> context)
    {
        if (!(context instanceof IMythologycraftContextExtended))
            throw new IllegalArgumentException("Context must be an IMythologycraftContextExtended");

        IMythologycraftContextExtended<R> mcContext = (IMythologycraftContextExtended<R>)context;
		        
        // Create a new IAreaFactory
        return () ->
            // Return a new IArea, with the below IPixelTransformer
            context.makeArea((x, z) ->
            {
                context.setPosition((long)(x), (long)(z));
                return this.applyPixel(mcContext, x, z);
            });
            
    }

    int applyPixel(IMythologycraftContextExtended context, int x, int z);
}
