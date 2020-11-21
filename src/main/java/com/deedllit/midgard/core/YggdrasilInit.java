package com.deedllit.midgard.core;

import java.util.Calendar;

import com.deedllit.midgard.Midgard;

public class YggdrasilInit {

	public void init() {
		Calendar calendar = Calendar.getInstance();
        if (calendar.get(2) + 1 == 4 && calendar.get(5) == 1) { Midgard.isAprilFools = true; }  
	}
	
}
