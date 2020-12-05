package com.deedllit.midgard.util.helpers;

import java.util.Collection;

import net.minecraft.block.BlockState;
import net.minecraft.state.IProperty;
import net.minecraft.util.datafix.fixes.ChunkPaletteFormat.Direction;

public class BlockHelper {

	//Return axis property of a block if allowed
	public static IProperty getAxisProperty(BlockState block) {
		for (IProperty property : block.getProperties()) {
			Collection allowedValues = property.getAllowedValues();
			if(allowedValues.contains(Direction.Axis.X) && allowedValues.contains(Direction.Axis.Y) && allowedValues.contains(Direction.Axis.Z)) {
				return property ; 
			}
		}
		
		return null ; 
	}
	
}
