package com.deedllit.midgard.world.gen.worldtype;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.world.dimension.midgard.config.ChunkGeneratorOverworldVanillaMidgard;
import com.deedllit.midgard.core.world.dimension.midgard.config.VanillaMidgardWorldGenSettings;
import com.deedllit.midgard.core.world.dimension.midgard.generator.MidgardBiomeProvider;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;

public class WorldTypeMidgard extends WorldType {

	public WorldTypeMidgard() {
		super("midgard");
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator(World world) {
		
		
		if (world.getDimension().getType() == DimensionType.OVERWORLD) {
			Midgard.LOGGER.info("=========== VanillaMidgard createChunkGenerator ===========") ;

			VanillaMidgardWorldGenSettings genSettings = new VanillaMidgardWorldGenSettings();
			OverworldBiomeProviderSettings biomeProviderSettings = new OverworldBiomeProviderSettings(world.getWorldInfo());
			biomeProviderSettings.setGeneratorSettings(genSettings) ; 
			
			return new ChunkGeneratorOverworldVanillaMidgard(world, new MidgardBiomeProvider(world), genSettings) ; 		
			
		}
		
		return super.createChunkGenerator(world);
	}
	
	/*
	 * Use config file instead
	 */
	@Override
	public boolean hasCustomOptions() {
		return false ; 
	}

}
