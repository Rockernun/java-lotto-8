package lotto.domain.model;

import static lotto.domain.model.LottoRules.maxNumber;
import static lotto.domain.model.LottoRules.minNumber;

import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        LottoNumbers.validateNumbers(winningNumbers);
        validateBonusNumberInRange(bonusNumber);
        validateDuplicateBonusNumber(bonusNumber);
    }

    public static WinningNumbers of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < minNumber() || bonusNumber > maxNumber()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 벗어났습니다.");
        }
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}