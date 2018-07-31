package com.attilagyongyosi.training.charactercounter.counter;

public class AlphabeticCharacterCounter implements CharacterCounter{

    @Override
    public CountResult count(String text) {
        final CountResult result = new CountResult();

        text.chars()
                .mapToObj(charCode -> (char) charCode)
                .filter(character -> Character.isAlphabetic(character))
                .forEach(character -> result.addOccurrence(character));

        return result;
    }
}
