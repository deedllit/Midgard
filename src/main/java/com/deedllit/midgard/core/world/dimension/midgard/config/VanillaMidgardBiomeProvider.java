package com.deedllit.midgard.core.world.dimension.midgard.config;

import java.util.Set;

import com.deedllit.midgard.init.BiomeInit;
import com.google.common.collect.Sets;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.OverworldBiomeProvider;
import net.minecraft.world.biome.provider.OverworldBiomeProviderSettings;
import net.minecraft.world.gen.layer.Layer;
import net.minecraft.world.gen.layer.LayerUtil;

public class VanillaMidgardBiomeProvider extends OverworldBiomeProvider {
	
	protected final Set<Biome> biomes;
	private final Layer genBiomes;
	
	public VanillaMidgardBiomeProvider(OverworldBiomeProviderSettings settingsProvider) {
		super(settingsProvider);

		//this.biomes = Sets.newHashSet(super.biomes) ;
		this.biomes = Sets.newHashSet() ; 
		this.biomes.addAll(BiomeInit.setMidgard) ; 

		this.genBiomes = LayerUtil.func_227474_a_(settingsProvider.getSeed(), settingsProvider.getWorldType(), settingsProvider.getGeneratorSettings());
	}
		
	@Override
	public Biome getNoiseBiome(int x, int y, int z) {
		return super.getNoiseBiome(x, y, z);
	}

	@Override
	public Set<BlockState> getSurfaceBlocks() {
		
		if (this.topBlocksCache.isEmpty()) {
			
			for(Biome b : this.biomes ) {
				this.topBlocksCache.add(b.getSurfaceBuilderConfig().getTop()) ; 
			}
		}
		
		return this.topBlocksCache;
	}
	

}
