package lotto.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.utils.LottoNumbersValidator;

public class Lotto {

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        LottoNumbersValidator.validateNumbers(numbers);
        this.numbers = Collections.unmodifiableList(toSortedAscending(numbers));
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }

    private static List<Integer> toSortedAscending(List<Integer> numbers) {
        List<Integer> copiedList = new ArrayList<>(numbers);
        Collections.sort(copiedList);
        return copiedList;
    }
}