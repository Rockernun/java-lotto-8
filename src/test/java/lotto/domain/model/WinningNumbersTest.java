package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.parser.CommaParser;
import lotto.domain.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    Parser parser = new CommaParser();

    @DisplayName("당첨 번호가 양수가 아니라면 예외가 발생한다.")
    @Test
    void 당첨_번호가_양수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of("-10, 1, 2, 3, 4, 5", parser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있다면 예외가 발생한다.")
    @Test
    void 당첨_번호에_범위를_벗어난_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of("1, 2, 3, 4, 5, 50", parser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of("1, 2, 3, 4, 4, 5", parser))
                .isInstanceOf(IllegalArgumentException.class);
    }

}