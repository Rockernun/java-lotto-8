package lotto.domain.model;

public class Purchase {

    private final int purchasedLottoCount;
    private static final int PAYMENT_UNIT = 1000;

    public Purchase(int purchaseAmount) {
        validatePaymentIsPositive(purchaseAmount);
        validatePaymentIsMultipleOfPrice(purchaseAmount);
        this.purchasedLottoCount = calculateLottoCount(purchaseAmount);
    }

    public int getPurchasedLottoCount() {
        return purchasedLottoCount;
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / PAYMENT_UNIT;
    }

    private void validatePaymentIsPositive(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 양수여야 합니다.");
        }
    }

    private void validatePaymentIsMultipleOfPrice(int purchaseAmount) {
        if (purchaseAmount % PAYMENT_UNIT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 단위여야 합니다.", PAYMENT_UNIT));
        }
    }
}
