package org.example.Liskov.BadPattern;

import java.util.ArrayList;
import java.util.List;

public class Experiment {
    public static void main(String args[]){
        List<Integer> data = new Measurement().getData();
        run(new Analize(),data);

    }

    public static void run(Analize analize, List<Integer> data){
        System.out.println(analize.process(data));
    }
}
