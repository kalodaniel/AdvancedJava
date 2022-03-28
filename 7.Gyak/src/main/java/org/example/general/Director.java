package org.example.general;

import org.example.general.Worker;

public class Director {

    private final Worker worker;
    public Director(Worker worker){
        this.worker = worker;
    }

    public void doIt(int value){
        if(value>1){
            this.worker.test();
        }
    }
}
