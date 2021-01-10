package com.deedllit.midgard.util.math;

public class PrecomputedMath {

	private double preCos[] = new double[16] ; 
	private double preSin[] = new double[16] ; 
	private double cosValue = 0.2125 ;
	private double sinValue = 0.1875 ; 
	
	public PrecomputedMath(double cosV, double sinV) {
		this.cosValue = cosV ;
		this.sinValue = sinV ; 
		computed() ; 
	}

	
	public PrecomputedMath() {
		computed() ; 
	}
	
	private void computed() {
		for(int i = 0 ; i < 16 ; i++) {
			preCos[i] = Math.cos( i * cosValue ) ; 
			preSin[i] = Math.sin( i * sinValue ) ; 
		}
	}

	public double getCos(int n) {
		return preCos[n] ; 
	}
	
	public double getSin(int n) {
		return preSin[n] ; 
	}

}
