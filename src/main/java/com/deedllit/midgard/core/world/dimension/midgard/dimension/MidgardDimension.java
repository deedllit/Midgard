package com.deedllit.midgard.core.world.dimension.midgard.dimension;

import javax.annotation.Nullable;

import com.deedllit.midgard.common.world.YggdrasilSurfaceDimension;
import com.deedllit.midgard.core.world.dimension.midgard.generator.MidgardBiomeProvider;
import com.deedllit.midgard.core.world.dimension.midgard.generator.MidgardGenSettings;

import net.minecraft.client.audio.MusicTicker.MusicType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.ChunkGeneratorType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class MidgardDimension extends YggdrasilSurfaceDimension {

	public static final BlockPos SPAWN = new BlockPos(100, 50, 0);
	private final float[] colorsSunriseSunset = new float[4];

	public MidgardDimension(World world, DimensionType type) {		
		super(world, type, 0.0f);
		this.doesWaterVaporize = false ; 
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {		
		long seed = this.world.getSeed();
				
		return ChunkGeneratorType.SURFACE.create(this.world, 
    		  new MidgardBiomeProvider(this.getWorld()), new MidgardGenSettings());
	}

	
	@Override
	public MusicType getMusicType() {		
		return super.getMusicType();
	}
	
	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
	      for(int i = chunkPosIn.getXStart(); i <= chunkPosIn.getXEnd(); ++i) {
	          for(int j = chunkPosIn.getZStart(); j <= chunkPosIn.getZEnd(); ++j) {
	             BlockPos blockpos = this.findSpawn(i, j, checkValid);
	             if (blockpos != null) {
	                return blockpos;
	             }
	          }
	       }

	       return null;
	}
	
	@Override
	public int getMoonPhase(long worldTime) {
		 return (int)(worldTime / 24000L % 8L + 8L) % 8;
	}
	
	 @Nullable
	 @OnlyIn(Dist.CLIENT)
	 public float[] calcSunriseSunsetColors(float celestialAngle, float partialTicks) {
		 float f = 0.4F;
		 float f1 = MathHelper.cos(celestialAngle * ((float)Math.PI * 2F)) - 0.0F;
		 float f2 = -0.0F;
		 if (f1 >= -0.4F && f1 <= 0.4F) {
			 float f3 = (f1 - -0.0F) / 0.4F * 0.5F + 0.5F;
			 float f4 = 1.0F - (1.0F - MathHelper.sin(f3 * (float)Math.PI)) * 0.99F;
			 f4 = f4 * f4;
			 this.colorsSunriseSunset[0] = f3 * 0.3F + 0.7F;
			 this.colorsSunriseSunset[1] = f3 * f3 * 0.7F + 0.2F;
			 this.colorsSunriseSunset[2] = f3 * f3 * 0.0F + 0.2F;
			 this.colorsSunriseSunset[3] = f4;
			 return this.colorsSunriseSunset;
		 } else {
			 return null;
		 }
	 }
	 
	@Override
	public boolean isSkyColored() {
		 return true ; 
	}
	
	
	@Override
	public boolean hasSkyLight() {
		return true ; 
	}
	 
		
	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {		
		double d0 = MathHelper.frac((double)worldTime / 24000.0D - 0.25D);
		double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
		return (float)(d0 * 2.0D + d1) / 3.0F;	
	}
	

	@Override
	@OnlyIn(Dist.CLIENT)
	public float getCloudHeight() {
		return 14.0F;
	}

	@Override
	public SleepResult canSleepAt(PlayerEntity player, BlockPos pos) {
		return SleepResult.ALLOW ; 
	}

	@Override
	public boolean canRespawnHere() {
		return true;
	}
    
	@Override
	public boolean isSurfaceWorld() {
		return true;
	}
	
	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		float f = MathHelper.cos(celestialAngle * ((float) Math.PI * 2F)) * 2.0F + 0.5F;
		f = MathHelper.clamp(f, 0.0F, 1.0F);
		float f1 = 0.7529412F;
		float f2 = 0.84705883F;
		float f3 = 1.0F;
		f1 = f1 * (f * 0.94F + 0.06F);
		f2 = f2 * (f * 0.94F + 0.06F);
		f3 = f3 * (f * 0.91F + 0.09F);
		return new Vec3d((double) f1, (double) f2, (double) f3);
		
	}
	
	@Override
    @OnlyIn(Dist.CLIENT)
	public boolean doesXZShowFog(int x, int z) {
		return false  ;
	}
		
	
	@Override
	public boolean canDoRainSnowIce(Chunk chunk) {
		return true;
	}
	
	@Override
	public boolean canDoLightning(Chunk chunk) {
		return true ; 
	}
	
	@Override
	public boolean isDaytime() {
		return true ; 
	}
	
	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		return super.findSpawn(posX, posZ, checkValid);
	}
	
	public BlockPos getSpawnCoordinate() {
		return SPAWN;
	}

}
