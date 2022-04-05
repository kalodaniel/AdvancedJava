package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;

public class MainFrame
{
    public static void main( String[] args ) {
      Step step = new FromCSVToXML(new XmlMapper(), new CsvReaderAdapterImpl());
      step.doIt();
    }
}
