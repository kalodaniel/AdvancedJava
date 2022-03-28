package org.example.general;

import org.example.general.impl.Worker;

public class HardWorker extends org.example.general.Worker implements Worker {

    @Override
    public void test() {
        System.out.println("HardWorker");
    }
}
