package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.parser.CommaParser;
import lotto.domain.parser.Parser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    Parser parser = new CommaParser();

    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void 당첨_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6, 7), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void 로또_번호의_개수가_6개보다_적으면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 양수가 아니라면 예외가 발생한다.")
    @Test
    void 당첨_번호가_양수가_아니라면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(-10, 1, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있다면 예외가 발생한다.")
    @Test
    void 당첨_번호에_범위를_벗어난_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 50), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있다면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복된_숫자가_있다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 2, 3, 4, 5), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

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

    @Test
    void 당첨_번호와_보너스_번호가_중복된다면_예외가_발생한다() {
        assertThatThrownBy(() -> WinningNumbers.of(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

}