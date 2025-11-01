package lotto.domain.model;

import static lotto.domain.LottoRules.lottoSize;
import static lotto.domain.LottoRules.maxNumber;
import static lotto.domain.LottoRules.minNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateNumberCount(numbers);
        validateNumberInRange(numbers);
        validateDuplicateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != lottoSize()) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개 입니다.", lottoSize()));
        }
    }

    private void validateNumberInRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < minNumber() || number > maxNumber()) {
                throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d부터 %d사이의 숫자여야 합니다.", minNumber(), maxNumber()));
            }
        }
    }

    private void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>();
        for (Integer number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안 됩니다.");
            }
        }
    }
}