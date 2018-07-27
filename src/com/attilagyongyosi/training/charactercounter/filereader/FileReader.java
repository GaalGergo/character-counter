package com.attilagyongyosi.training.charactercounter.filereader;

public interface FileReader {
    String read(String path) throws FileReaderException;
}
