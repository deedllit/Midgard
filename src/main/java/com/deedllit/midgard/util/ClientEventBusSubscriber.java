package com.deedllit.midgard.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import javax.annotation.Nullable;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.client.gui.PedestalItemScreen;
import com.deedllit.midgard.common.client.tileentity.render.PedestalItemRenderer;
import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.init.SoundInit;
import com.deedllit.midgard.init.YggdrasilContainerTypes;
import com.deedllit.midgard.init.YggdrasilTileEntityTypes;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.biome.Biome;

@Mod.EventBusSubscriber(modid = Midgard.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
	
	
    private static ISound playingMusic;
    private static final Minecraft CLIENT = Minecraft.getInstance();

            
    
    
    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

    	Midgard.LOGGER.info("ON CLIENT TICK") ; 
    	
    }
    
    @SubscribeEvent
    public static void onRenderFog(EntityViewRenderEvent.RenderFogEvent event) {
    	Midgard.LOGGER.info("ON RENDER FOG") ;     	
    }
   
    @SubscribeEvent
    public static void onSetupFogDensity(EntityViewRenderEvent.RenderFogEvent.FogDensity event) {
    	Midgard.LOGGER.info("ON SETUP FORGE DENSITY") ;     	
    }
    
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onSetupFogColor(EntityViewRenderEvent.FogColors event) {
    	Midgard.LOGGER.info("ON SETUP FOG COLOR") ;     	
    }
    
    @SubscribeEvent
    public static void onPlaySound(PlaySoundEvent event) {
    
    	Midgard.LOGGER.info("ON PLAY SOUND") ; 
    	
    	
    	if (CLIENT.player != null) {
    		
    		SoundEvent sound = getMusicSound(CLIENT.player);
    		if (sound == null) {
    	    	Midgard.LOGGER.info("ON PLAY SOUND - NULL") ; 
                event.setResultSound(null);
                return;
            }    		
    		
	    	Midgard.LOGGER.info("ON PLAY SOUND - PLAYING") ; 
            playingMusic = SimpleSound.music(sound);
            event.setResultSound(playingMusic);    		
    	}
    	
    	
    }

    @Nullable
    public static SoundEvent getMusicSound(PlayerEntity player) {
        Biome biome = player.world.getBiome(player.getPosition());
                
        return SoundInit.LAZY_GRUNDAR_MUSIC.get() ;    
    }

	
	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event) {
		
				
		RenderType basicRender =  RenderType.getCutout();

		
		/*
		 * MIDGARD
		 */
		RenderTypeLookup.setRenderLayer(BlockInit.CHARDON.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_PINK_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_WHITE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_ORANGE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_BLUE_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_TEAL_POMELIA_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.IXIA_VIRIDIFLORA_TEAL_BUSH.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_RED.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.GUZMANIA_PINK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.FISH_HOOK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.SWEET_PEA.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.DESERT_GRASS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_CALLUNA.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PINK_BISTORT.get(), basicRender);		
		
		RenderTypeLookup.setRenderLayer(BlockInit.KANGAROO_PAW_ORANGE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.KANGAROO_PAW_PINK.get(), basicRender);		

		RenderTypeLookup.setRenderLayer(BlockInit.FUCHSIA_BISTORT.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.EDELWEISS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HIBICUS_TREE_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PALM_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_SPRUCE_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.BLUE_SPRUCE_SAPLING.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.NORWAY_SPRUCE_LEAVES.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.RED_SUNFLOWER.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_SUNFLOWER.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.COPPER_BARS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.LEAD_BARS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.WHITE_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.YELLOW_WOLFS_BANE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.PURPLE_SEA_HORSE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_RICE_BOTTOM_CROP.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_RICE_TOP_CROP.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.ALPINE_BETONY.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.FIRELILY.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.LAVENDER.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HAWORTHIA_HAWORTHIOPSIS.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_BLUE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_ORANGE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_PINK.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_RED.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_WHITE.get(), basicRender);		
		RenderTypeLookup.setRenderLayer(BlockInit.HYACINTH_YELLOW.get(), basicRender);		
		
		RenderTypeLookup.setRenderLayer(BlockInit.SULFUR_CRYSTAL.get(), basicRender);		

		//RenderTypeLookup.setRenderLayer(BlockInit.PISTIA_WATER_LETTUCE.get(), basicRender);		
		//RenderTypeLookup.setRenderLayer(BlockInit.MIDGARD_RICE_TOP_CROP.get(), basicRender);		


		/*
		 * COMMON 
		 */		
		
		ScreenManager.registerFactory(YggdrasilContainerTypes.ITEM_PEDESTAL.get(), PedestalItemScreen::new);

		ClientRegistry.bindTileEntityRenderer(YggdrasilTileEntityTypes.ITEM_PEDESTAL.get(), PedestalItemRenderer::new);
		
		
	}
	
}
