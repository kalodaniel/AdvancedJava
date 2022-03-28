package org.example.general;

import org.example.general.Worker;

// dependency IV
public class WeakUsage extends Worker {
    // dependency I
    Worker worker;

    // not good solution (stiff code)
    WeakUsage(){
        this.worker = new Worker();
    }

    // dependency II (weaker than I)
    public void hello(Worker worker){

    }

    // dependency III
    public void other(){
        Worker worker = new Worker();
    }


}
