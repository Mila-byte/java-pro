package homework7.statistic;

import java.util.List;

public class Statistic {
    private final List<String> topWords;
    private final int amountWords;
    private final int uniqWords;

    public Statistic(List<String> topWords, int amount, int uniqWords) {
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