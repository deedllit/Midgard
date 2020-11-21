package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.container.PedestalItemContainer;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class YggdrasilContainerTypes {

	public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = new DeferredRegister<>(
			ForgeRegistries.CONTAINERS, Midgard.MOD_ID);
	
	public static final RegistryObject<ContainerType<PedestalItemContainer>> ITEM_PEDESTAL = CONTAINER_TYPES
			.register("pedestal_item", () -> IForgeContainerType.create(PedestalItemContainer::new));
	
}
