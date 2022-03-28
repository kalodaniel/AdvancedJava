package org.example.Liskov.BadPattern;

import java.security.InvalidParameterException;
import java.util.List;

public class LaterAnalize extends Analize {
    public Double process(List<Integer> data){
        assertNotNullOrNotEmptyData(data);
        assertNotZeroData(data);
        Double sum = 0.0;

        for (Integer item:data) {
            sum += item;
        }
        return sum / data.size();
    }

    protected void assertNotZeroData(List<Integer> data){
        for (Integer item : data){
            if(item < 0){
                throw new InvalidParameterException("measurement cannot be negative");
            }
        }
    }
}
