package org.example.OpenClosed.goodPattern.framework;

public abstract class BaseFlow {
    public void step1(){

    }
    public abstract void step2();
    void run(){
        step1();
        step2();
    }

}
