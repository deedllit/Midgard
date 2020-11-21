package com.deedllit.midgard.init;

import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.Midgard.YggdrasilItemGroup;
import com.deedllit.mythologycraft.common.items.MythologycraftDiscItem;


public class ItemInit {

	
	public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,  Midgard.MOD_ID) ; 	
	
	//FLUID
	public static final RegistryObject<Item> ACIDIC_BUCKET = ITEMS.register("acidic_bucket",
			() -> new BucketItem(FluidInit.ACIDIC_FLUID, new Item.Properties().group(YggdrasilItemGroup.instance).maxStackSize(1)));
	
	
	//Disc
	public static final RegistryObject<MythologycraftDiscItem> GRUNDAR_DISC = ITEMS.register("disc_grundar",
			() -> new MythologycraftDiscItem(5, SoundInit.LAZY_GRUNDAR_MUSIC.get(),
					new Item.Properties().group(YggdrasilItemGroup.instance).maxStackSize(1).rarity(Rarity.RARE)));
	
}
