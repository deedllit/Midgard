package com.deedllit.midgard.util.math;

import java.util.ArrayList;

import com.deedllit.midgard.Midgard;

import net.minecraft.util.math.BlockPos;

public class MidPointCircle {
		
	//https://rosettacode.org/wiki/Bitmap/Midpoint_circle_algorithm#Java
	
	public static ArrayList<BlockPos> DrawCircle2(BlockPos center, double radius) {	
		return MidPointCircle.DrawOval(center, radius * 2,  radius * 2) ; 
	}
	
	public static ArrayList<BlockPos> DrawOval(BlockPos center, double height, double width ) {
		ArrayList<BlockPos> array = new ArrayList<BlockPos>() ;
		
		return array ; 
	}
	
	public static ArrayList<BlockPos> DrawCircle4(BlockPos center, int radius) {
		ArrayList<BlockPos> array = new ArrayList<BlockPos>() ;
		
		double i ;
		double angle ;
		double x1 ; 
		double z1 ; 
		int centerX = center.getX() ;
		int centerZ = center.getZ() ; 

		int x2 ;
		int z2 ; 
		
		for(i = 0 ; i < 360 ; i+= 0.1) {
			angle = i ;
			x1 = radius * Math.cos(angle * Math.PI / 180) ; 
			z1 = radius * Math.sin(angle * Math.PI / 180) ; 
						
			x2 = (int) (centerX + Math.floor(x1)) ; 
			z2 = (int) (centerZ + Math.floor(z1)) ; 

			Midgard.LOGGER.info("X:" + x2 + " z:" + z2) ;
			
			array.add( center.add(x2, 0, z2)) ;
		}
		
		return array ; 		
	}

	public static void DrawCircle(BlockPos center, ArrayList<BlockPos> array, int r) {
		
		//https://fr.wikipedia.org/wiki/Algorithme_de_trac%C3%A9_de_cercle_d%27Andres
		
		int centerX = center.getX() ;
		int centerZ = center.getZ() ; 
		
	    int x = 0;
	    int y = r;
	    int d = r - 1;
	    
	    while(y >= x) {
	    	
			array.add( center.add(x, 0,  y)) ;
			array.add( center.add(x, 0, -y)) ;
			array.add( center.add(-x, 0, y)) ;
			array.add( center.add(-x, 0, -y)) ;
			
			array.add( center.add( y, 0, x)) ;
			array.add( center.add( y, 0, -x)) ;
			array.add( center.add( -y, 0, x)) ;
			array.add( center.add( -y, 0, -x)) ;
			
	    	
	        if (d >= 2*x)
	        {
	            d -= 2*x + 1;
	            x ++;
	        }
	        else if (d < 2 * (r-y))
	        {
	            d += 2*y - 1;
	            y --;
	        }
	        else
	        {
	            d += 2*(y - x - 1);
	            y --;
	            x ++;
	        }
	    }
	    
	}

	public static ArrayList<BlockPos> DrawCircle99(BlockPos center, int radius) {
		ArrayList<BlockPos> array = new ArrayList<BlockPos>() ;
		
		int centerX = center.getX() ;
		int centerZ = center.getZ() ; 
		
		int y = radius ; 
		int p = 3 - (2*radius) ; 
		
		array.add( center.add(centerX + 0, 0, centerZ - y)) ;
		Midgard.LOGGER.info(" x : " + (centerX + 0) + " z : " + (centerZ - y)) ;

		for(int x = 0 ; x <= y ; x++) {
			
			if(p < 0) {
				p = p+(4*x)+6 ;
			}
			else {
				y -= 1 ; 
				p += 4*(x-y)+10 ; 
			}
			
			
			Midgard.LOGGER.info(" x : " + (centerX + x) + " z : " + (centerZ + y)) ;
			Midgard.LOGGER.info(" x : " + (centerX + x) + " z : " + (centerZ - y)) ;
			Midgard.LOGGER.info(" x : " + (centerX - x) + " z : " + (centerZ + y)) ;
			Midgard.LOGGER.info(" x : " + (centerX - x) + " z : " + (centerZ - y)) ;
			
			Midgard.LOGGER.info(" x : " + (centerX + y) + " z : " + (centerZ + x)) ;
			Midgard.LOGGER.info(" x : " + (centerX + y) + " z : " + (centerZ - x)) ;
			Midgard.LOGGER.info(" x : " + (centerX - y) + " z : " + (centerZ + x)) ;
			Midgard.LOGGER.info(" x : " + (centerX - y) + " z : " + (centerZ - x)) ;

			
			array.add( center.add(centerX + x, 0, centerZ + y)) ;
			array.add( center.add(centerX + x, 0, centerZ - y)) ;
			array.add( center.add(centerX - x, 0, centerZ + y)) ;
			array.add( center.add(centerX - x, 0, centerZ - y)) ;
			
			array.add( center.add(centerX + y, 0, centerZ + x)) ;
			array.add( center.add(centerX + y, 0, centerZ - x)) ;
			array.add( center.add(centerX - y, 0, centerZ + x)) ;
			array.add( center.add(centerX - y, 0, centerZ - x)) ;
			 
			
			
		}
		
	
		return array ; 
	}

	public static ArrayList<BlockPos> DrawCircle3(BlockPos center, int radius) {
		ArrayList<BlockPos> array = new ArrayList<BlockPos>() ;
		
		double d = 5 - radius * 4 ;
		double x = 0 ;
		double y = radius ; 
		
		
		int centerX = center.getX() ;
		int centerZ = center.getZ() ; 
		
		do {
			
			array.add( center.add(centerX + x, 0, centerZ + y)) ;
			array.add( center.add(centerX + x, 0, centerZ - y)) ;
			array.add( center.add(centerX - x, 0, centerZ + y)) ;
			array.add( center.add(centerX - x, 0, centerZ - y)) ;
			
			array.add( center.add(centerX + y, 0, centerZ + x)) ;
			array.add( center.add(centerX + y, 0, centerZ - x)) ;
			array.add( center.add(centerX - y, 0, centerZ + x)) ;
			array.add( center.add(centerX - y, 0, centerZ - x)) ;
			
			
			if(d < 0)
				d += 2 * x + 1 ;
			else {
				d += 2 * (x-y) + 1 ;
				y-- ;
			}
			
			
			
			
		} while( x <= y) ;
	
		return array ; 
		
	}
	
}
