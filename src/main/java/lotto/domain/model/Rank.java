package lotto.domain.model;

import java.util.Arrays;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    OTHERS(0, false, 0L);

    private final int matchedNumberCount;
    private final boolean containsBonusNumber;
    private final long prize;

    Rank(int matchedNumberCount, boolean containsBonusNumber, long prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.containsBonusNumber = containsBonusNumber;
        this.prize = prize;
    }

    public static Rank of(int matchedNumberCount, boolean containsBonusNumber) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchedNumberCount == matchedNumberCount)
                .filter(rank -> rank.matchedNumberCount != 5 || rank.containsBonusNumber == containsBonusNumber)
                .findFirst()
                .orElse(OTHERS);
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public long getPrize() {
        return prize;
    }
}
