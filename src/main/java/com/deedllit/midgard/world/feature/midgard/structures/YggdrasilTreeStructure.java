package com.deedllit.midgard.world.feature.midgard.structures;

import com.deedllit.mythologycraft.config.MCConfig;
import com.deedllit.mythologycraft.features.MCAbstractStructure;
import com.deedllit.mythologycraft.features.StructureUtils;
import com.mojang.datafixers.Dynamic;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.MarginedStructureStart;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.TemplateManager;

import javax.annotation.Nonnull;
import java.util.function.Function;

public class YggdrasilTreeStructure extends MCAbstractStructure { 
	
	public static final String SHORT_NAME = "yggdrasil_tree";
	
	public YggdrasilTreeStructure(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn) {
		super(configFactoryIn, SHORT_NAME);
	}

    @Override
    public int getSize() {
        return 3;
    }

	@Override
	protected double getSpawnChance() {
		return MCConfig.YGGDRASIL_TREE_SPAWN_CHANCE.get();
	}

	@Override
	protected int getFeatureDistance(ChunkGenerator<?> generator) {
		return MCConfig.YGGDRASIL_TREE_DISTANCE.get();
	}

	@Override
	protected int getFeatureSeparation(ChunkGenerator<?> generator) {
		return MCConfig.YGGDRASIL_TREE_SEPARATION.get();
	}

	@Override
	protected int getSeedModifier() {
		return 25078265 ; 
	}

	@Override
	public IStartFactory getStartFactory() {
		return Start::new;
	}
    
    public static class Start extends MarginedStructureStart {

        public Start(Structure<?> structure, int chunkX, int chunkZ, MutableBoundingBox bounds, int reference, long seed) {
            super(structure, chunkX, chunkZ, bounds, reference, seed);
        }

        @Override
        public void init(@Nonnull ChunkGenerator<?> generator, @Nonnull TemplateManager templateManager, int chunkX, int chunkZ, @Nonnull Biome biome) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            BlockPos position = StructureUtils.getSurfaceStructurePosition(generator, 3, rotation, chunkX, chunkZ);
            YggdrasilTreePieces.generate(generator, templateManager, position, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }
	
}

