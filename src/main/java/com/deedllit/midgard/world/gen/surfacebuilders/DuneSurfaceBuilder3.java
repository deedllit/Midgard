package com.deedllit.midgard.world.gen.surfacebuilders;

import java.util.Random;
import java.util.function.Function;

import com.deedllit.midgard.Midgard;
import com.mojang.datafixers.Dynamic;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class DuneSurfaceBuilder3 extends SurfaceBuilder<SurfaceBuilderConfig>  {

	private PerlinNoiseGenerator perlinNoise = null ; 
	
	public DuneSurfaceBuilder3(Function<Dynamic<?>, ? extends SurfaceBuilderConfig> configFactory) {
		super(configFactory);
	}

	@Override
	public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise,
			BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		
		int i = x & 15;
		int j = z & 15;
		
		
		double vertical = chunkIn.getHeightmap(Heightmap.Type.OCEAN_FLOOR_WG).getHeight(i, j);
		double smooth = MathHelper.clamp((vertical - seaLevel) * 0.125D, 0, 1);
		double height ; 
		
	    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        blockpos$mutable.setPos(i, startHeight, j);

		if(this.perlinNoise == null) {
	        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
	        this.perlinNoise = new PerlinNoiseGenerator(sharedseedrandom, 3, 0);		
		}
				
		
        blockpos$mutable.setPos(i, startHeight, j);
        
        //Make sure we reach surface
        if(chunkIn.getBlockState(blockpos$mutable).isAir()) {
            while(chunkIn.getBlockState(blockpos$mutable).isAir()) {
    			blockpos$mutable.move(Direction.DOWN) ;         	
            }        	
        } else {
            while(!chunkIn.getBlockState(blockpos$mutable).isAir()) {
    			blockpos$mutable.move(Direction.UP) ;         	
            }        	        	
        }
        
        

        
		double h1 = this.perlinNoise.noiseAt((double)x * 0.00953125D, (double)z * 0.001553125D, false) * 30 * smooth;
        double h2 = this.perlinNoise.noiseAt((double)x * 0.02953125D + 5, (double)z * 0.004553125D + 5, false) * 35 + 8;
        

		height = Math.max(h1, h2);      
				
		for(int h = 0 ; h < height + 7 ; h++) {	
			chunkIn.setBlockState(blockpos$mutable, config.getTop(), false);
			blockpos$mutable.move(Direction.UP) ; 
		}  
		
        
        
	}

	
	
}
