package calculator.domain;

import calculator.view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class InputStringCalculator {

    public List<String> extractNumbers() {
        List<String> inputStrings = InputView.readNumbers();
        if (inputStrings.isEmpty()) {
            return Collections.emptyList();
        }

        String stringNumbers = inputStrings.get(0);
        List<String> numberList = new ArrayList<>();

        if (stringNumbers.startsWith("//")) {
            String[] parts = stringNumbers.split("\n", 2);
            String customDelimiter = parts[0].substring(2).trim();
            String numbers = parts[1];

            numberList.addAll(Arrays.asList(numbers.split("[" + customDelimiter + "]")));
        } else {
            numberList.addAll(Arrays.asList(stringNumbers.split(",|:")));
        }

        return numberList;
    }
}
