package com.deedllit.midgard.core.world.dimension.midgard.biomes;

import com.deedllit.midgard.api.enums.MidgardClimate;
import com.deedllit.midgard.core.world.biome.MidgardBiome;
import com.deedllit.midgard.core.world.dimension.midgard.config.MidgardDefaultBiomeFeatures;
import com.deedllit.midgard.init.FeatureInit;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardTeakForestBiome extends MidgardBiome {

	public MidgardTeakForestBiome() {
	      super((new Biome.Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG)
		  	.precipitation(Biome.RainType.RAIN)
		  	.category(Biome.Category.FOREST)
		  	.depth(0.25F)
		  	.scale(0.05F)
		  	.temperature(0.8F)
		  	.downfall(0.3F)
		  	.waterColor(6388580)
		  	.waterFogColor(2302743)
		  	.parent((String)null));
	      
	      
			this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION,
					FeatureInit.BLACK_POPLAR_SMALL.withConfiguration(DefaultBiomeFeatures.OAK_TREE_CONFIG).withPlacement(
							Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0.1F, 1))));
	      

	      this.addWeight( MidgardClimate.TROPICAL,1);


		}
	      
  	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		double d0 = INFO_NOISE.noiseAt(posX * 0.0225D, posZ * 0.0225D, false);
	    return d0 < -0.1D ? 10066176 : 9210880;

  	}

}
