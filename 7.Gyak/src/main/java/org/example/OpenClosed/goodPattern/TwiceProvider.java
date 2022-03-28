package org.example.OpenClosed.goodPattern;

public class TwiceProvider implements ValueProvider{
    public int get(int value){
        return value *= 2;
    }
}
