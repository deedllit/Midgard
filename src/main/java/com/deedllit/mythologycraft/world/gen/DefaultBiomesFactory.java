package com.deedllit.mythologycraft.world.gen;

import java.util.function.LongFunction;

import com.deedllit.mythologycraft.world.layer.ClimateLayer;
import com.deedllit.mythologycraft.world.layer.MythologycraftBiomeLayer;
import com.deedllit.mythologycraft.world.layer.RainfallNoiseLayer;
import com.deedllit.mythologycraft.world.layer.TemperatureNoiseLayer;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddBambooForestLayer;
import net.minecraft.world.gen.layer.AddIslandLayer;
import net.minecraft.world.gen.layer.AddMushroomIslandLayer;
import net.minecraft.world.gen.layer.AddSnowLayer;
import net.minecraft.world.gen.layer.DeepOceanLayer;
import net.minecraft.world.gen.layer.EdgeLayer;
import net.minecraft.world.gen.layer.HillsLayer;
import net.minecraft.world.gen.layer.IslandLayer;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.MixOceansLayer;
import net.minecraft.world.gen.layer.MixRiverLayer;
import net.minecraft.world.gen.layer.OceanLayer;
import net.minecraft.world.gen.layer.RareBiomeLayer;
import net.minecraft.world.gen.layer.RemoveTooMuchOceanLayer;
import net.minecraft.world.gen.layer.RiverLayer;
import net.minecraft.world.gen.layer.ShoreLayer;
import net.minecraft.world.gen.layer.SmoothLayer;
import net.minecraft.world.gen.layer.StartRiverLayer;
import net.minecraft.world.gen.layer.ZoomLayer;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;

public class DefaultBiomesFactory {

	public static Layer[] getDefaultBiomesFactory3(long seed, Biome[] dimensionBiomes, int biomeSize, int riverSize) {

		BiomeLayerUtils biomeLayerUtil = new BiomeLayerUtils(dimensionBiomes); 
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);		

        IAreaFactory<LazyArea> iareafactory = IslandLayer.INSTANCE.apply(contextFactory.apply(1L));

        iareafactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), iareafactory);
        iareafactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), iareafactory);
        
        /*
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), iareafactory);
        iareafactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), iareafactory);
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), iareafactory);
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), iareafactory);
        iareafactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        IAreaFactory<LazyArea> iareafactory1 = OceanLayer.INSTANCE.apply(contextFactory.apply(2L));
        iareafactory1 = repeat(2001L, ZoomLayer.NORMAL, iareafactory1, 6, contextFactory);
        iareafactory = AddSnowLayer.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), iareafactory);
        iareafactory = EdgeLayer.CoolWarm.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = EdgeLayer.HeatIce.INSTANCE.apply(contextFactory.apply(2L), iareafactory);
        iareafactory = EdgeLayer.Special.INSTANCE.apply(contextFactory.apply(3L), iareafactory);
        iareafactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), iareafactory);
        iareafactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), iareafactory);
        iareafactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), iareafactory);
        iareafactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), iareafactory);
        iareafactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), iareafactory);
        iareafactory = repeat(1000L, ZoomLayer.NORMAL, iareafactory, 0, contextFactory);
        
        
        int i = biomeSize ; 
		int j = riverSize ;
	
	    IAreaFactory<LazyArea> lvt_7_1_ = repeat(1000L, ZoomLayer.NORMAL, iareafactory, 0, contextFactory);
	    lvt_7_1_ = StartRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(100L), lvt_7_1_);
	    
	    //IAreaFactory<LazyArea> lvt_8_1_ = p_227475_0_.getBiomeLayer(iareafactory, p_227475_1_, contextFactory);
		IAreaFactory<LazyArea> lvt_8_1_ = biomeLayerUtil.apply(contextFactory.apply(200), iareafactory);
	
	    IAreaFactory<LazyArea> lvt_9_1_ = repeat(1000L, ZoomLayer.NORMAL, lvt_7_1_, 2, contextFactory);
	      
	    lvt_8_1_ = HillsLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), lvt_8_1_, lvt_9_1_);
	    lvt_7_1_ = HillsLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), lvt_8_1_, lvt_9_1_);
	
	    lvt_7_1_ = repeat(1000L, ZoomLayer.NORMAL, lvt_7_1_, 2, contextFactory);
	    lvt_7_1_ = repeat(1000L, ZoomLayer.NORMAL, lvt_7_1_, j, contextFactory);
	    lvt_7_1_ = RiverLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1L), lvt_7_1_);
	    lvt_7_1_ = SmoothLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), lvt_7_1_);
	    lvt_8_1_ = RareBiomeLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1001L), lvt_8_1_);
	
	    for(int k = 0; k < i; ++k) {
	       lvt_8_1_ = ZoomLayer.NORMAL.apply((IExtendedNoiseRandom)contextFactory.apply((long)(1000 + k)), lvt_8_1_);
	       if (k == 0) {
	          lvt_8_1_ = AddIslandLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(3L), lvt_8_1_);
	       }
	
	       if (k == 1 || i == 1) {
	          lvt_8_1_ = ShoreLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), lvt_8_1_);
	       }
	    }
	
	    lvt_8_1_ = SmoothLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(1000L), lvt_8_1_);
	    lvt_8_1_ = MixRiverLayer.INSTANCE.apply((IExtendedNoiseRandom)contextFactory.apply(100L), lvt_8_1_, lvt_7_1_);
	    lvt_8_1_ = MixOceansLayer.INSTANCE.apply(contextFactory.apply(100L), lvt_8_1_, iareafactory1);
		
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), iareafactory);
		return new Layer[]{new Layer(lvt_8_1_), new Layer(voronoizoom)};
		*/
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), iareafactory);
		return new Layer[]{new Layer(iareafactory), new Layer(voronoizoom)};
	}
	
	public static Layer[] getDefaultBiomesFactory(long seed, Biome[] dimensionBiomes, int biomeSize,  int riverSize) {
		
		BiomeLayerUtils biomeLayerUtil = new BiomeLayerUtils(dimensionBiomes); 
		
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, seed, l);		
		
        biomeSize = LayerUtil.getModdedBiomeSize(WorldType.DEFAULT, biomeSize);

        
        IAreaFactory<LazyArea> landSeaFactory = IslandLayer.INSTANCE.apply(contextFactory.apply(1L));

		//INIT
		landSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), landSeaFactory);
        landSeaFactory = RemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), landSeaFactory);
        landSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), landSeaFactory);
        landSeaFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        //CLIMATE
        //IAreaFactory<LazyArea> temperatureFactory = TemperatureNoiseLayer.MEDIUM_ZONES.run(contextFactory.apply(4L));
        //IAreaFactory<LazyArea> rainfallFactory = RainfallNoiseLayer.MEDIUM_ZONES.run(contextFactory.apply(4L));
        //IAreaFactory<LazyArea> climateFactory = ClimateLayer.INSTANCE.apply(contextFactory.apply(103L), temperatureFactory, rainfallFactory);
        
        //ISLAND AND OCEAN
        landSeaFactory = AddMushroomIslandLayer.INSTANCE.apply(contextFactory.apply(5L), landSeaFactory);
        landSeaFactory = DeepOceanLayer.INSTANCE.apply(contextFactory.apply(4L), landSeaFactory);

        
        //ALLOCATE BIOME
        //IAreaFactory<LazyAreaT> biomeFactory = MythologycraftBiomeLayer.INSTANCE.apply(contextFactory.apply(200L), landSeaAreaFactory, climateAreaFactory);
        //biomeFactory = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), biomeFactory);
        //biomeFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomeFactory, 2, contextFactory);        
		IAreaFactory<LazyArea> biomesFactory = biomeLayerUtil.apply(contextFactory.apply(200), landSeaFactory);
		//biomesFactory = biomeLayerUtil.apply(contextFactory.apply(200), climateFactory);

		
		//SET RIVER AND SUB BIOME 
        IAreaFactory<LazyArea> riverAndSubBiomesInitFactory = StartRiverLayer.INSTANCE.apply(contextFactory.apply(100L), landSeaFactory);
        riverAndSubBiomesInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, 2, contextFactory);
        IAreaFactory<LazyArea> riversInitFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, riverAndSubBiomesInitFactory, riverSize, contextFactory);
        riversInitFactory = RiverLayer.INSTANCE.apply(contextFactory.apply(1L), riversInitFactory);
        riversInitFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), riversInitFactory);

        
        //MIX BIOMES
        biomesFactory = RareBiomeLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);

		
        for (int i = 0; i < biomeSize; ++i)
        {
            biomesFactory = ZoomLayer.NORMAL.apply(contextFactory.apply((long)(1000 + i)), biomesFactory);
            if (i == 0) 
            	biomesFactory = AddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), biomesFactory);
        }
		
        biomesFactory = SmoothLayer.INSTANCE.apply(contextFactory.apply(1000L), biomesFactory);

        biomesFactory = AddBambooForestLayer.INSTANCE.apply(contextFactory.apply(1001L), biomesFactory);
        biomesFactory = LayerUtil.repeat(1000L, ZoomLayer.NORMAL, biomesFactory, 2, contextFactory);
		        
		IAreaFactory<LazyArea> voronoizoom = ZoomLayer.FUZZY.apply(contextFactory.apply(10), biomesFactory);
		return new Layer[]{new Layer(biomesFactory), new Layer(voronoizoom)};

		
	}
	
	   public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<T> p_202829_3_, int count, LongFunction<C> contextFactory) {
		      IAreaFactory<T> iareafactory = p_202829_3_;

		      for(int i = 0; i < count; ++i) {
		         iareafactory = parent.apply(contextFactory.apply(seed + (long)i), iareafactory);
		      }

		      return iareafactory;
		   }	
	
}
