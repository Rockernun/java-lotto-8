package lotto.domain.generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomLottoGenerator implements LottoGenerator {

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(1, 45);
    }
}
