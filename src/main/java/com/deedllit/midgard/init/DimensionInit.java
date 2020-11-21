package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.world.dimension.midgard.dimension.MidgardModDimension;

import net.minecraftforge.common.ModDimension;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class DimensionInit {
	
	//also register in ForgeEventBusSubscriber
	
	public static final DeferredRegister<ModDimension> MOD_DIMENSIONS = new DeferredRegister<>(ForgeRegistries.MOD_DIMENSIONS, Midgard.MOD_ID);
	
	public static final RegistryObject<ModDimension> MIDGARD = MOD_DIMENSIONS.register("midgard", () -> new MidgardModDimension());
	
}
