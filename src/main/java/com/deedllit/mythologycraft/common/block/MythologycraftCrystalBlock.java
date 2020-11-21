package com.deedllit.mythologycraft.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class MythologycraftCrystalBlock extends Block {
	
    private static final VoxelShape VOXEL_SHAPE = Block.makeCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);
	
	public MythologycraftCrystalBlock(Properties properties) {
		super(properties);
	}

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return VOXEL_SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return VoxelShapes.empty();
    }
    
    @Override
    public boolean propagatesSkylightDown(BlockState state, IBlockReader world, BlockPos pos) {
        return true;
    }
    
    @Override
    public Block.OffsetType getOffsetType() {
        return Block.OffsetType.XZ;
    }
 
    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1.0F;
    }

    
}
