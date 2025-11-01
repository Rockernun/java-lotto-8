package lotto.domain.model;

public final class LottoRules {

    private LottoRules() {}

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;
    private static final int PAYMENT_UNIT = 1000;

    public static int minNumber() {
        return MINIMUM_NUMBER;
    }

    public static int maxNumber() {
        return MAXIMUM_NUMBER;
    }

    public static int lottoSize() {
        return LOTTO_SIZE;
    }

    public static int paymentUnit() {
        return PAYMENT_UNIT;
    }
}
