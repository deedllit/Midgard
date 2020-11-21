package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.objects.tileentities.PedestalItemTileEntity;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YggdrasilTileEntityTypes {

	public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = new DeferredRegister<>(
			ForgeRegistries.TILE_ENTITIES, Midgard.MOD_ID);
	
	public static final RegistryObject<TileEntityType<PedestalItemTileEntity>> ITEM_PEDESTAL = TILE_ENTITY_TYPES
			.register("pedestal_item", () -> TileEntityType.Builder
					.create(PedestalItemTileEntity::new, BlockInit.PEDESTAL_ITEM.get()).build(null));
	
}
