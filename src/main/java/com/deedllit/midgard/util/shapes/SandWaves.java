package com.deedllit.midgard.util.shapes;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;

public class SandWaves {

	private double [][] flat = new double[16][16] ; 
	private double [][] line = new double[16][16] ; 
	private double [][] reverse = new double[16][16] ; 
	
	public SandWaves() {

		Midgard.LOGGER.info("INIT SANDWAVES");
		
		PrecomputedMath preComputed = new PrecomputedMath() ; 

		for(int i = 0 ; i < 16 ; i++) {
			for(int j = 0 ; j < 16 ; j++) {
				flat[i][j] = 0.2 ;
				line[i][j] = preComputed.getSin(i);
			}
		}
		
		reverse = rotateClockWise(line) ;  

	}
	
	private double[][] rotateClockWise(double[][] matrix) {
		 int size = matrix.length;
		 double[][] ret = new double[size][size];

		 for (int i = 0; i < size; ++i) 
		  for (int j = 0; j < size; ++j) 
		   ret[i][j] = matrix[size - j - 1][i]; //***

		 return ret;
		}
	
	private int safePos(int i) {
		int newI = i & 15 ; 

		if(newI < 0) {
			newI = 16 - newI ; 
		}
		
		return newI ; 
	}
	
	public double getFlat(int x, int z) {
		return flat[x][z] ;
	}
	
	public double getNorthSouthWaveHeight(int x, int z) {
		return line[x][z] ; 
	}

	public double getEastWestWaveHeight(int x, int z) {
		return reverse[x][z] ; 
	}
	
	
	
}
