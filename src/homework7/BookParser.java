package homework7;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookParser {
    private static final String CHAR_TO_KEEP = "[^A-Za-zА-Яа-я]";

    private List<String> getText(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file))
                .lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll(CHAR_TO_KEEP, ""))
                .map(String::toLowerCase)
                .filter(word -> word.length() > 2)
                .toList();
    }

    public Map<String, Integer> popularWord(File file, int amount) throws FileNotFoundException {
        Map<String, Integer> mostPopularWords = uniqWords(getText(file)).entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(amount)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return mostPopularWords;
    }

    private Map<String, Integer> uniqWords(List<String> wordsInBook) {
        Map<String, Integer> uniqueWords = new HashMap<>();
        for (String word : wordsInBook) {
            if (!uniqueWords.containsKey(word)) {
                uniqueWords.put(word, 0);
            }
            uniqueWords.put(word, uniqueWords.get(word).intValue() + 1);
        }
        return uniqueWords;
    }

    public int countUniqueWords(File file) throws FileNotFoundException {
        return new HashSet<>(getText(file)).size();
    }
}