package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;

public class MainFrame
{
    public static void main( String[] args ) throws FileNotFoundException {
      Step step = new FromXmlToCsv();
      step.setInput("src/points.xml");
      step.doIt();
    }
}
