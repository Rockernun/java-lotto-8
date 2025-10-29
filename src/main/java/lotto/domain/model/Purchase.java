package lotto.domain.model;

public class Purchase {

    private final int purchasedLottoCount;

    public Purchase(int purchaseAmount) {
        validatePaymentIsPositive(purchaseAmount);
        validatePaymentIsMultipleOfPrice(purchaseAmount);
        this.purchasedLottoCount = calculateLottoCount(purchaseAmount);
    }

    public int getPurchasedLottoCount() {
        return purchasedLottoCount;
    }

    private int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private void validatePaymentIsPositive(int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 양수여야 합니다.");
        }
    }

    private void validatePaymentIsMultipleOfPrice(int purchaseAmount) {
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1,000원 단위여야 합니다.");
        }
    }
}
