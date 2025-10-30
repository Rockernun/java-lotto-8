package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @DisplayName("보너스 번호가 음수라면 예외가 발생한다.")
    @Test
    void 보너스_번호가_음수라면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(-10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 0이라면 예외가 발생한다.")
    @Test
    void 보너스_번호가_0이라면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 숫자가 있다면 예외가 발생한다.")
    @Test
    void 보너스_번호에_범위를_벗어난_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}