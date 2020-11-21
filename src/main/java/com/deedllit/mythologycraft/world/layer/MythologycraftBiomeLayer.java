package com.deedllit.mythologycraft.world.layer;

//import com.deedllit.mythologycraft.world.biome.ModBiomes;
import com.deedllit.mythologycraft.world.biome.MythologycraftClimates;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.layer.traits.IAreaTransformer2;
import net.minecraft.world.gen.layer.traits.IDimOffset0Transformer;
import net.minecraftforge.common.BiomeManager;

public enum MythologycraftBiomeLayer implements IAreaTransformer2, IDimOffset0Transformer {

    INSTANCE;

    private static final int DEEP_OCEAN = Registry.BIOME.getId(Biomes.DEEP_OCEAN);
    private static final int MUSHROOM_FIELDS = Registry.BIOME.getId(Biomes.MUSHROOM_FIELDS);

	@Override
	public int getOffsetX(int x) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOffsetZ(int z) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int apply(INoiseRandom context, IArea area1, IArea area2, int x, int z) {
        int landSeaVal = area1.getValue(x, z);
        int climateVal = area2.getValue(x, z);

        MythologycraftClimates climate;
        try {
            climate = MythologycraftClimates.lookup(climateVal);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            String msg = "Climate lookup failed climateOrdinal: " + climateVal;
            throw new RuntimeException(msg,e);
        }

        if (landSeaVal == DEEP_OCEAN) {
            return Registry.BIOME.getId(climate.getRandomOceanBiome(context, true));
        } else if (landSeaVal == 0) {
        //else if ((landSeaVal == MUSHROOM_FIELDS || ModBiomes.islandBiomeIds.contains(landSeaVal)) && climate.biomeType != BiomeManager.BiomeType.ICY) {
            return landSeaVal;
        } else if (landSeaVal == 0) {
            return Registry.BIOME.getId(climate.getRandomOceanBiome(context, false));
        }
        else {
        	return Registry.BIOME.getId(climate.getRandomBiome(context, Biomes.OCEAN));
        }
	}
    
}
