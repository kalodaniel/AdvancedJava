package org.example;

import javax.swing.*;
import java.io.FilterOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class pureMethodUsage {

    public static void main(String[] args) {
        System.out.println(filter(toUpperCase(data())));
        System.out.println(toLength(filter(data())));
        System.out.println(transformList(data(), String::toLowerCase));
        System.out.println(transformList(data(), String::toUpperCase));
        System.out.println(transformList(data(), (input)->input.substring(0,2)));
        Function<String,String> endOfString = (input)->input.substring(input.length()-4,input.length()-1);
        System.out.println(transformList(data(),endOfString));
    }

    public static List<String> filter(List<String> input){
        List<String> output = new ArrayList<>();
        for (String item:input) {
            if(item.length() > 3){
                output.add(item);
            }
        }
        return output;
    }

    public static List<String> filter(){
        List<String> input = data();
        return input;
    }

    public static List<String> data(){
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("egy");
        nameList.add("ketooooo");
        nameList.add("asdasdasdasdasdas");

        return nameList;
    }

    public static List<Integer> toLength(List<String> input){
        List<Integer> output = new ArrayList<>();
        for (String item:input) {
            output.add(item.length());
        }
        return output;
    }

    public static List<String> toUpperCase(List<String> input){
        List<String> output = new ArrayList<>();
        for (String item :input) {
            output.add(item.toUpperCase());
        }
        return output;
    }

    public static List<String> toLowerCase(List<String> input){
        List<String> output = new ArrayList<>();
        for (String item :input) {
            output.add(item.toLowerCase());
        }
        return output;
    }

    public static List<String> transformList(List<String> input, Function<String,String> transformFunction){
        List<String> output = new ArrayList<>();
        for (String item :input) {
            output.add(transformFunction.apply(item));
        }
        return output;
    }
}
