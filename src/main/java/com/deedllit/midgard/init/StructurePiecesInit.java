package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.world.feature.midgard.structures.YggdrasilTreePieces;
import com.deedllit.midgard.world.feature.midgard.structures.YggdrasilTreeStructure;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;

public class StructurePiecesInit {


	public static final IStructurePieceType YGGDRASIL_TREE = YggdrasilTreePieces.YggdrasilTreePiece::new;
    
	public static void registerPieces() {
		YggdrasilTreePieces.register();
		
		register(YggdrasilTreeStructure.SHORT_NAME, YGGDRASIL_TREE);
		
	}
	
    private static void register(String key, IStructurePieceType type) {
        Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(Midgard.MOD_ID, key), type);
    }
	
}
