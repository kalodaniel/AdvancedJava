package org.example;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;
import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FromCSVToXMLTest {

    @Mock
    private XmlMapper xmlMapper;
    @Mock
    private CsvReaderAdapter csvReaderAdapter;
    @InjectMocks
    private FromCSVToXML fromCSVToXML;

    @Test
    public void doIt() throws IOException {
        //Given
        when(csvReaderAdapter.readNext()).thenReturn(new String[] { "valami", "1.0" }).thenReturn(null);

        //When
        fromCSVToXML.doIt();

        //Then
        verify(csvReaderAdapter,times(2)).readNext();
        verify(xmlMapper,times(1)).writeValue(any(File.class),any());
    }
}