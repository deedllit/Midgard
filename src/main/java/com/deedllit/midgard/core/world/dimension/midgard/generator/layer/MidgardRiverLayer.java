package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import com.deedllit.midgard.Midgard;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.ICastleTransformer;

public enum MidgardRiverLayer implements ICastleTransformer {
	   INSTANCE;


	   public int apply(INoiseRandom context, int north, int west, int south, int east, int center) {
	      int i = riverFilter(center);
	      return i == riverFilter(east) && i == riverFilter(north) && i == riverFilter(west) && i == riverFilter(south) ? -1 : MidgardLayerUtil.RIVER;
	   }

	   private static int riverFilter(int value) {
		   
		   int newValue = 2 + (value & 1) ; 
		   
		  // Midgard.LOGGER.info("MidgardRiverLayer" + value+ " --> " + newValue) ;
		   
	      return value >= 2 ? newValue : value;
	   }
	}

