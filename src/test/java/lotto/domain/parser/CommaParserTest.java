package lotto.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommaParserTest {

    @DisplayName("쉼표를 기준으로 숫자를 분리하는지 검증한다.")
    @Test
    void 쉼표를_기준으로_숫자를_분리하는지_검증한다() {
        String input = "1, 2, 3, 4, 5, 6";
        Parser commaParser = new CommaParser();
        assertThat(commaParser.parse(input)).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("쉼표 사이에 공백이 있으면 예외가 발생한다.")
    @Test
    void 쉼표_사이에_공백이_있으면_예외가_발생한다() {
        Parser commaParser = new CommaParser();
        assertThatThrownBy(() -> commaParser.parse(("1, ,2, 3, 4, 5")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}