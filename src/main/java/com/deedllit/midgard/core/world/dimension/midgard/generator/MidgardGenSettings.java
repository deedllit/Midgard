package com.deedllit.midgard.core.world.dimension.midgard.generator;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.OverworldGenSettings;

public class MidgardGenSettings extends OverworldGenSettings{

	public MidgardGenSettings() {		
        this.defaultBlock = Blocks.STONE.getDefaultState();
        this.defaultFluid = Blocks.WATER.getDefaultState() ;    
	}
	
	public int getBiomeSize() {
		return 16;
	}

	public int getRiverSize() {
		return 2;
	}

	public int getBiomeId() {
		return -1;
	}

	@Override
	public int getBedrockFloorHeight() {
		return 0;
	}
		
}
