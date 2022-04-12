package org.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class XmlToMemoryArrayTest {

    @Mock
    private XmlReaderAdapter xmlReaderAdapter;
    @InjectMocks
    private XmlToMemoryArray xmlToMemoryArray;

    @Test
    public void doIt(){
        //Given
        when(xmlReaderAdapter.readXml(any())).thenReturn("Valami;1");

        //When
        xmlToMemoryArray.doIt();

        //Then
        verify(xmlReaderAdapter,times(1)).readXml(any());
    }
}