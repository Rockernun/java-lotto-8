package lotto.domain.model;

import static lotto.domain.model.LottoRules.lottoSize;
import static lotto.domain.model.LottoRules.maxNumber;
import static lotto.domain.model.LottoRules.minNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class LottoNumbersValidator {

    private LottoNumbersValidator() {
    }

    public static void validateNumbers(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberInRange(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != lottoSize()) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개 입니다.", lottoSize()));
        }
    }

    private static void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < minNumber() || number > maxNumber()) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 로또 번호는 %d부터 %d 사이의 숫자여야 합니다.", minNumber(), maxNumber()));
            }
        }
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
            }
        }
    }
}
