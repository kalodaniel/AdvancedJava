package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;

public class MainFrame
{
    public static void main( String[] args ) throws FileNotFoundException {
      Step step = new FromCSVToXML(new XmlMapper(), new CsvReaderAdapterImpl());
      step.setInput("src/points.csv");
      step.doIt();
      Step step2 = new XmlToMemoryArray(new XmlReaderAdapterImpl());
      step2.setInput(step.getOutput());
      step2.doIt();
      Step step3 = new MemoryArrayToAggregatedResult(new AggregateResultAdapterImpl());
      step3.setInput(step2.getOutput());
      step3.doIt();
      Step step4 = new AggregatedResultToCsv( new CsvWriterAdapterImpl());
      step4.setInput(step3.getOutput());
      step4.doIt();
    }
}
