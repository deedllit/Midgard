package com.deedllit.mythologycraft.common.block;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.deedllit.mythologycraft.util.PlacementHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;

public class MythologycraftExtendableCorp extends CropsBlock implements IGrowable {

	public static final IntegerProperty AGE = BlockStateProperties.AGE_0_7;
	private Block topBlock ;
	private List<Block> canBePlacedOn ; 
	
	private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 6.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D), 
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D),
			Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D)};
	
	public MythologycraftExtendableCorp(Properties properties, List<Block> canBePlacedOn) {
		super(properties);		
		this.canBePlacedOn = canBePlacedOn ; 
	}
	
	public MythologycraftExtendableCorp(Properties properties, Block [] canBePlacedOn) {
		this(properties, Arrays.asList(canBePlacedOn));		
	}
	
	public void addAllowedBlock(Block allowedOn) {
		this.canBePlacedOn.add(allowedOn) ; 
	}
	
	public boolean hasTopBlock() {
		if( this.topBlock != null)
			return true ; 
		
		return false ; 
	}
	
	public Block getTopBlock() {
		return this.topBlock ; 
	}

	public List<Block> getPlacableOn() {
		return canBePlacedOn ; 
	}
		
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		return SHAPE_BY_AGE[state.get(this.getAgeProperty())];
	}

	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {

		return PlacementHelper.isInList(state, canBePlacedOn)  ; 
	}
}
