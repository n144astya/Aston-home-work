package taskOne;

import java.util.*;

public class ArrayHandler {

    public Map<String, Integer> getWordsEncounteredNumber(String[] words) {
        Map<String, Integer> wordEncounteredNumber = new HashMap<>();
        for (String word: words) {
            if (wordEncounteredNumber.containsKey(word)) {
                wordEncounteredNumber.put(word, wordEncounteredNumber.get(word) + 1);
            } else {
                wordEncounteredNumber.put(word, 1);
            }
        }
        return wordEncounteredNumber;
    }

    public HashSet<String> getUniqueWords(String[] words) {
        return new HashSet<>(Arrays.asList(words));
    }
}
