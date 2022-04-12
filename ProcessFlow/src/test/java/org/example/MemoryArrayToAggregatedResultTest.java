package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemoryArrayToAggregatedResultTest {

    @Mock
    private AggregateResultAdapter aggregateResultAdapter;
    @InjectMocks
    private MemoryArrayToAggregatedResult memoryArrayToAggregatedResult;

    @Test
    public void doIt() {
        //Given
        when(aggregateResultAdapter.count(any())).thenReturn("Valami;1");

        //When
        memoryArrayToAggregatedResult.doIt();

        //Then
        verify(aggregateResultAdapter,times(1)).count(any());
    }
}