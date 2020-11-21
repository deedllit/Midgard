package com.deedllit.midgard.common.objects.items;

import com.deedllit.midgard.Midgard;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PhilosopherWardItem extends Item {

	public PhilosopherWardItem(Properties properties) {
		super(properties);
	}

	@Override
	public ActionResultType onItemUse(ItemUseContext context) {
		
		
		World worldIn = context.getWorld() ; 
		PlayerEntity playerIn = context.getPlayer() ; 
		Hand handIn = context.getHand() ; 
		
		BlockPos blockPos = context.getPos() ; 
		BlockState blockState = worldIn.getBlockState( blockPos) ; 
		
		if(blockState.getBlock() != Blocks.COAL_ORE)
	        return super.onItemUse(context);
		
		
		int r = worldIn.getRandom().nextInt(20)  ; 
		int dmg ; 
		
		if(r < 2) {
			worldIn.setBlockState(blockPos, Blocks.GOLD_ORE.getDefaultState()) ;
			dmg = worldIn.getRandom().nextInt(2) ; 
		} else if(r < 4) {
			worldIn.setBlockState(blockPos, Blocks.DIAMOND_ORE.getDefaultState()) ;
			dmg = worldIn.getRandom().nextInt(2) ; 
		} else if(r < 6) {
			worldIn.setBlockState(blockPos, Blocks.EMERALD_ORE.getDefaultState()) ;
			dmg = worldIn.getRandom().nextInt(2) ; 
		} else if (r < 12) {
			worldIn.setBlockState(blockPos, Blocks.STONE.getDefaultState()) ; 			
			dmg = worldIn.getRandom().nextInt(2) + 1 ; 
		} else {			
			worldIn.setBlockState(blockPos, Blocks.DIRT.getDefaultState()) ; 			
			dmg = worldIn.getRandom().nextInt(3) + 1 ; 
		}
		
        if (!worldIn.isRemote) {
    	    ItemStack itemstack = playerIn.getHeldItem(handIn);
            itemstack.damageItem(dmg, playerIn, (p_220000_1_) -> {
               p_220000_1_.sendBreakAnimation(handIn);
            });
         }			
		
		
        return super.onItemUse(context);
	}
	
	
	public int getItemEnchantability() {
		return 1;
	}

}
