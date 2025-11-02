package lotto.domain.model;

public enum Rank {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    OTHERS(0, false, 0L);

    private final int matchedNumberCount;
    private final long prize;

    Rank(int matchedNumberCount, boolean bonusRequired, long prize) {
        this.matchedNumberCount = matchedNumberCount;
        this.prize = prize;
    }

    public int getMatchedNumberCount() {
        return matchedNumberCount;
    }

    public long getPrize() {
        return prize;
    }

    public static Rank of(int matchedNumberCount, boolean bonusRequired) {
        if (matchedNumberCount == 6) {
            return FIRST;
        }
        if (matchedNumberCount == 5 && bonusRequired) {
            return SECOND;
        }
        if (matchedNumberCount == 5) {
            return THIRD;
        }
        if (matchedNumberCount == 4) {
            return FOURTH;
        }
        if (matchedNumberCount == 3) {
            return FIFTH;
        }

        return OTHERS;
    }
}
