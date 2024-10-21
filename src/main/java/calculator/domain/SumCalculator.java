package calculator.domain;

import java.util.List;

public class SumCalculator {

    public int sum(List<String> numbers) {
        int total = 0;

        for (String number : numbers) {
            int num = Integer.parseInt(number);
            if (num < 0) {
                throw new IllegalArgumentException("음수 비허용");
            }
            total += num;
        }

        return total;
    }
}
