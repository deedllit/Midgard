package com.deedllit.midgard.util;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.DimensionInit;

import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Midgard.MOD_ID, bus = Bus.FORGE)
public class ForgeEventBusSubscriber {

	@SubscribeEvent
	public static void registerDimensions(final RegisterDimensionsEvent event) {
				
		if (DimensionType.byName(Midgard.MIDGARD_DIM_TYPE) == null) {
			DimensionManager.registerDimension(Midgard.MIDGARD_DIM_TYPE, DimensionInit.MIDGARD.get(), null, true);
		}

	}
}