package com.deedllit.midgard.common.fluid;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.interfaces.IYggdrasilReactiveFluid;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.IFluidState;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.Item;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidAttributes;

public class AcidicLiquid extends LavaFluid implements IYggdrasilReactiveFluid {

    public static final ResourceLocation STILL_TEXTURE = new ResourceLocation(Midgard.MOD_ID, "blocks/acidic_still");
    public static final ResourceLocation FLOW_TEXTURE = new ResourceLocation(Midgard.MOD_ID, "blocks/acidic_flowing");
    
    @Override
    public Fluid getFlowingFluid() {
        //return FluidInit.TOBEDONE;
    	return null ; 
    }

    @Override
    public Fluid getStillFluid() {
    	//return FluidInit.TOBEDONE;
    	return null ; 
    }

    @Override
    public Item getFilledBucket() {
    	//return FluidInit.TOBEDONE;
    	return null ; 
    }
    
	@Override
	public boolean reactWithLiquid(World world, BlockPos pos, BlockState state) {
		return false;
	}

    @Override
    protected FluidAttributes createAttributes() {
        return FluidAttributes.builder(STILL_TEXTURE, FLOW_TEXTURE)
                .density(3000)
                .viscosity(3000)
                .luminosity(15)
                .temperature(1000)
                .sound(SoundEvents.ITEM_BUCKET_FILL_LAVA, SoundEvents.ITEM_BUCKET_EMPTY_LAVA)
                .build(this);
    }
    
    public static class Source extends AcidicLiquid {
        @Override
        public int getLevel(IFluidState state) {
            return 8;
        }

        @Override
        public boolean isSource(IFluidState state) {
            return true;
        }
    }
	
    public static class Flowing extends AcidicLiquid {
        public Flowing() {
        }

        @Override
        protected void fillStateContainer(StateContainer.Builder<Fluid, IFluidState> container) {
            super.fillStateContainer(container);
            container.add(LEVEL_1_8);
        }

        @Override
        public int getLevel(IFluidState state) {
            return state.get(LEVEL_1_8);
        }

        @Override
        public boolean isSource(IFluidState state) {
            return false;
        }
    }

	@Override
	public boolean isSource(IFluidState state) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLevel(IFluidState p_207192_1_) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}
