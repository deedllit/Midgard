package com.deedllit.mythologycraft.world.biome;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.deedllit.midgard.api.enums.MidgardClimate;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;

public class MythologycraftBiome extends Biome {

	public boolean canSpawnInBiome;
	protected Map<MidgardClimate, Integer> weightMap = new HashMap<MidgardClimate, Integer>();
	public int beachBiomeId = -1 ;
	public int riverBiomeId = -1 ;

	public MythologycraftBiome(Builder biomeBuilder) {
		super(biomeBuilder);
		this.canSpawnInBiome = true;	
	}
	
    public void addWeight(MidgardClimate climate, int weight) {
        this.weightMap.put(climate, weight);
    }

    public void setBeachBiome(Optional<Biome> biome) {
        if (biome.isPresent())
            this.beachBiomeId = Registry.BIOME.getId(biome.get());
        else
            this.beachBiomeId = -1;
    }
	
    public void setBeachBiome(Biome biome) {
        if (biome != null)
            this.beachBiomeId = Registry.BIOME.getId(biome);
        else
            this.beachBiomeId = -1;
    }

    public void setRiverBiome(Optional<Biome> biome) {
        if (biome.isPresent())
            this.riverBiomeId = Registry.BIOME.getId(biome.get());
        else
            this.riverBiomeId = -1;
    }

    public void setRiverBiome(Biome biome) {
        if (biome != null)
            this.riverBiomeId = Registry.BIOME.getId(biome);
        else
            this.riverBiomeId = -1;
    }
 
    public Map<MidgardClimate, Integer> getWeightMap() {
        return this.weightMap;
    }
    
    public boolean hasWeights() {
        return !this.weightMap.isEmpty() && !this.weightMap.entrySet().stream().allMatch((entry) -> entry.getValue().equals(0));
    }
    
}
