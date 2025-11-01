package lotto.domain.model;

import static lotto.domain.LottoRules.paymentUnit;

public class Purchase {

    private final int payment;

    private Purchase(int payment) {
        validatePaymentIsPositive(payment);
        validatePaymentIsMultipleOfPrice(payment);
        this.payment = payment;
    }

    public static Purchase of(int payment) {
        return new Purchase(payment);
    }

    public int getPayment() {
        return payment;
    }

    public int getPurchasedLottoCount() {
        return payment / paymentUnit();
    }

    private void validatePaymentIsPositive(int payment) {
        if (payment <= 0) throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 양수여야 합니다.");
    }

    private void validatePaymentIsMultipleOfPrice(int payment) {
        if (payment % paymentUnit() != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 단위여야 합니다.", paymentUnit()));
        }
    }
}
