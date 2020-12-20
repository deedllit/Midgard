package com.deedllit.midgard;

import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.init.DimensionInit;
import com.deedllit.midgard.init.EntityInit;
import com.deedllit.midgard.init.FeatureInit;
import com.deedllit.midgard.init.FluidInit;
import com.deedllit.midgard.init.ItemInit;
import com.deedllit.midgard.init.ModEntityTypes;
import com.deedllit.midgard.init.PaintingInit;
import com.deedllit.midgard.init.SoundInit;
import com.deedllit.midgard.init.StructureInit;
import com.deedllit.midgard.init.SurfaceBuilderInit;
import com.deedllit.midgard.init.YggdrasilContainerTypes;
import com.deedllit.midgard.init.YggdrasilTileEntityTypes;
import com.deedllit.midgard.util.interfaces.IDoNotCreateItem;
import com.deedllit.mythologycraft.config.Config;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("midgard")
@Mod.EventBusSubscriber(modid = Midgard.MOD_ID, bus = Bus.MOD)
public class Midgard
{
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "midgard" ; 
    public static Midgard instance ; 
    public static boolean isAprilFools = false ; 
    	
	    
    public static final ResourceLocation MIDGARD_DIM_TYPE = new ResourceLocation(MOD_ID, "midgard") ;  
            
    
    public Midgard() {
    	final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus() ; 
    	
    	modEventBus.addListener(this::doClientStuff);
    	    	   	
    	Config.loadConfig(Config.CLIENT_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-client.toml").toString());
    	Config.loadConfig(Config.SERVER_CONFIG, FMLPaths.CONFIGDIR.get().resolve(MOD_ID + "-server.toml").toString());

    	SoundInit.SOUNDS.register(modEventBus);
    	ItemInit.ITEMS.register(modEventBus);
    	FluidInit.FLUIDS.register(modEventBus);
    	BlockInit.BLOCKS.register(modEventBus);
		YggdrasilTileEntityTypes.TILE_ENTITY_TYPES.register(modEventBus);
		YggdrasilContainerTypes.CONTAINER_TYPES.register(modEventBus);
		ModEntityTypes.ENTITY_TYPES.register(modEventBus);
		//FeatureInit.FEATURES.register(modEventBus);
		SurfaceBuilderInit.SURFACE_BUILDERS.register(modEventBus);
		StructureInit.STRUCTURES.register(modEventBus);
		EntityInit.ENTITY_TYPES.register(modEventBus);
		BiomeInit.BIOMES.register(modEventBus);
    	DimensionInit.MOD_DIMENSIONS.register(modEventBus);
    	PaintingInit.PAINTINGS.register(modEventBus);
    	    	
        instance = this ; 
        MinecraftForge.EVENT_BUS.register(this);
        
        this.modSetup() ;
        
    }
    

    public void modSetup() {
        BiomeInit.setup();     	
    }
    
	@SubscribeEvent
	public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
		final IForgeRegistry<Item> registry = event.getRegistry();
		
		BlockInit.BLOCKS.getEntries().stream()
		.filter(block -> 
			!(block.get() instanceof IDoNotCreateItem) && 
			!(block.get() instanceof FlowingFluidBlock))
		.map(RegistryObject::get).forEach(block -> {
			final Item.Properties properties = new Item.Properties().group(YggdrasilItemGroup.instance);
			final BlockItem blockItem = new BlockItem(block, properties);
			blockItem.setRegistryName(block.getRegistryName());
			registry.register(blockItem);
		});

	}
	
	
	
	@SubscribeEvent
	public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
		BiomeInit.registerBiomes();
	}
	
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{

		@SubscribeEvent
		public static void onRegisterFeatures(final RegistryEvent.Register<Feature<?>> event)
		{
			FeatureInit.registerFeatures(event);

			LOGGER.log(Level.INFO, "features/structures registered.");
		}
	}
	
	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey) {
		entry.setRegistryName(new ResourceLocation(Midgard.MOD_ID, registryKey));
		registry.register(entry);
		return entry;
	}
	


    private void doClientStuff(final FMLClientSetupEvent event) {
    }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
    	//OverworldAddFeatures.generateOre() ; 
    }
         
    public static class YggdrasilItemGroup extends ItemGroup {

    	public static final YggdrasilItemGroup instance = new YggdrasilItemGroup(ItemGroup.GROUPS.length, "YggdrasilItemGroup") ; 
    	
		private YggdrasilItemGroup(int index, String label) {
			super(index, label);
		}

		@Override
		public ItemStack createIcon() {
			return new ItemStack(BlockInit.SWEET_PEA.get());
		}
    	
    }
    
    
    

 }