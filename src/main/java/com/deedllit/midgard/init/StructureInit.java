package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.world.feature.midgard.structures.YggdrasilTreeStructure;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class StructureInit {
		
	public static final DeferredRegister<Feature<?>> STRUCTURES = new DeferredRegister<>(ForgeRegistries.FEATURES, Midgard.MOD_ID);	
	
    @ObjectHolder(Midgard.MOD_ID + ":yggdrasil_tree_structure")
    public static final Structure<NoFeatureConfig> YGGDRASIL_TREE_STRUCTURE = registerStructure(new YggdrasilTreeStructure(NoFeatureConfig::deserialize), "yggdrasil_tree_structure");

        
    private static <T extends IFeatureConfig> Structure<T> registerStructure(Structure<T> structure, String registryName) {
        structure.setRegistryName(Midgard.MOD_ID, registryName);

        STRUCTURES.register(registryName, () -> new YggdrasilTreeStructure(NoFeatureConfig::deserialize));
        return structure;
    }
    
    
}