package study.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.calculate.Calculator;
import study.calculate.Formula;
import study.calculate.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculationTest {

    @Test
    @DisplayName(" \"2 + 3 * 4 / 2\"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다")
    void stringCalculate() {
        // given
        final String input = "2 + 3 * 4 / 2";

        final Calculator calculator = new Calculator(new Formula(input));
        // when
        final int result = calculator.calculate();
        // then
        assertThat(result).isEqualTo(10);
    }
}
