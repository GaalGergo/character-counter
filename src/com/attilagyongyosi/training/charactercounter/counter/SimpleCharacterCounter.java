package com.attilagyongyosi.training.charactercounter.counter;

public class SimpleCharacterCounter implements CharacterCounter {

    @Override
    public CountResult count(final String text) {
        final CountResult result = new CountResult();

       // char[] chars = text.toCharArray();

        //for (char c: chars) {
        //    if(Character.isAlphabetic(c)){
        //        result.addOccurrence(c);
       //     } else if (Character.isDigit(c)){
       //         result.addOccurrence(c);
       //     }
       // }

        text.chars()
            .mapToObj(charCode -> (char) charCode)
            .filter(character -> Character.isDigit(character) || Character.isAlphabetic(character))
            .forEach(character -> result.addOccurrence(character));

        return result;
    }
}
