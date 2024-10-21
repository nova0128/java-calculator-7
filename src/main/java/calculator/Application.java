package calculator;

import calculator.controller.CaculatorController;

public class Application {
    public static void main(String[] args) {
        final CaculatorController controller = new CaculatorController();
        controller.calculate();
    }
}
