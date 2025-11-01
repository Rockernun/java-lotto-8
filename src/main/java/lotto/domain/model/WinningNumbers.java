package lotto.domain.model;

import static lotto.domain.LottoRules.lottoSize;
import static lotto.domain.LottoRules.maxNumber;
import static lotto.domain.LottoRules.minNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    private WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        validateWinningNumberIsPositive(winningNumbers);
        validateWinningNumberInRange(winningNumbers);
        validateNumberCount(winningNumbers);
        validateDuplicateWinningNumber(winningNumbers);
        validateBonusNumberIsPositive(bonusNumber);
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

    private void validateWinningNumberIsPositive(List<Integer> parsedNumbers) {
        for (Integer number : parsedNumbers) {
            if (number <= 0) throw new IllegalArgumentException("[ERROR] 당첨 번호는 양수여야 합니다.");
        }
    }

    private void validateWinningNumberInRange(List<Integer> parsedNumbers) {
        for (Integer number : parsedNumbers) {
            if (number < minNumber() || number > maxNumber()) throw new IllegalArgumentException("[ERROR] 당첨 번호가 범위를 벗어났습니다.");
        }
    }

    private void validateNumberCount(List<Integer> parsedNumbers) {
        if (parsedNumbers.size() != lottoSize()) throw new IllegalArgumentException(String.format("[ERROR] 당첨 번호의 개수는 %d개여야 합니다.", lottoSize()));
    }

    private void validateDuplicateWinningNumber(List<Integer> parsedNumbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : parsedNumbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되었습니다.");
            }
        }
    }

    private void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber <= 0) throw new IllegalArgumentException("[ERROR] 보너스 번호는 양수여야 합니다.");
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < minNumber() || bonusNumber > maxNumber()) throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 벗어났습니다.");
    }

    private void validateDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) throw new IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");
    }
}