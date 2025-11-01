package lotto.domain.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        LottoNumbers.validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}