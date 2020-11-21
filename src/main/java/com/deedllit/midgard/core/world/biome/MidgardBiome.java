package com.deedllit.midgard.core.world.biome;

import com.deedllit.midgard.init.BiomeInit;
import com.deedllit.mythologycraft.world.biome.MythologycraftBiome;

import net.minecraft.world.biome.Biome;

public class MidgardBiome extends MythologycraftBiome {

	
	protected MidgardBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		//this.setRiverBiome(BiomeInit.VANILLA_RIVER_BIOME.get());
		//this.setBeachBiome(BiomeInit.VANILLA_BEACH_BIOME.get());
	}


	
	
	@Override
	public Biome getRiver() {
		if (this == BiomeInit.VANILLA_SNOWY_TUNDRA_BIOME.get())
			return BiomeInit.VANILLA_FROZEN_RIVER_BIOME.get();
		if (this == BiomeInit.VANILLA_MUSHROOM_FIELDS_BIOME.get()
				|| this == BiomeInit.VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get())
			return BiomeInit.VANILLA_MUSHROOM_FIELD_SHORE_BIOME.get();

		return BiomeInit.VANILLA_RIVER_BIOME.get();
	}

}
