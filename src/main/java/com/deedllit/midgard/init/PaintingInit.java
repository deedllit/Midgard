package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class PaintingInit {
	public static final DeferredRegister<PaintingType> PAINTINGS = new DeferredRegister<PaintingType>(ForgeRegistries.PAINTING_TYPES, Midgard.MOD_ID);
	
	public static final RegistryObject<PaintingType> SURT_BY_DOLLMAN = PAINTINGS.register("surt_by_dollman", () -> new PaintingType(48,64));
	public static final RegistryObject<PaintingType> TREE_BY_ANKER = PAINTINGS.register("tree_of_year_by_anker", () -> new PaintingType(64,80));
}
