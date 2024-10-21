package calculator;

import calculator.controller.CaculatorController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            System.setIn(new ByteArrayInputStream("//;\n1;2;3\n".getBytes()));
            CaculatorController controller = new CaculatorController();
            controller.calculate();
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_입력_테스트() {
        assertSimpleTest(() -> {
            System.setIn(new ByteArrayInputStream("\n".getBytes()));
            assertThatThrownBy(() -> {
                CaculatorController controller = new CaculatorController();
                controller.calculate();
            }).isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            System.setIn(new ByteArrayInputStream("1,2:3\n".getBytes()));
            CaculatorController controller = new CaculatorController();
            controller.calculate();
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 음수_입력_예외_테스트() {
        assertSimpleTest(() -> {
            System.setIn(new ByteArrayInputStream("1,-2,3\n".getBytes()));
            assertThatThrownBy(() -> {
                CaculatorController controller = new CaculatorController();
                controller.calculate();
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("음수 비허용");
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
