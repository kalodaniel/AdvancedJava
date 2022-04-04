package org.example;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class MainFrame
{
    public static void main( String[] args ) {
        run(new ConcreteImplementation());
    }

    private static void run(FlowInterfaceProvider provider) {
        provider.runFromXMLToXML();
    }
}
