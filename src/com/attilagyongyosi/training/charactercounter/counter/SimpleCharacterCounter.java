package com.attilagyongyosi.training.charactercounter.counter;

public class SimpleCharacterCounter implements CharacterCounter {

    @Override
    public CountResult count(final String text) {
        final CountResult result = new CountResult();

        text.chars()
            .mapToObj(charCode -> (char) charCode)
            .filter(character -> Character.isDigit(character))
            .forEach(character -> result.addOccurrence(character));

        return result;
    }
}
