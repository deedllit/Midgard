package com.deedllit.midgard.common.objects.items;

import java.util.List;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.helpers.TranslateHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class RuneItem extends Item {

	private String desc ; 	
		
	public RuneItem(String desc, Properties properties) {
		super(properties);
		this.desc = desc ;
	}
	
	
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {		

		String pathDesc = "desc." + Midgard.MOD_ID + "." + this.desc; 
			
		tooltip.add(new TranslationTextComponent( pathDesc ).applyTextStyle(TextFormatting.YELLOW)) ;
		if(TranslateHelper.isNotEmpty(pathDesc + "_buff")) {
			tooltip.add(new StringTextComponent("Buff:")) ; 
			tooltip.add(new TranslationTextComponent( pathDesc + "_buff").applyTextStyle(TextFormatting.DARK_GREEN)) ;			
		}
		if(TranslateHelper.isNotEmpty(pathDesc + "_debuff")) {
			tooltip.add(new StringTextComponent("Debuff:")) ; 
			tooltip.add(new TranslationTextComponent( pathDesc + "_debuff").applyTextStyle(TextFormatting.DARK_RED)) ;
		}
		
		if(TranslateHelper.isNotEmpty(pathDesc + "_link")) {
			String link = TranslateHelper.getTranslate( pathDesc + "_link") ; 
			if(TranslateHelper.isNotEmpty(link)) {
				tooltip.add(new StringTextComponent("Link with:")) ; 
				tooltip.add(new TranslationTextComponent( link ).applyTextStyle(TextFormatting.LIGHT_PURPLE)) ;				
			}
		}
	
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}

}
