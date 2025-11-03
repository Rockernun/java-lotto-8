package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @DisplayName("보너스 번호가 양수가 아니라면 예외가 발생한다.")
    @Test
    void 보너스_번호가_양수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), -10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 숫자가 있다면 예외가 발생한다.")
    @Test
    void 보너스_번호에_범위를_벗어난_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된다면 예외가 발생한다.")
    @Test
    void 당첨_번호와_보너스_번호가_중복된다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}