package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.common.entities.passive.CamelEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {

	public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = new DeferredRegister<>(ForgeRegistries.ENTITIES,	Midgard.MOD_ID);
	
	public static final RegistryObject<EntityType<CamelEntity>> CAMEL_ENTITY = ENTITY_TYPES
			.register("camel_entity",
					() -> EntityType.Builder.<CamelEntity>create(CamelEntity::new, EntityClassification.CREATURE)
							.size(1.2f, 1.5f)
							.build(new ResourceLocation(Midgard.MOD_ID, "camel_entity").toString()));
	
}
