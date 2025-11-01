package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @DisplayName("당첨되지 않은 등수는 개수가 0인지 검증한다.")
    @Test
    void 당첨되지_않은_등수는_개수가_0인지_검증한다() {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        counts.put(Rank.SECOND, 1);
        counts.put(Rank.THIRD, 1);
        counts.put(Rank.FOURTH, 1);
        counts.put(Rank.FIFTH, 1);

        Result result = new Result(counts);
        assertThat(result.count(Rank.FIRST)).isEqualTo(0);
    }

    @DisplayName("총 상금이 정확히 합산되는지 검증한다.")
    @Test
    void 총_상금이_정확히_합산되는지_검증한다() {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        counts.put(Rank.FIRST, 1);
        counts.put(Rank.SECOND, 1);
        counts.put(Rank.THIRD, 1);
        counts.put(Rank.FOURTH, 1);
        counts.put(Rank.FIFTH, 1);

        Result result = new Result(counts);
        assertThat(result.totalPrize()).isEqualTo(2_000_000_000L + 30_000_000L + 1_500_000L + 50_000L + 5_000L);
    }

    @DisplayName("수익률은 소수점 한 자리로 반올림해 백분율로 반환한다.")
    @Test
    void 수익률을_소수점_한_자리로_반올림해_백분율로_반환한다() {
        Map<Rank, Integer> counts = new EnumMap<>(Rank.class);
        counts.put(Rank.FIFTH, 1);

        Result result = new Result(counts);
        assertThat(result.yieldRate(8_000)).isEqualTo("62.5%");
    }

}