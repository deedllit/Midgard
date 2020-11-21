package com.deedllit.midgard.init.objects.blocks;

import java.util.stream.Stream;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class PortalShirneBlock extends Block {

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING ; 
	
	public static final VoxelShape SHAPE_NS = Stream.of(
			Block.makeCuboidShape(7, 0, 5, 9, 3, 11),
			Block.makeCuboidShape(6, 3, 2, 10, 4, 13),
			Block.makeCuboidShape(6, 4, 12, 10, 12, 13),
			Block.makeCuboidShape(6, 4, 2, 10, 12, 3)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public static final VoxelShape SHAPE_EW = Stream.of(
			Block.makeCuboidShape(4, 0, 6, 10, 3, 8),
			Block.makeCuboidShape(1, 3, 5, 12, 4, 9),
			Block.makeCuboidShape(11, 4, 5, 12, 12, 9),
			Block.makeCuboidShape(1, 4, 5, 2, 12, 9)).reduce((v1, v2) -> {
				return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();
	
	public PortalShirneBlock(Properties properties) {
		super(properties);
		this.setDefaultState(this.stateContainer.getBaseState().with(FACING ,Direction.NORTH));
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return this.getDefaultState().with(FACING,  context.getPlacementHorizontalFacing().getOpposite()) ; 
	}
	
	@Override
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		switch(state.get(FACING)) {
		case NORTH:
		case SOUTH:
			return SHAPE_NS ;
		case EAST:
		case WEST:
			return SHAPE_EW ;
		default:
			return SHAPE_NS ; 			
		}
	}
	
	
	@Override
	public BlockState rotate(BlockState state, Rotation rot) {
		return state.with(FACING, rot.rotate(state.get(FACING)));
	}
	
	@Override
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.toRotation(state.get(FACING)));
	}


	@Override
	protected void fillStateContainer(Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	
	@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player,
			Hand handIn, BlockRayTraceResult result) {

		return ActionResultType.SUCCESS;
	}
	
	
	
}
