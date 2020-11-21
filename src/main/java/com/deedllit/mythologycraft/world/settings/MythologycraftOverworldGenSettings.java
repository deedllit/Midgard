package com.deedllit.mythologycraft.world.settings;

import net.minecraft.world.gen.OverworldGenSettings;

public class MythologycraftOverworldGenSettings extends OverworldGenSettings {
	
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

    @Override
    public int getBiomeSize() {
        return 4 ; 
    }

    @Override
    public int getRiverSize() {
    	return 4 ; 
    }
	  
}
