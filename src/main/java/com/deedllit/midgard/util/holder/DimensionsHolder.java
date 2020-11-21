package com.deedllit.midgard.util.holder;

import java.util.HashMap;
import java.util.Map;

import com.deedllit.midgard.init.DimensionInit;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;


public class DimensionsHolder {

	private String modId ;
	public Map<String, ResourceLocation> ressources = new HashMap<>();
	public Map<String, ModDimension> modDim = new HashMap<>();
			
	public DimensionsHolder(String modId) {
		this.modId = modId ;
	}
	
	public void addDimension(String name, ModDimension dim) {
		ressources.put(name, new ResourceLocation(this.modId, name)) ; 
	}
	
	public ResourceLocation getResourceLocation(String name) {
		return ressources.get(name) ;
	}
	
	public void doRegister() {
				
		/*
		for (String key: ressources.keySet()) {
			
			if (DimensionType.byName(ressources.get(key)) == null) 
				DimensionManager.registerDimension(ressources.get(key), DimensionInit.MUSPELHEIM.get(), null, true);

			
		}
		*/
		
	}
	
	
    //public static final ResourceLocation YGGDRASIL_DIM_TYPE = new ResourceLocation(MOD_ID, "muspelheim") ;  

	
	
}
