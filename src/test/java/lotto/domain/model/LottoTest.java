package lotto.domain.model;

import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @DisplayName("로또 번호가 오름차순으로 정렬되어 있는지 검증한다.")
    @Test
    void 로또_번호가_오름차순으로_정렬되어_있는지_검증한다() {
        LottoGenerator generator = new RandomLottoGenerator();
        Lotto lotto = Lotto.of(generator.generate());
        assertThat(lotto.getLottoNumbers()).isSorted();
    }
}
