package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseTest {

    @DisplayName("구매 금액이 양수가 아니면 예외가 발생한다.")
    @Test
    void 구매_금액이_양수가_아니면_예외가_발생한다() {
        assertThatThrownBy(() ->
            List.of(new Purchase(-1000), new Purchase(0))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구매 금액 단위가 천원이 아니면 예외가 발생한다.")
    @Test
    void 구매_금액_단위가_천원이_아니면_예외가_발생한다() {
        assertThatThrownBy(() ->
            List.of(new Purchase(2025), new Purchase(1225))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}