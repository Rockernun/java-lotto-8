package lotto.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.model.Purchase;
import lotto.domain.model.Rank;
import lotto.domain.model.Result;
import lotto.domain.model.WinningNumbers;

public class LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoService(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    public List<Lotto> initLottoList(Purchase payment) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < payment.getPurchasedLottoCount(); i++) {
            lottoList.add(Lotto.of(lottoGenerator.generate()));
        }

        return lottoList;
    }

    public Result evaluate(List<Lotto> lottoList, WinningNumbers winningNumbers) {
        Map<Rank, Integer> counts = new HashMap<>();
        for (Lotto lotto : lottoList) {
            Rank rank = Rank.of(countMatches(lotto, winningNumbers), containsBonusNumber(lotto, winningNumbers));
            counts.put(rank, counts.getOrDefault(rank, 0) + 1);
        }

        return Result.of(counts);
    }

    private int countMatches(Lotto lotto, WinningNumbers winningNumbers) {
        int count = 0;
        for (Integer number : lotto.getLottoNumbers()) {
            if (winningNumbers.getWinningNumbers().contains(number)) {
                count++;
            }
            if (number.equals(winningNumbers.getBonusNumber())) {
                count++;
            }
        }

        return count;
    }

    private boolean containsBonusNumber(Lotto lotto, WinningNumbers winningNumbers) {
        boolean containsBonusNumber = false;
        for (Integer number : lotto.getLottoNumbers()) {
            if (number.equals(winningNumbers.getBonusNumber())) {
                containsBonusNumber = true;
            }
        }

        return containsBonusNumber;
    }
}
