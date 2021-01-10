package com.deedllit.midgard.util.shapes;

import com.deedllit.midgard.Midgard;
import com.deedllit.midgard.util.math.PrecomputedMath;

public class SandWaves2 {

	private double [][] line = new double[16][16] ; 
	private double [][] cornerSE = new double[16][16] ; 
	private double [][] cornerNE = new double[16][16] ; 
	private double [][] cornerNW = new double[16][16] ; 
	private double [][] cornerSW = new double[16][16] ; 
	private double [][] pyramid = new double[16][16] ; 
	
	public SandWaves2() {

		Midgard.LOGGER.info("INIT SANDWAVES");
		
		PrecomputedMath preComputed = new PrecomputedMath() ; 

		for(int i = 0 ; i < 16 ; i++) {
			for(int j = 0 ; j < 16 ; j++) {
				line[i][j] = preComputed.getSin(i);
				pyramid[i][j] = preComputed.getSin(Math.min(i, j)) ;
				cornerSE[i][j] = preComputed.getSin(Math.min(i, j)) ;
			}
		}

		for(int i = 0 ; i < 8 ; i++) {
			for(int j = 0 ; j < 8 ; j++) {
				cornerSE[i][j] = Math.max(pyramid[i][j], line[i][j]) ; 
			}
		}
		
		cornerNE = rotateClockWise(cornerSE) ;
		cornerNW = rotateClockWise(cornerNE) ;
		cornerSW = rotateClockWise(cornerNW) ;
				
	}
	
	private double[][] rotateClockWise(double[][] matrix) {
		 int size = matrix.length;
		 double[][] ret = new double[size][size];

		 for (int i = 0; i < size; ++i) 
		  for (int j = 0; j < size; ++j) 
		   ret[i][j] = matrix[size - j - 1][i]; //***

		 return ret;
		}
	
	public double getPyramid(int x, int z) {
		return pyramid[x][z] ; 
	}
	
	public double getNorthSouthWaveHeight(int x, int z) {
		return line[x][z] ; 
	}

	public double getEastWestWaveHeight(int x, int z) {
		double[][] reverse = rotateClockWise(line) ; 
		return reverse[x][z] ; 
	}
	
	public double getCornerSouthEastWaveHeight(int x, int z) {
		return cornerSE[x][z] ; 
	}
	
	public double getCornerNorthEastWaveHeight(int x, int z) {
		return cornerNE[x][z] ; 
	}
	
	public double getCornerNorthWestWaveHeight(int x, int z) {
		return cornerNW[x][z] ; 
	}

	public double getCornerSouthWestWaveHeight(int x, int z) {
		return cornerSW[x][z] ; 
	}
	
	
}
