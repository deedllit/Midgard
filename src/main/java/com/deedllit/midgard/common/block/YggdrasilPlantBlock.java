package com.deedllit.midgard.common.block;

import java.util.Random;

import com.deedllit.midgard.init.BlockInit;
import com.deedllit.midgard.util.interfaces.IYggdrasilPlantable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.util.Direction;

public class YggdrasilPlantBlock extends BushBlock implements IGrowable, IYggdrasilPlantable {
	
    private static final VoxelShape SHAPE = Block.makeCuboidShape(2d, 0d, 2d, 14d, 13d, 14d);
    private int flammability ; 
    private int fireSpreadSpeed ; 
    
	protected YggdrasilPlantBlock(Properties properties) {
		super(properties);
		
		this.flammability = 100 ;
		this.fireSpreadSpeed = 60 ;
		
		
	}
	

	
	public void cantBurn() {
		this.flammability = 0 ;		
	}
	
	public void setFlammability(int flammability) {
		this.flammability = flammability ; 
	}

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false;
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		
	}
	
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
	
    @Override
    public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return this.fireSpreadSpeed;
    }

    @Override
    public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return this.flammability;
    }

}
