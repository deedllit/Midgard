package com.deedllit.midgard.test;

import com.deedllit.midgard.Midgard;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid=Midgard.MOD_ID)
public class ModBusEvents {
	
	
	@SubscribeEvent
	public static void registerFeatures(RegistryEvent.Register<Feature<?>> args) {
	
		/*
		Yggdrasil.LOGGER.info("DEBUG : registerFeatures start");
		
		Yggdrasil.BRICK_HOUSE_PIECE = Registry.register(Registry.STRUCTURE_PIECE, Yggdrasil.HOUSE_LOC, BrickHousePiece.Piece::new);
		 
		args.getRegistry().register(new BrickHouse(NoFeatureConfig::deserialize).setRegistryName(Yggdrasil.HOUSE_LOC));

		Yggdrasil.LOGGER.info("DEBUG : registerFeatures done");
		*/
	}

}
