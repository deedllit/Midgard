package com.deedllit.midgard.common.enums;

import net.minecraftforge.common.BiomeManager.BiomeType;

public enum YggdrasilClimates {
	
	NIFELHEIM (BiomeType.ICY),
	NETHER (null);
	
	public final BiomeType biomeType;
	
	YggdrasilClimates(BiomeType biomeType)
    {
        this.biomeType = biomeType;
    }
	
}
