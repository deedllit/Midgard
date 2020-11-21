package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.GameData;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class RegUtil {

    public static <T extends IForgeRegistryEntry<T>> Generic<T> generic(IForgeRegistry<T> registry) {
        return new Generic<>(registry);
    }

	public static <T extends IForgeRegistryEntry<T>> T register(IForgeRegistry<T> registry, T entry, String registryKey)
	{
		entry.setRegistryName(new ResourceLocation(Midgard.MOD_ID, registryKey));
		registry.register(entry);
		return entry;
	}
    
    public static class Generic<T extends IForgeRegistryEntry<T>> {
        private final IForgeRegistry<T> registry;

        private Generic(IForgeRegistry<T> registry) {
            this.registry = registry;
        }

        public Generic<T> add(String name, T entry) {
            ResourceLocation registryName = GameData.checkPrefix(name, false);
            entry.setRegistryName(registryName);

            this.registry.register(entry);

            return this;
        }
    }
	
}
