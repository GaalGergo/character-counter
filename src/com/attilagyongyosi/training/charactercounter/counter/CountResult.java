package com.attilagyongyosi.training.charactercounter.counter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountResult {
    private Map<Character, Integer> resultMap;

    public CountResult() {
        this.resultMap = new HashMap<>();
    }

    public void addOccurrence(final Character character) {
        int oldValue = 1;

       if (this.resultMap.containsKey(character)) {
            oldValue = this.resultMap.get(character);
            oldValue++;
        }

        this.resultMap.put(character, oldValue);
    }

    public Set<Map.Entry<Character, Integer>> getOccurrences() {
        return this.resultMap.entrySet();
    }
}
