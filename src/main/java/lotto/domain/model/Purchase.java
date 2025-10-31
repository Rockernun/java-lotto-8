package lotto.domain.model;

public class Purchase {

    private static final int PAYMENT_UNIT = 1000;

    private final int payment;

    public Purchase(int payment) {
        validatePaymentIsPositive(payment);
        validatePaymentIsMultipleOfPrice(payment);
        this.payment = payment;
    }

    public int getPayment() {
        return payment;
    }

    public int getPurchasedLottoCount() {
        return payment / PAYMENT_UNIT;
    }

    private void validatePaymentIsPositive(int payment) {
        if (payment <= 0) throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 양수여야 합니다.");
    }

    private void validatePaymentIsMultipleOfPrice(int payment) {
        if (payment % PAYMENT_UNIT != 0) {
            throw new IllegalArgumentException(String.format("[ERROR] 구매 금액은 %d원 단위여야 합니다.", PAYMENT_UNIT));
        }
    }
}
