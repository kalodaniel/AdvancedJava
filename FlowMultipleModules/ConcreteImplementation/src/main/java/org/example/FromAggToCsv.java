package org.example;

import org.example.exception.InputNotSetError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FromAggToCsv implements BaseFlow{

    private final List<Object> input = new ArrayList<>();
    private Object[] output;

    @Override
    public void setInput(Object[] object) {
        Collections.addAll(input, object);
    }

    @Override
    public Object[] getOutput() {
        return output;
    }

    @Override
    public void doIt() {
        if(input.isEmpty()){
            throw new InputNotSetError();
        }

        output = new Object[input.size()];

        for(int i = 0; i < input.size(); i++){
            output[i] = input.get(i);
        }
    }
}
