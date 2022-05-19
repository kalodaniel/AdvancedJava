package org.example;

import java.util.ArrayList;
import java.util.List;

public class BaseRunner {

    private Object[] result;

    private List<BaseFlow> operations;

    public void run(){
        init();
        doIt();
    }

    private void init(){
        operations = new ArrayList<>();

        operations.add(new FromCsvToXml());
        operations.add(new FromXmlToMemory());
        operations.add(new FromMemoryToAgg());
        operations.add(new FromAggToCsv());
    }

    private void doIt(){
        String[] data = {"Kiss Bela;13","Nagy Adam;20","Horvath Jozsef;25"};
        operations.get(0).setInput(data);

        for (int i = 0; i < operations.size(); i++){

            operations.get(i).doIt();

            if(i < operations.size() - 1) {
                operations.get(i + 1).setInput(operations.get(i).getOutput());
            }else{
                result = new Object[getLength(i)];
                result = operations.get(i).getOutput();
            }
        }

        for (Object item : result) {
            System.out.println(item);
        }
    }

    private int getLength(int i){
        return operations.get(i).getOutput().length;
    }
}
