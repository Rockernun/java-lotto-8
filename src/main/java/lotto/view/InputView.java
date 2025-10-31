package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.parser.CommaParser;
import lotto.domain.parser.Parser;

public class InputView {

    public static final String REGEX = "^[0-9]*$";

    public String inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePaymentIsNumber(input);
        validatePaymentIsEmpty(input);

        return input;
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        Parser parser = new CommaParser();
        List<Integer> parsedNumber = parser.parse(input);
        validateWinningNumbersAreEmpty(input);
        for (Integer number : parsedNumber) {
            validateWinningNumbersAreNumber(String.valueOf(number));
        }

        return input;
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateBonusNumberIsEmpty(input);
        validateBonusNumberIsNumber(input);

        return input;
    }

    private void validatePaymentIsEmpty(String input) {
        if (input.trim().isEmpty()) throw new IllegalArgumentException("[ERROR] 구매 금액이 비어 있습니다.");
    }

    private void validatePaymentIsNumber(String input) {
        if (!input.matches(REGEX)) throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자만 입력 가능합니다.");
    }

    private void validateWinningNumbersAreEmpty(String input) {
        if (input.trim().isEmpty()) throw new IllegalArgumentException("[ERROR] 당첨 번호가 비어 있습니다.");
    }

    private void validateWinningNumbersAreNumber(String input) {
        if (!input.matches(REGEX)) throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.");
    }

    private void validateBonusNumberIsEmpty(String input) {
        if (input.trim().isEmpty()) throw new IllegalArgumentException("[ERROR] 보너스 번호가 비어 있습니다.");
    }

    private void validateBonusNumberIsNumber(String input) {
        if (!input.matches(REGEX)) throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.");
    }
}
