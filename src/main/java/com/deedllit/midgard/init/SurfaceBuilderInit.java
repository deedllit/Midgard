package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.world.gen.surfacebuilders.*;

import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SurfaceBuilderInit {
	
	public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS =  new DeferredRegister<>(ForgeRegistries.SURFACE_BUILDERS,  Midgard.MOD_ID) ; 	

	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE = new MangroveSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_BORDER = new MangroveBorderSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> MANGROVE_MIX = new MangroveMixedSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> CHAPARRAL = new ChaparralSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FYNBOS = new FynbosSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> SNOWTOP = new SnowTopSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> TROPICAL = new TropicalWhiteSandSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> RAINBOW = new RaibowsMoutainSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> HOLES = new HolesSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> WHITE_SAND_ISLAND = new WhiteSandIsland(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> BLACK_SAND_ISLAND = new BlackSandIsland(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FLOATING_ISLAND_EXTREME_MOUTAIN = new FloatingIslandExtremeMountainSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FLOATING_ISLAND_MOUTAIN = new FloatingIslandMountainSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> FLOATING_ISLAND_HILL = new FloatingIslandHillSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> ACIDIC_DEFAULT_SURFACE_BUILDER = new AciduricDefaultSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> RICE_FIELD = new RiceFieldSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> DUNE = new DuneSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> SAND_WAVE = new SandWaveSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> GINDELWALD = new GrindelwaldSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> BOHOL = new BoholSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	public static final SurfaceBuilder<SurfaceBuilderConfig> AMAZONIA = new AmazoniaSurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
	
	
	//public static final SurfaceBuilder<SurfaceBuilderConfig> SPOOKY = new SpookySurfaceBuilder(SurfaceBuilderConfig::deserialize);
	
}
