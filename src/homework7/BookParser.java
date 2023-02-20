package homework7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class BookParser {
    private static final String CHAR_TO_KEEP = "[^A-Za-zА-Яа-я]";

    public List<String> getText(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file))
                .lines()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .map(word -> word.replaceAll(CHAR_TO_KEEP, ""))
                .filter(word -> word.length() > 2)
                .toList();
    }

    public List<String> popularWorld(List<String> words, int amount) {
        return words.stream()
                .distinct()
                .sorted(Comparator.comparingInt(s -> Collections.frequency(words, s)).reversed())
                .limit(amount).toList();
    }

    public int uniqWords(List<String> words) {
        return new HashSet<>(words).size();
    }
}