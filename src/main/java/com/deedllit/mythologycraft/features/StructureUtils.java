package com.deedllit.mythologycraft.features;

import net.minecraft.util.Direction;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;

import javax.annotation.Nonnull;
import java.util.Random;

/*
 * Strongly inspirated by Valhelsia Structures : https://github.com/ValhelsiaTeam/Valhelsia-Structures
 */


public class StructureUtils {

	
    public static Direction getRandomDir(final Random rand) {
        return Direction.byHorizontalIndex(rand.nextInt(4));
    }

    public static int getLowestHeight(IWorld world, int x, int z, int xSize, int zSize) {
        int h0 = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, x, z);
        int h1 = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, x + xSize, z);
        int h2 = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, x, z + zSize);
        int h3 = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, x + xSize, z + zSize);
        return Math.min(Math.min(h0, h1), Math.min(h2, h3));
    }

    public static BlockPos getSurfaceStructurePosition(@Nonnull ChunkGenerator<?> generator, int size, Rotation rotation, int chunkX, int chunkZ) {
        int xOffset = size * 16;
        int zOffset = size * 16;

        int x = (chunkX << 4);
        int z = (chunkZ << 4);

        int i1 = generator.getNoiseHeight(x, z, Heightmap.Type.WORLD_SURFACE_WG);
        int j1 = generator.getNoiseHeight(x, z + zOffset, Heightmap.Type.WORLD_SURFACE_WG);
        int k1 = generator.getNoiseHeight(x + xOffset, z, Heightmap.Type.WORLD_SURFACE_WG);
        int l1 = generator.getNoiseHeight(x + xOffset, z + zOffset, Heightmap.Type.WORLD_SURFACE_WG);
        int minHeight = Math.min(Math.min(i1, j1), Math.min(k1, l1));

        return new BlockPos(x + (xOffset / 2), minHeight - 2, z + (zOffset / 2));
    }
}