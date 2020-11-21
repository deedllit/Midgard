package com.deedllit.midgard.common.objects.blocks;

import java.util.Random;

import com.deedllit.midgard.init.BlockInit;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

public class FruityLeavesBlock extends LeavesBlock implements IGrowable {
 
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_2;
 
    public FruityLeavesBlock(Properties properties) {
        super(properties);
        //this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
        this.setDefaultState(this.stateContainer.getBaseState().with(DISTANCE, 7).with(PERSISTENT, false).with(AGE, 1));
        
    }
 
    /*
    protected void fillStateContainer(Builder<Block, BlockState> builder) {
        builder.add(DISTANCE, PERSISTENT, AGE);
    }
    */
    
    /*
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
    */
    
    @Override
    /**
     * Performs a random tick on a block.
     */
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (!state.get(PERSISTENT) && state.get(DISTANCE) == 2) {
            if (worldIn instanceof ServerWorld) {
                // 10% chance of a sapling dropping
                if (random.nextInt(10) == 0) {
                    //ItemStack saplings = new ItemStack(BlockInit.MUSPELHEIM_EPLUPHIFER_SAPLING.get(), 1);
                    //spawnAsEntity(worldIn, pos, saplings);
                }
            }
            worldIn.removeBlock(pos, false);
        }
    }
 
    @Override
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.tick(state, worldIn, pos, rand);
        if (!worldIn.isAreaLoaded(pos, 1)) {
            return; // Forge: prevent loading unloaded chunks when checking neighbor's light
        }
        if (worldIn.getLightSubtracted(pos, 0) >= 9) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) 
                if (rand.nextInt(1000) == 0) 
                    worldIn.setBlockState(pos, this.withAge(i + 1), 2); 
        }
 
    }
 
    public IntegerProperty getAgeProperty() {
        return AGE;
    }
 
    public int getMaxAge() {
        return 2;
    }
 
    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }
 
    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
    }
 
    public boolean isMaxAge(BlockState state) {
        return state.get(this.getAgeProperty()) >= this.getMaxAge();
    }

	@Override
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		return false ;
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		// TODO Auto-generated method stub
		
	}
}