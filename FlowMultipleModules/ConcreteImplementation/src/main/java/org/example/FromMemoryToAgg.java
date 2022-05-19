package org.example;

import org.example.exception.InputNotSetError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FromMemoryToAgg implements BaseFlow{

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

        String[] names = new String[input.size()];
        output = new Object[input.size()];
        double avg;
        double sum = 0;

        for(int i = 0; i < input.size(); i++){
            String[] separated = String.valueOf(input.get(i)).split(";");
            sum += Double.parseDouble(separated[1]);
            names[i] = separated[0];
        }
        avg = sum / input.size();

        int i = 0;
        for (String name : names) {
            output[i] = name+";"+avg;
            i++;
        }
    }
}
