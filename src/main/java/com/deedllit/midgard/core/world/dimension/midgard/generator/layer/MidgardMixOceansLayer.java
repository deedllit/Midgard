package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;

public enum MidgardMixOceansLayer implements IAreaTransformer2, IDimOffset0Transformer {
	   INSTANCE;

	   public int apply(INoiseRandom p_215723_1_, IArea p_215723_2_, IArea p_215723_3_, int p_215723_4_, int p_215723_5_) {
	      int i = p_215723_2_.getValue(this.getOffsetX(p_215723_4_), this.getOffsetZ(p_215723_5_));
	      int j = p_215723_3_.getValue(this.getOffsetX(p_215723_4_), this.getOffsetZ(p_215723_5_));
	      if (!MidgardLayerUtil.isOcean(i)) {
	         return i;
	      } else {
	         int k = 8;
	         int l = 4;

	         for(int i1 = -8; i1 <= 8; i1 += 4) {
	            for(int j1 = -8; j1 <= 8; j1 += 4) {
	               int k1 = p_215723_2_.getValue(this.getOffsetX(p_215723_4_ + i1), this.getOffsetZ(p_215723_5_ + j1));
	               if (!MidgardLayerUtil.isOcean(k1)) {
	                  if (j == MidgardLayerUtil.WARM_OCEAN) {
	                     return MidgardLayerUtil.LUKEWARM_OCEAN;
	                  }

	                  if (j == MidgardLayerUtil.FROZEN_OCEAN) {
	                     return MidgardLayerUtil.COLD_OCEAN;
	                  }
	               }
	            }
	         }

	         if (i == MidgardLayerUtil.DEEP_OCEAN) {
	            if (j == MidgardLayerUtil.LUKEWARM_OCEAN) {
					return MidgardLayerUtil.DEEP_LUKEWARM_OCEAN;
	            }

	            if (j == MidgardLayerUtil.OCEAN) {
	               return MidgardLayerUtil.DEEP_OCEAN;
	            }

	            if (j == MidgardLayerUtil.COLD_OCEAN) {
	               return MidgardLayerUtil.DEEP_COLD_OCEAN;
	            }

	            if (j == MidgardLayerUtil.FROZEN_OCEAN) {
	               return MidgardLayerUtil.DEEP_FROZEN_OCEAN;
	            }
	         }

	         return j;
	      }
	   }
	}

