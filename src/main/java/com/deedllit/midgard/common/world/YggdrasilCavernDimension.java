package com.deedllit.midgard.common.world;

import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class YggdrasilCavernDimension extends YggdrasilDimension {

	public YggdrasilCavernDimension(World worldIn, DimensionType dimensionType, float p_i225788_3_) {
		super(worldIn, dimensionType, p_i225788_3_);
	    this.nether = true;
	}

}
