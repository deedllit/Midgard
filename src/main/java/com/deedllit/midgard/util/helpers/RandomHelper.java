package com.deedllit.midgard.util.helpers;

import java.util.Random;

public class RandomHelper {

	public static int getNextIntBetween(Random rand, int number1, int number2) {
		if(number1 == number2) 
			return number1 ; 
		
		int min = number1 < number2 ? number1 : number2 ;
		int max = number1 > number2 ? number1 : number2 ;

		return min + rand.nextInt(1 + max - min) ;  		
	}
	
}
