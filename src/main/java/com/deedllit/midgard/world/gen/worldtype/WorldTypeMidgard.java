package com.deedllit.midgard.world.gen.worldtype;

import java.util.function.LongFunction;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.core.world.dimension.midgard.config.ChunkGeneratorOverworldVanillaMidgard;
import com.deedllit.midgard.core.world.dimension.midgard.config.VanillaMidgardWorldGenSettings;
import com.deedllit.midgard.core.world.dimension.midgard.generator.MidgardBiomeProvider;
import com.deedllit.midgard.core.world.dimension.midgard.generator.layer.MidgardAddBambooForestLayer;
import com.deedllit.midgard.core.world.dimension.midgard.generator.layer.MidgardEdgeLayer;
import com.deedllit.midgard.core.world.dimension.midgard.generator.layer.MidgardLayerUtil;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.OverworldGenSettings;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.AddBambooForestLayer;
import net.minecraft.world.gen.layer.BiomeLayer;
import net.minecraft.world.gen.layer.EdgeBiomeLayer;
import net.minecraft.world.gen.layer.LayerUtil;
import net.minecraft.world.gen.layer.ZoomLayer;

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
