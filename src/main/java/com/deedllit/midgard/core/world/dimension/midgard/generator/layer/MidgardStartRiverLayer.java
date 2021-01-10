package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.Midgard;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public enum MidgardStartRiverLayer implements IC0Transformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int value) {
		   
		   if(MidgardLayerUtil.isShallowOcean(value))
			   return value ;
		   
		   int r = context.random(299999) + 2 ; 

		   return r ; 
		   
	   }
	}
