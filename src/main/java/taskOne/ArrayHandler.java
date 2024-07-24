package taskOne;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<String> getUniqueWords(String[] words) {
        List<String> uniqueWords = new ArrayList<>();
        Map<String, Integer> wordEncounteredNumber = getWordsEncounteredNumber(words);

        wordEncounteredNumber.forEach((key, value) -> {
            uniqueWords.add(key);
        });

        return uniqueWords;
    }
}
