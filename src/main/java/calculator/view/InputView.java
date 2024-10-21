package calculator.view;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> readNumbers() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        final String stringNumbers = scanner.nextLine();
        return Collections.singletonList(stringNumbers);
    }

    // 테스트용 입력 메서드 추가
    public static List<String> readNumbers(String input) {
        return Collections.singletonList(input);
    }
}
