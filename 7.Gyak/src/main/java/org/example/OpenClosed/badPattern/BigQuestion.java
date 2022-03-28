package org.example.OpenClosed.badPattern;

public class BigQuestion {
    public static final int lowerNegativeZone = -50;
    public static final int lowerNegativeZoneUpValue = -2;
    public static final int lowerNegativeZoneDownValue = -2;
    public int get(int value) {
        int rv;

        if(value<0){
            rv = getForNegative(value);
        } else {
            rv = getForPositive(value);
        }

        return rv;
    }

    private int getForNegative(int value){

        if(value < lowerNegativeZone){
            return lowerNegativeZoneUpValue;
        }
        return lowerNegativeZoneDownValue;
    }

    private int getForPositive(int value){
        int rv;
        boolean odd = value % 2 == 0;
        if (value > 35) {
            if(value == 100){
                rv = (int) Math.floor(Math.sqrt(value));
            }else {
                rv = value;
            }
        }else {
            rv = 0;
        }

        if(odd){
            rv = value*2;
        }

        return rv;
    }
}
