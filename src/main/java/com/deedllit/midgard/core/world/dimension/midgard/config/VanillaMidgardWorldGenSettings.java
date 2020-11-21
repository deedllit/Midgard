package com.deedllit.midgard.core.world.dimension.midgard.config;

import com.deedllit.mythologycraft.world.settings.MythologycraftOverworldGenSettings;


public class VanillaMidgardWorldGenSettings extends MythologycraftOverworldGenSettings {
	
    public enum LandMassScheme {
        VANILLA,
        CONTINENTS,
        ARCHIPELAGO
    }

    public enum TemperatureVariationScheme {
        LATITUDE,
        SMALL_ZONES,
        MEDIUM_ZONES,
        LARGE_ZONES,
        RANDOM
    }

    public enum RainfallVariationScheme {
        SMALL_ZONES,
        MEDIUM_ZONES,
        LARGE_ZONES,
        RANDOM
    }

    public enum BiomeSize {
        TINY (2),
        SMALL (3),
        MEDIUM (4),
        LARGE (5),
        HUGE (6);

        private final int value;

        BiomeSize(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum RiverSize {
        TINY (2),
        SMALL (3),
        MEDIUM (4),
        LARGE (5),
        HUGE (6);

        private final int value;

        RiverSize(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public int getBiomeSize() {
        return 4 ; 
    }

    public int getRiverSize() {
    	return 4 ; 
    }
	  
    public TemperatureVariationScheme getTempScheme() {
    	return TemperatureVariationScheme.MEDIUM_ZONES ; 
	}

    public RainfallVariationScheme getRainScheme() {
    	return RainfallVariationScheme.MEDIUM_ZONES ; 
	}
}
