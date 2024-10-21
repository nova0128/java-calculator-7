package calculator.controller;

import calculator.domain.InputStringCalculator;
import calculator.domain.SumCalculator;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CaculatorController {

    public void calculate() {
        InputStringCalculator inputStringCalculator = new InputStringCalculator();
        List<String> numbers = inputStringCalculator.extractNumbers();

        SumCalculator sumCalculator = new SumCalculator();
        int result = sumCalculator.sum(numbers);

        OutputView.printResult(result);
    }
}
