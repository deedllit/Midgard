package com.deedllit.midgard.util.interfaces;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface IYggdrasilReactiveFluid {

    boolean reactWithLiquid(World world, BlockPos pos, BlockState state);

	
}
