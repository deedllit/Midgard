package com.deedllit.mythologycraft.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class MCConfig {

	
	public static ForgeConfigSpec.IntValue FLATNESS_DELTA;
	
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_WORLD ;
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_ALFHEIM_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_ASGARD_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_HELHEIM_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_JOTUNHEIM_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_MUSPELHEIM_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_NIFELHEIM_DIMENSION  ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_SVARTALFHEIM_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue YGGDRASIL_VANAHEIM_DIMENSION  ;  

	public static ForgeConfigSpec.BooleanValue  DUNE_WORLD ;  
	public static ForgeConfigSpec.BooleanValue  DUNE_ARRAKIS_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue  DUNE_CALADAN_DIMENSION ;   
	public static ForgeConfigSpec.BooleanValue  DUNE_GIEDI_PRIME_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue  DUNE_SALUSA_SECUNDUS_DIMENSION ;  
	public static ForgeConfigSpec.BooleanValue  DUNE_IX_DIMENSION  ;  

    public static ForgeConfigSpec.DoubleValue YGGDRASIL_TREE_SPAWN_CHANCE;
    public static ForgeConfigSpec.IntValue YGGDRASIL_TREE_DISTANCE;
    public static ForgeConfigSpec.IntValue YGGDRASIL_TREE_SEPARATION;

	
	
	public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        
		SERVER_BUILDER.comment("Structure Generation Config");
		
        FLATNESS_DELTA = SERVER_BUILDER.comment("How flat does terrain need to be for surface structures to spawn? (in blocks) [default: 3]").defineInRange("structures.global.flatness_delta", 3, 0, 64);
     
        YGGDRASIL_WORLD = SERVER_BUILDER.comment("Load Yggdrasil World?").define("world.yggdrasil", true);
        YGGDRASIL_ALFHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Alfheim dimension?").define("activate.alfheim.dimension", true);       
        YGGDRASIL_ASGARD_DIMENSION = SERVER_BUILDER.comment("Activate Asgard dimension?").define("activate.asgard.dimension", true);
        YGGDRASIL_HELHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Helheim dimension?").define("activate.helheim.dimension", true);
        YGGDRASIL_JOTUNHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Jotunheim dimension?").define("activate.jotunheim.dimension", true);
        YGGDRASIL_MUSPELHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Muspelheim dimension?").define("activate.muspelheim.dimension", true);
        YGGDRASIL_NIFELHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Nifelheim dimension?").define("activate.nifelheim.dimension", true);
        YGGDRASIL_SVARTALFHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Svartalheim dimension?").define("activate.svartalfheim.dimension", true);
        YGGDRASIL_VANAHEIM_DIMENSION = SERVER_BUILDER.comment("Activate Vanaheim dimension?").define("activate.vanaheim.dimension", true);
        
        DUNE_WORLD = SERVER_BUILDER.comment("Load Dune World?").define("world.dune", false);
        DUNE_ARRAKIS_DIMENSION = SERVER_BUILDER.comment("Activate Arrakis dimension?").define("activate.arrakis.dimension", true);
        DUNE_CALADAN_DIMENSION = SERVER_BUILDER.comment("Activate Caladan dimension?").define("activate.caladan.dimension", true);
        DUNE_GIEDI_PRIME_DIMENSION = SERVER_BUILDER.comment("Activate Giedi Prime dimension?").define("activate.giedi_prime.dimension", true);
        DUNE_SALUSA_SECUNDUS_DIMENSION = SERVER_BUILDER.comment("Activate Salusa Secundus dimension?").define("activate.salusa_secundus.dimension", true);
        DUNE_IX_DIMENSION = SERVER_BUILDER.comment("Activate Ix dimension?").define("activate.ix.dimension", true);
        
        YGGDRASIL_TREE_SPAWN_CHANCE = SERVER_BUILDER.comment("Yggdrasil Tree Spawn Chance [default: 0.5]").defineInRange("structures.yggdrasil.yggdrasil_tree.spawn_chance",0.5, 0.0, 1.0);
        YGGDRASIL_TREE_DISTANCE = SERVER_BUILDER.comment("Yggdrasil Tree Distance (in chunks) [default: 30]").defineInRange("structures.yggdrasil.yggdrasil_tree.distance", 30, 1, 500);
        YGGDRASIL_TREE_SEPARATION = SERVER_BUILDER.comment("Yggdrasil Tree Minimum Separation (in chunks) [default: 8]").defineInRange("structures.yggdrasil.yggdrasil_tree.separation", 8, 1, 500);        
	}
	
}
