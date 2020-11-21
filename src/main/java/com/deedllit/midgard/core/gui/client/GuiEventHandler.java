package com.deedllit.midgard.core.gui.client;

import com.deedllit.midgard.Midgard;

import net.minecraft.client.gui.screen.CreateWorldScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Midgard.MOD_ID, bus = Bus.MOD)
public class GuiEventHandler {

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onPreInitCreateWorld(GuiScreenEvent.InitGuiEvent.Pre event) {
        Screen screenGui = event.getGui();

        if (screenGui instanceof CreateWorldScreen) {
            CreateWorldScreen createWorldGui = (CreateWorldScreen)screenGui;            
                        
            Midgard.LOGGER.info("CreateWorldScreen") ; 
            
        }
    }	
	
}
