package com.deedllit.midgard.util.interfaces;

import net.minecraft.util.math.MathHelper;

public interface IYggdrasilNoisable {

    double get(double x, double y);
    double get(double x, double y, double z);

    void setAmplitude(double amplitude);
    void setFrequency(double frequency);

    default double maintainPrecision(double coordinate) {
        long origin = MathHelper.lfloor(coordinate);
        double intermediate = coordinate - (double) origin;
        return intermediate + (origin % 16777216L);
    }
	
}
