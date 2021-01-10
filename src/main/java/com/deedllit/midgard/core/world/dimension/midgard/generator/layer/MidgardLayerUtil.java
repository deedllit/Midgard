package com.deedllit.midgard.core.world.dimension.midgard.generator.layer;

import java.util.function.LongFunction;

import com.deedllit.midgard.init.BiomeInit;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.LazyAreaLayerContext;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.*;
import net.minecraft.world.gen.layer.traits.IAreaTransformer1;
import net.minecraft.world.gen.layer.traits.IC0Transformer;

public class MidgardLayerUtil {

	public static final int COLD_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_COLD_OCEAN_BIOME.get());
	public static final int DEEP_COLD_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_COLD_OCEAN_BIOME.get());
	public static final int DEEP_FROZEN_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_FROZEN_OCEAN_BIOME.get());
	public static final int DEEP_LUKEWARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_LUKE_WARM_OCEAN_BIOME.get());
	public static final int DEEP_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_OCEAN_BIOME.get());
	public static final int DEEP_WARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_DEEP_WARM_OCEAN_BIOME.get());
	public static final int WARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_WARM_OCEAN_BIOME.get());
	public static final int OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_OCEAN_BIOME.get());
	public static final int LUKEWARM_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_LUKE_WARM_OCEAN_BIOME.get());
	public static final int FROZEN_OCEAN = Registry.BIOME.getId(BiomeInit.VANILLA_FROZEN_OCEAN_BIOME.get());

	public static final int RIVER = Registry.BIOME.getId(BiomeInit.VANILLA_RIVER_BIOME.get());

	//1
	public static final int PLAINS = Registry.BIOME.getId(BiomeInit.VANILLA_PLAINS_BIOME.get());
	//2
	public static final int DESERT = Registry.BIOME.getId(BiomeInit.VANILLA_DESERT_BIOME.get());
	//3
	public static final int MOUTAINS = Registry.BIOME.getId(BiomeInit.VANILLA_MOUNTAINS_BIOME.get());
	//4
	public static final int FOREST = Registry.BIOME.getId(BiomeInit.VANILLA_FOREST_BIOME.get());

	public static final int FROZEN_RIVER = Registry.BIOME.getId(BiomeInit.VANILLA_FROZEN_RIVER_BIOME.get());
	public static final int SNOWY_TUNDRA = Registry.BIOME.getId(Biomes.SNOWY_TUNDRA);
	public static final int MUSHROOM_FIELDS = Registry.BIOME.getId(BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get());
	public static final int MUSHROOM_FIELD_SHORE = Registry.BIOME.getId(Biomes.MUSHROOM_FIELD_SHORE);
	
	

	
	
	public static Layer createWorld(World world) {
		
		LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory = l -> new LazyAreaLayerContext(15, world.getSeed(), l);
		
		
		IAreaFactory<LazyArea> earthSeaFactory = createEarthSea(contextFactory);
		
		return new Layer(earthSeaFactory);
		
	}
	

	
	
	

	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createEarthSea(LongFunction<C> contextFactory) {
		//LAND AND SEA 
		IAreaFactory<T> earthSeaFactory = MidgardIslandLayer.INSTANCE.apply(contextFactory.apply(1));
		earthSeaFactory = ZoomLayer.FUZZY.apply(contextFactory.apply(2000L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(1L), earthSeaFactory);
		earthSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2001L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(2L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(50L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(70L), earthSeaFactory);	    
		earthSeaFactory = MidgardRemoveTooMuchOceanLayer.INSTANCE.apply(contextFactory.apply(2L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(3L), earthSeaFactory);
		earthSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2002L), earthSeaFactory);
		earthSeaFactory = ZoomLayer.NORMAL.apply(contextFactory.apply(2003L), earthSeaFactory);
		earthSeaFactory = MidgardAddIslandLayer.INSTANCE.apply(contextFactory.apply(4L), earthSeaFactory);
		return earthSeaFactory;
	}

	
	/*
	public static <T extends IArea, C extends IExtendedNoiseRandom<T>> IAreaFactory<T> createAreaFactories(WorldType worldType, MidgardverworldGenSettings settings, LongFunction<C> contextFactory) {
		
	}
	*/
	
	
	public static int getModdedBiomeSize(WorldType worldType, int original) {
		net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize event = new net.minecraftforge.event.terraingen.WorldTypeEvent.BiomeSize(
				worldType, original);
		net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
		return event.getNewSize();
	}
	
	public static IAreaFactory<LazyArea> repeat(long seed, IAreaTransformer1 parent, IAreaFactory<LazyArea> targetFactory,
			int count, LongFunction<IExtendedNoiseRandom<LazyArea>> contextFactory) {

		IAreaFactory<LazyArea> iareafactory = targetFactory;

		for (int i = 0; i < count; ++i) {
			iareafactory = parent.apply(contextFactory.apply(seed + (long) i), iareafactory);
		}

	return iareafactory;
	}
	
	public static boolean isOcean(int biomeIn) {
		return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN
				|| biomeIn == FROZEN_OCEAN || biomeIn == DEEP_WARM_OCEAN || biomeIn == DEEP_LUKEWARM_OCEAN
				|| biomeIn == DEEP_OCEAN || biomeIn == DEEP_COLD_OCEAN || biomeIn == DEEP_FROZEN_OCEAN;
	}

	public static boolean isShallowOcean(int biomeIn) {
		return biomeIn == WARM_OCEAN || biomeIn == LUKEWARM_OCEAN || biomeIn == OCEAN || biomeIn == COLD_OCEAN
				|| biomeIn == FROZEN_OCEAN;
	}





}
