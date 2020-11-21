package com.deedllit.mythologycraft.features;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.FlowersFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public abstract class MCDefaultFlowersFeatureNoConfig extends FlowersFeature<NoFeatureConfig>
{
    public MCDefaultFlowersFeatureNoConfig()
    {
        super(NoFeatureConfig::deserialize);
    }

    @Override
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand,
    		BlockPos pos, NoFeatureConfig config) {
    	
    	return true ; 
    	//return super.place(worldIn, generator, rand, pos, config);
    }
    
    
    /*
    @Override
    public int func_225560_a_(NoFeatureConfig p_225560_1_) {
        return 64;
    }
	*/
}
