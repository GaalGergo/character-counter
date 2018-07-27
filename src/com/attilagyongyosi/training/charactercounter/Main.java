package com.attilagyongyosi.training.charactercounter;

import com.attilagyongyosi.training.charactercounter.counter.CharacterCounter;
import com.attilagyongyosi.training.charactercounter.counter.CountResult;
import com.attilagyongyosi.training.charactercounter.counter.SimpleCharacterCounter;
import com.attilagyongyosi.training.charactercounter.filereader.ClassPathFileReader;
import com.attilagyongyosi.training.charactercounter.filereader.FileReader;
import com.attilagyongyosi.training.charactercounter.filereader.FileReaderException;

public class Main {
    public static void main(final String... args) throws FileReaderException {
        FileReader reader = new ClassPathFileReader();
        CharacterCounter characterCounter = new SimpleCharacterCounter();

        String text = reader.read("sampletext.txt");
        CountResult countResult = characterCounter.count(text);

        countResult
            .getOccurrences()
            .stream()
            .forEach(resultEntry -> System.out.println(resultEntry.getKey() + ": " + resultEntry.getValue()));
    }
}
