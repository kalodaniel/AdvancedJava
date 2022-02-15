package org.example;

public class App
{
    private static Integer getInt(String str, int order){
        Integer rv = null;

        try {
            rv = Integer.valueOf(str);
        }catch (NumberFormatException ex){
            System.err.println(order+". parameter type error (supported type: integer f.e. 4)");
        }
        return rv;
    }

    public static void main(String[] args ) {

        Representation representation = new Representation(args);
        Operands operands = representation.getOperands();

        Integer a =  getInt(args[0], 1);
        Integer b =  getInt(args[1], 2);

        if(a != null && b != null){
           representation.printResult(new Service().calculate(a,b));
        }
    }
}
