package lotto.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.parser.Parser;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final Parser parser;

    private WinningNumbers(String winningNumbers, Parser parser) {
        this.parser = parser;
        List<Integer> parsedNumbers = parser.parse(winningNumbers);

        validateWinningNumberIsPositive(parsedNumbers);
        validateWinningNumberInRange(parsedNumbers);
        validateDuplicateWinningNumber(parsedNumbers);

        this.winningNumbers = List.copyOf(parsedNumbers);
    }

    public static WinningNumbers of(String winningNumbers, Parser parser) {
        return new WinningNumbers(winningNumbers, parser);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    private void validateWinningNumberIsPositive(List<Integer> parsedNumbers) {
        for (Integer number : parsedNumbers) {
            if (number < 0) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 양수여야 합니다.");
            }
        }
    }

    private void validateWinningNumberInRange(List<Integer> parsedNumbers) {
        for (Integer number : parsedNumbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 범위를 벗어났습니다.");
            }
        }
    }

    private void validateDuplicateWinningNumber(List<Integer> parsedNumbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : parsedNumbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호가 중복되었습니다.");
            }
        }
    }
}
