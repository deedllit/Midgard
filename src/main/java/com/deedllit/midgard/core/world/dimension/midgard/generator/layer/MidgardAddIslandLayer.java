package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IBishopTransformer;

public enum MidgardAddIslandLayer implements IBishopTransformer {
	   INSTANCE;

	   public int apply(INoiseRandom context, int x, int southEast, int p_202792_4_, int p_202792_5_, int p_202792_6_) {
	      if (!MidgardLayerUtil.isShallowOcean(p_202792_6_) || MidgardLayerUtil.isShallowOcean(p_202792_5_) && MidgardLayerUtil.isShallowOcean(p_202792_4_) && MidgardLayerUtil.isShallowOcean(x) && MidgardLayerUtil.isShallowOcean(southEast)) {
	         if (!MidgardLayerUtil.isShallowOcean(p_202792_6_) && (MidgardLayerUtil.isShallowOcean(p_202792_5_) || MidgardLayerUtil.isShallowOcean(x) || MidgardLayerUtil.isShallowOcean(p_202792_4_) || MidgardLayerUtil.isShallowOcean(southEast)) && context.random(5) == 0) {
	            if (MidgardLayerUtil.isShallowOcean(p_202792_5_)) {
	               return p_202792_6_ == MidgardLayerUtil.FOREST ? MidgardLayerUtil.FOREST : p_202792_5_;
	            }

	            if (MidgardLayerUtil.isShallowOcean(x)) {
	               return p_202792_6_ == MidgardLayerUtil.FOREST ? MidgardLayerUtil.FOREST : x;
	            }

	            if (MidgardLayerUtil.isShallowOcean(p_202792_4_)) {
	               return p_202792_6_ == MidgardLayerUtil.FOREST ? MidgardLayerUtil.FOREST : p_202792_4_;
	            }

	            if (MidgardLayerUtil.isShallowOcean(southEast)) {
	               return p_202792_6_ == MidgardLayerUtil.FOREST ? MidgardLayerUtil.FOREST : southEast;
	            }
	         }

	         return p_202792_6_;
	      } else {
	         int i = 1;
	         int j = MidgardLayerUtil.PLAINS;
	         if (!MidgardLayerUtil.isShallowOcean(p_202792_5_) && context.random(i++) == 0) {
	            j = p_202792_5_;
	         }

	         if (!MidgardLayerUtil.isShallowOcean(p_202792_4_) && context.random(i++) == 0) {
	            j = p_202792_4_;
	         }

	         if (!MidgardLayerUtil.isShallowOcean(x) && context.random(i++) == 0) {
	            j = x;
	         }

	         if (!MidgardLayerUtil.isShallowOcean(southEast) && context.random(i++) == 0) {
	            j = southEast;
	         }

	         if (context.random(3) == 0) {
	            return j;
	         } else {
	            return j == MidgardLayerUtil.FOREST ? MidgardLayerUtil.FOREST : p_202792_6_;
	         }
	      }
	   }
	}
