package com.deedllit.midgard.init;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class FluidInit {

	public static final DeferredRegister<Fluid> FLUIDS = new DeferredRegister<Fluid>(ForgeRegistries.FLUIDS, Midgard.MOD_ID);

	public static final ResourceLocation ACIDIC_STILL_RL = new ResourceLocation(Midgard.MOD_ID, "blocks/acidic_still");
	public static final ResourceLocation ACIDIC_FLOWING_RL = new ResourceLocation(Midgard.MOD_ID,"blocks/acidic_flowing");
	public static final ResourceLocation ACIDIC_OVERLAY_RL = new ResourceLocation(Midgard.MOD_ID,"blocks/acidic_overlay");

	public static final RegistryObject<FlowingFluid> ACIDIC_FLUID = FLUIDS.register("acidic_fluid",
			() -> new ForgeFlowingFluid.Source(FluidInit.ACIDIC_PROPERTIES));

	public static final RegistryObject<FlowingFluid> ACIDIC_FLOWING = FLUIDS.register("acidic_flowing",
			() -> new ForgeFlowingFluid.Flowing(FluidInit.ACIDIC_PROPERTIES));

	public static final ForgeFlowingFluid.Properties ACIDIC_PROPERTIES = new ForgeFlowingFluid.Properties(
			() -> ACIDIC_FLUID.get(), () -> ACIDIC_FLOWING.get(),
			FluidAttributes.builder(ACIDIC_STILL_RL, ACIDIC_FLOWING_RL).density(5).luminosity(5).rarity(Rarity.RARE)
					.sound(SoundEvents.ITEM_HONEY_BOTTLE_DRINK).overlay(ACIDIC_OVERLAY_RL))
							.block(() -> FluidInit.ACIDIC_BLOCK.get()).bucket(() -> ItemInit.ACIDIC_BUCKET.get());

	public static final RegistryObject<FlowingFluidBlock> ACIDIC_BLOCK = BlockInit.BLOCKS.register("acidic",
			() -> new FlowingFluidBlock(() -> FluidInit.ACIDIC_FLUID.get(),
					Block.Properties.create(Material.WATER)
						.doesNotBlockMovement()
						.hardnessAndResistance(100.0f)
						.noDrops()));
	
	
	
	
	
}
