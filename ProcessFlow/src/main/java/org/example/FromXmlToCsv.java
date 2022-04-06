package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FromXmlToCsv implements Step{

    private String inputFilePath;
    private final String csvFilePath = "src/points.csv";
    @Override
    public void setInput(String input) throws FileNotFoundException {
        this.inputFilePath = input;
    }

    @Override
    public String getOutput() {
        return csvFilePath;
    }

    @Override
    public void doIt() {
        Document doc = readXML(inputFilePath);
        String outputString = createString(doc);
        writeToCsv(outputString);
    }

    private void writeToCsv(String outputString) {
        try {
            PrintWriter writer = new PrintWriter(new File(csvFilePath));
            writer.write(outputString);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String createString(Document doc){
        StringBuilder sb = new StringBuilder();
        NodeList nodeList = doc.getElementsByTagName("item");
        for (int i = 0; i < nodeList.getLength(); i++)
        {
            Node node = nodeList.item(i);
            Element eElement = (Element) node;
            sb.append(eElement.getElementsByTagName("name").item(0).getTextContent());
            sb.append(";");
            sb.append(eElement.getElementsByTagName("point").item(0).getTextContent());
            sb.append("\n");
        }
        return sb.toString();
    }

    private Document readXML(String input) {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(new File(input));
            doc.getDocumentElement().normalize();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }


}
