package lotto.domain.parser;

import java.util.ArrayList;
import java.util.List;

public class CommaParser implements Parser {

    private static final String DELIMITER = ",";

    @Override
    public List<Integer> parse(String input) {
        List<Integer> result = new ArrayList<>();
        for (String s : input.split(DELIMITER)) {
            String trim = s.trim();
            if (trim.isEmpty()) throw new IllegalArgumentException("[ERROR] 쉼표 사이에 공백은 허용되지 않습니다.");

            result.add(Integer.parseInt(trim));
        }

        return result;
    }
}
