package com.deedllit.midgard.world.feature.midgard.structures;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.StructurePiecesInit;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.jigsaw.JigsawManager;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPiece;
import net.minecraft.world.gen.feature.jigsaw.SingleJigsawPiece;
import net.minecraft.world.gen.feature.structure.AbstractVillagePiece;
import net.minecraft.world.gen.feature.structure.StructurePiece;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.List;

public class YggdrasilTreePieces {

    public static void register() {
        JigsawManager.REGISTRY.register(new JigsawPattern(new ResourceLocation(Midgard.MOD_ID, "castles"), 
        		new ResourceLocation("yggdrasil_tree"), ImmutableList.of(Pair.of(new SingleJigsawPiece(Midgard.MOD_ID + ":yggdrasil_tree"), 1)), 
        		JigsawPattern.PlacementBehaviour.RIGID));
    }

    public static void generate(ChunkGenerator generator, TemplateManager templateManager, BlockPos position, List<StructurePiece> pieces, SharedSeedRandom random) {
        JigsawManager.addPieces(new ResourceLocation(Midgard.MOD_ID, "castles"), 7, YggdrasilTreePiece::new, generator, templateManager, position, pieces, random);
    }

    public static class YggdrasilTreePiece extends AbstractVillagePiece {
        public YggdrasilTreePiece(TemplateManager templateManager, JigsawPiece jigsawPiece, BlockPos position, int groundLevelDelta, Rotation rotation, MutableBoundingBox bounds) {
            super(StructurePiecesInit.YGGDRASIL_TREE, templateManager, jigsawPiece, position, groundLevelDelta, rotation, bounds);
        }

        public YggdrasilTreePiece(TemplateManager templateManager, CompoundNBT compoundNBT) {
            super(templateManager, compoundNBT, StructurePiecesInit.YGGDRASIL_TREE);
        }
    }
}
