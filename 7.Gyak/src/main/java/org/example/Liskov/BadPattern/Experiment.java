package org.example.Liskov.BadPattern;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
    public static void main(String args[]){
        List<Integer> data = new Measurement().getData();
        System.out.println(new LaterAnalize().process(data));

    }
}
