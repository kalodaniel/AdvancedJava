package org.example;

import org.example.exception.InputNotSetError;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FromCsvToXml implements BaseFlow{

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
    public void doIt(){

        if(input.isEmpty()){
            throw new InputNotSetError();
        }

        output = new Object[input.size()];

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;

        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

        assert docBuilder != null;
        Document doc = docBuilder.newDocument();
        Element root = doc.createElement("root");
        doc.appendChild(root);

        int i = 0;

        for (Object namePointPair : input) {
            String[] separated = String.valueOf(namePointPair).split(";");

            Element name = doc.createElement("name");
            root.appendChild(name);
            name.setTextContent(separated[0]);

            Element point = doc.createElement("point");
            root.appendChild(point);
            point.setTextContent(separated[1]);

            output[i] = namePointPair;
            i++;
        }
    }

}
