package com.deedllit.midgard.common.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;

public class YggdrasilDimension extends Dimension {

	protected GenerationSettings settings;
	
	public YggdrasilDimension(World p_i225788_1_, DimensionType p_i225788_2_, float p_i225788_3_) {
		super(p_i225788_1_, p_i225788_2_, p_i225788_3_);
	}

	public void setSettings(GenerationSettings settings) {
		this.settings = settings  ;
	}
	
	@Override
	public ChunkGenerator<?> createChunkGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos findSpawn(ChunkPos chunkPosIn, boolean checkValid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPos findSpawn(int posX, int posZ, boolean checkValid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateCelestialAngle(long worldTime, float partialTicks) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSurfaceWorld() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vec3d getFogColor(float celestialAngle, float partialTicks) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canRespawnHere() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doesXZShowFog(int x, int z) {
		// TODO Auto-generated method stub
		return false;
	}

}
