package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.w3c.dom.Document;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FromXmlToCsvTest {

    @Mock
    private XmlReaderAdapter xmlReaderAdapter;
    @Mock
    private CsvWriterAdapter csvWriterAdapter;
    @InjectMocks
    private FromXmlToCsv fromXmlToCsv;

    @Test
    public void doIt(){
        //Given
        when(xmlReaderAdapter.readXml(any())).thenReturn("Valami;5");

        //When
        fromXmlToCsv.doIt();

        //Then
        verify(xmlReaderAdapter,times(1)).readXml(any());
        verify(csvWriterAdapter,times(1)).writeToCsv(any(),any());
    }

}