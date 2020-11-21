package com.deedllit.midgard.world.feature.midgard.structures;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.apache.logging.log4j.Level;

import com.deedllit.midgard.Midgard;
import com.google.common.collect.Lists;
import com.mojang.datafixers.Dynamic;

import net.minecraft.entity.EntityType;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;


public class MangroveWitchHutStructure extends Structure<NoFeatureConfig>
{
	
	private static final List<Biome.SpawnListEntry> SPAWN_LIST = Lists.newArrayList(new Biome.SpawnListEntry(EntityType.WITCH, 1, 1, 1));
	private static final List<Biome.SpawnListEntry> CREATURE_SPAWN_LIST = Lists.newArrayList(new Biome.SpawnListEntry(EntityType.CAT, 1, 1, 1));

	
	public MangroveWitchHutStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
		super(config);
	}


	@Override
	protected ChunkPos getStartPositionForPosition(ChunkGenerator<?> chunkGenerator, Random random, int x, int z, int spacingOffsetsX, int spacingOffsetsZ) {
		int maxDistance = 12;
		int minDistance = 7;

		int xTemp = x + maxDistance * spacingOffsetsX;
		int ztemp = z + maxDistance * spacingOffsetsZ;
		int xTemp2 = xTemp < 0 ? xTemp - maxDistance + 1 : xTemp;
		int zTemp2 = ztemp < 0 ? ztemp - maxDistance + 1 : ztemp;
		int validChunkX = xTemp2 / maxDistance;
		int validChunkZ = zTemp2 / maxDistance;

		((SharedSeedRandom) random).setLargeFeatureSeedWithSalt(chunkGenerator.getSeed(), validChunkX, validChunkZ, this.getSeedModifier());
		validChunkX = validChunkX * maxDistance;
		validChunkZ = validChunkZ * maxDistance;
		validChunkX = validChunkX + random.nextInt(maxDistance - minDistance);
		validChunkZ = validChunkZ + random.nextInt(maxDistance - minDistance);

		return new ChunkPos(validChunkX, validChunkZ);
	}


	@Override
	public String getStructureName() {
		return Midgard.MOD_ID + ":mangrove_witch_hut";
	}


	@Override
	public int getSize() {
		return 0;
	}


	@Override
	public Structure.IStartFactory getStartFactory() {
		return MangroveWitchHutStructure.Start::new;
	}

	protected int getSeedModifier() {
		return 123456789;
	}
	

	public List<Biome.SpawnListEntry> getSpawnList() {
		return SPAWN_LIST;
	}
		   
	public List<Biome.SpawnListEntry> getCreatureSpawnList() {
		return CREATURE_SPAWN_LIST;
	}   
	
	@Override
	public boolean canBeGenerated(BiomeManager p_225558_1_, ChunkGenerator<?> chunkGen, Random rand, int chunkPosX, int chunkPosZ, Biome biome) {
		ChunkPos chunkpos = this.getStartPositionForPosition(chunkGen, rand, chunkPosX, chunkPosZ, 0, 0);

		if (chunkPosX == chunkpos.x && chunkPosZ == chunkpos.z) {
			if (chunkGen.hasStructure(biome, this)) {
				return true;
			}
		}

		return false;
	}

	public static class Start extends StructureStart {
		public Start(Structure<?> structureIn, int chunkX, int chunkZ, MutableBoundingBox mutableBoundingBox, int referenceIn, long seedIn) {
			super(structureIn, chunkX, chunkZ, mutableBoundingBox, referenceIn, seedIn);
		}


		@Override
		public void init(ChunkGenerator<?> generator, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome biomeIn) {
			Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];

			int x = (chunkX << 4) + 7;
			int z = (chunkZ << 4) + 7;

			int surfaceY = generator.getNoiseHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
			BlockPos blockpos = new BlockPos(x, surfaceY, z);

			MangroveWitchHutPieces.start(templateManagerIn, blockpos, rotation, this.components, this.rand);

			this.recalculateStructureSize();

			Midgard.LOGGER.log(Level.DEBUG, "Rundown House at " + (blockpos.getX()) + " " + blockpos.getY() + " " + (blockpos.getZ()));
		}

	}
}