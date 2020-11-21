package com.deedllit.midgard.common.world;

import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class YggdrasilSurfaceDimension extends YggdrasilDimension {

	
	public YggdrasilSurfaceDimension(World worldIn, DimensionType dimensionType, float p_i225788_3_) {
		super(worldIn, dimensionType, p_i225788_3_);
	    this.nether = false;
	}
		   
	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isSkyColored() {
		return true;
	}
	
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}


	
}
