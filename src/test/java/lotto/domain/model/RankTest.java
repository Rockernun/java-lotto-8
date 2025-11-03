package lotto.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RankTest {

    @Test
    void 번호_6개가_일치할_경우_1등인지_검증한다() {
        assertThat(Rank.of(6, false)).isEqualTo(Rank.FIRST);
    }

    @Test
    void 번호_5개가_일치하고_보너스_번호도_일치하는_경우_2등인지_검증한다() {
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
    }

    @Test
    void 번호_5개가_일치할_경우_3등인지_검증한다() {
        assertThat(Rank.of(5, false)).isEqualTo(Rank.THIRD);
    }

    @Test
    void 번호_4개가_일치할_경우_4등인지_검증한다() {
        assertThat(Rank.of(4, false)).isEqualTo(Rank.FOURTH);
    }

    @Test
    void 번호_3개가_일치할_경우_5등인지_검증한다() {
        assertThat(Rank.of(3, false)).isEqualTo(Rank.FIFTH);
    }

    @Test
    void 그_외의_경우를_검증한다() {
        assertThat(Rank.of(2, false)).isEqualTo(Rank.OTHERS);
        assertThat(Rank.of(1, false)).isEqualTo(Rank.OTHERS);
        assertThat(Rank.of(0, false)).isEqualTo(Rank.OTHERS);
    }
}