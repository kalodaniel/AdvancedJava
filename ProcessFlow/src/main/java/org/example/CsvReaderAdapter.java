package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface CsvReaderAdapter {
    String[] readNext() throws IOException;
    void setIncludePath(String inputFilePath) throws FileNotFoundException;
}
