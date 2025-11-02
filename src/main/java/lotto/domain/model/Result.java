package lotto.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> counts;

    private Result(Map<Rank, Integer> counts) {
        this.counts = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            this.counts.put(rank, counts.getOrDefault(rank, 0));
        }
    }

    public static Result of(Map<Rank, Integer> counts) {
        return new Result(counts);
    }

    public Long totalPrize() {
        long sum = 0L;
        for (Map.Entry<Rank, Integer> e : counts.entrySet()) {
            sum += e.getKey().getPrize() * e.getValue();
        }

        return sum;
    }

    public String yieldRate(int payment) {
        BigDecimal rate = BigDecimal.valueOf(totalPrize())
                .divide(BigDecimal.valueOf(payment), 3, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100));

        return rate.setScale(1, RoundingMode.HALF_UP) + "%";
    }

    public int count(Rank rank) {
        return counts.getOrDefault(rank, 0);
    }
}
