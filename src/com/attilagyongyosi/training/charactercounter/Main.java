package com.attilagyongyosi.training.charactercounter;

import com.attilagyongyosi.training.charactercounter.counter.AlphabeticCharacterCounter;
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
        CharacterCounter characterCounter1 = new AlphabeticCharacterCounter();

        String text = reader.read("sample-text.txt");
        CountResult countResult = characterCounter.count(text);
        CountResult countResult1 = characterCounter1.count(text);

        countResult1
            .getOccurrences()
            .stream()
            .forEach(resultEntry -> System.out.println(resultEntry.getKey() + ": " + resultEntry.getValue()));

        countResult
                .getOccurrences()
                .stream()
                .forEach(resultEntry -> System.out.println(resultEntry.getKey() + ": " + resultEntry.getValue()));
    }
}
