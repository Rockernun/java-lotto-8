package lotto.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLottoGeneratorTest {

    LottoGenerator generator = new RandomLottoGenerator();
    List<Integer> generatedNumbers = generator.generate();

    @DisplayName("범위 내에서 숫자가 생성되는지 검증한다.")
    @Test
    void 범위_내에서_숫자가_생성되는지_검증한다() {
        for (int i = 0; i < 1000; i++) {
            for (Integer generatedNumber : generatedNumbers) {
                assertThat(generatedNumber).isBetween(1, 45);
            }
        }
    }

    @DisplayName("설정한 개수만큼 난수가 생성되는지 검증한다.")
    @Test
    void 설정한_개수만큼_난수가_생성되는지_검증한다() {
        for (int i = 0; i < 1000; i++) {
            assertThat(generatedNumbers).hasSize(6);
        }
    }

    @DisplayName("생성된 난수들이 중복되는지 검증한다.")
    @Test
    void 생성된_난수들이_중복되는지_검증한다() {
        for (int i = 0; i < 1000; i++) {
            assertThat(generatedNumbers).doesNotHaveDuplicates();
        }
    }
}