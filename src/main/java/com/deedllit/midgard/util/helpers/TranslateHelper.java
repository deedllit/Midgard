package com.deedllit.midgard.util.helpers;

import net.minecraft.client.resources.I18n;

public class TranslateHelper {
	
	public static String getTranslate(String tag) {		
		try {
			return I18n.format(tag) ; 
		}
		catch (Exception e) {
			return "Can't load translation of " + tag ; 
		}
	}

	public static boolean isNotEmpty(String tag) {
		return !isEmpty(tag) ; 
	}
	
	public static boolean isEmpty(String tag) {
		if(hasTranslation(tag)) 
			return getTranslate(tag).isEmpty() ;
		
		return true ; 
	}
	
	public static boolean hasTranslation(String tag) {
		try {
			I18n.format(tag) ; 
			return true ; 
		}
		catch (Exception e) {
			return false ; 
		}
	}
	
}
