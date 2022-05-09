package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileNotFoundException;
import java.util.function.Consumer;

public class MainFrame
{
    public static void main( String[] args ) {
      Step step = new FromCSVToXML(new XmlMapper(), new CsvReaderAdapterImpl());
      dataIn(s -> setInput(s,step));
      step.doIt();

      Step step2 = new XmlToMemoryArray(new XmlReaderAdapterImpl());
      dataIn(s -> setInput(step.getOutput(), step2));
      step2.doIt();

      Step step3 = new MemoryArrayToAggregatedResult(new AggregateResultAdapterImpl());
      dataIn(s -> setInput(step2.getOutput(), step3));
      step3.doIt();

      Step step4 = new AggregatedResultToCsv( new CsvWriterAdapterImpl());
      dataIn(s -> setInput(step3.getOutput(), step4));
      step4.doIt();
    }

  public static void dataIn(Consumer<String> fv){
    fv.accept("src/points.csv");
  }
  private static void setInput(String s, Step step) {
    try {
      step.setInput(s);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }


}
