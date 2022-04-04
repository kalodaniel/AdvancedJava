package org.example.OpenClosed.goodPattern.framework;

import org.example.OpenClosed.goodPattern.framework.user.Flow2;

public class BaseRunner {
    public static void main(String args[]){
       run(new Flow2());
    }

    private static void run(BaseFlow base){
        base.run();
    }
}
