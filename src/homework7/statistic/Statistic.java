package homework7.statistic;

import java.util.Map;

public class Statistic {
    private final Map<String, Integer> topWords;
    private final int amountWords;
    private final int uniqWords;

    public Statistic(Map<String, Integer> topWords, int amount, int uniqWords) {
        this.topWords = topWords;
        this.amountWords = amount;
        this.uniqWords = uniqWords;
    }

    @Override
    public String toString() {
        return "Statistic\n{" +
                "top" + amountWords + "Words" + "=" + topWords +
                ",\nuniqWords=" + uniqWords +
                '}';
    }
}