package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FromCSVToXML implements Step{

    private String inputFilePath;
    private final String xmlFilePath = "src/points.xml";
    private final XmlMapper xmlMapper;
    private final CsvReaderAdapter csvReaderAdapter;

    public FromCSVToXML(XmlMapper xmlMapper, CsvReaderAdapter csvReaderAdapter) {
        this.xmlMapper = xmlMapper;
        this.csvReaderAdapter = csvReaderAdapter;
    }

    @Override
    public void setInput(String input) throws FileNotFoundException {
        this.inputFilePath = input;
        csvReaderAdapter.setIncludePath(inputFilePath);
    }

    @Override
    public String getOutput() {
        return xmlFilePath;
    }

    @Override
    public void doIt() {
        try {
            List<Result> allResult = getAllResult();
            xmlMapper.writeValue(new File(xmlFilePath), allResult);
        } catch (IOException e) {
            throw new RuntimeException("Error during serializing object",e);
        }
    }

    private List<Result> getAllResult() throws IOException {
        List<Result> outputResults = new ArrayList<>();
        String[] values;
        while ((values = csvReaderAdapter.readNext()) != null) {
            outputResults.add(new Result(splitByComma(values[0])[0],Double.parseDouble(splitByComma(values[0])[1])));
        }
        return outputResults;
    }

    private String[] splitByComma(String pair){
        return pair.split(";");
    }
}
