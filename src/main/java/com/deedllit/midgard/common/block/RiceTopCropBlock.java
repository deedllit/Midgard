package com.deedllit.midgard.common.block;

import java.util.Random;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.init.BlockInit;
import com.deedllit.mythologycraft.common.block.MidgardAirTopCropsBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.IPlantable;

public class RiceTopCropBlock extends MidgardAirTopCropsBlock {

	public RiceTopCropBlock(Properties builder) {
		super(builder.notSolid());
	}
	
	@Override
	public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		return true ; 
	}

	@Override
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		return true ; 		
	}
	
	@Override
	public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing,
			IPlantable plantable) {
		return super.canSustainPlant(state, world, pos, facing, plantable);
	}
	
	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {		
		//Not max age
		if( !this.isMaxAge(state) ) {
			return true ; 			
		}
		    	
    	return false ; 
	}	
	
	
	@Override
	public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {
	
		super.onBlockExploded(state, world, pos, explosion);
	}
	
		
	@Override
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {

		super.tick(state, worldIn, pos, rand);
		if (!worldIn.isAreaLoaded(pos, 1))
			return; // Forge: prevent loading unloaded chunks when checking neighbor's light
		
		if (worldIn.getLightSubtracted(pos, 0) >= 9) {

			boolean doTick = false;
			float f = getGrowthChance(this, worldIn, pos);
					
			
			if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,
					rand.nextInt((int) (25.0F / f) + 1) == 0)) {
				doTick = true;
			}

			int i = this.getAge(state);
			
			if (i < this.getMaxAge() && doTick) {
				
				worldIn.setBlockState(pos, this.withAge(i + 1), 2);
				net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);					
			}
		} 
		
	}
	

	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		
		BlockPos pos = context.getPos() ; 

		if(context.getWorld().getBlockState(pos.down()).getBlock() == BlockInit.MIDGARD_RICE_BOTTOM_CROP.get()) {
			return super.getStateForPlacement(context); 
			
		}
		
		return null ; 
		
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		Midgard.LOGGER.info("Boom");
		super.onBlockHarvested(worldIn, pos, state, player);
	}
	
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		int d = 0 ; 
		
		if(this.getAge(state) != this.getMaxAge()) {
			int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
			int j = this.getMaxAge();			
			if (i > j) {
				d = j - i ;
				i = j;
			}
			
			worldIn.setBlockState(pos, this.withAge(i), 2);			
		}
		
	
	}
	
}
