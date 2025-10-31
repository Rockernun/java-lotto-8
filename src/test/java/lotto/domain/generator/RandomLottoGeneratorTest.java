package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    @DisplayName("범위 내에서 숫자가 생성되는지 검증한다.")
    @Test
    void 범위_내에서_숫자가_생성되는지_검증한다() {
        LottoGenerator generator = new RandomLottoGenerator();
        for (int i = 0; i < 1000; i++) {
            List<Integer> generatedNumbers = generator.generate();
            for (Integer generatedNumber : generatedNumbers) {
                assertThat(generatedNumber).isBetween(1, 45);
            }
        }
    }
}