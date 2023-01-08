package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculate.Calculator;
import study.calculate.Formula;
import study.calculate.Operator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculation {


    @Test
    @DisplayName(" \"2 + 3 * 4 / 2\"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다")
    void stringCalculate() {
        // given
        final String input = "2 + 3 * 4 / 2";

        // when
        final String[] formulaString = Formula.split(input);

        final int result = new Calculator(formulaString).calculate();
        // then
        assertThat(result).isEqualTo(10);
    }


    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @NullSource // pass a null value
    @ValueSource(strings = {"", " "})
    void null_혹은_빈_값을_보낼때_checked_Exception(String input) {
        // given & when & then
        // TODO null 은 ValueSource 로 어떻게 테스트 하는지 확인
        assertThatThrownBy(() ->
                Formula.split(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null 이거나 빈 공백 문자입니다.");
    }


    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4"}, delimiter = ':')
    void test_add(int number, int number2) {
        // given & when & then
        assertThat(Operator.PLUS.operate(number, 1))
                .isEqualTo(number2);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:1", "3:2"}, delimiter = ':')
    void test_subtract(int number, int number2) {
        // given & when & then
        assertThat(Operator.MINUS.operate(number, 1))
                .isEqualTo(number2);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:4", "3:6"}, delimiter = ':')
    void test_multiply(int number, int number2) {
        // given & when & then
        assertThat(Operator.MULTIPLY.operate(number, 2))
                .isEqualTo(number2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void test_divide() {
        // given & when & then

        // 일반적인 나눗셈 테스트
        assertThat(Operator.DIVIDE.operate(2, 2))
                .isEqualTo(1);

        // 0을 나누는 경우
        assertThatThrownBy(() ->
                Operator.DIVIDE.operate(0, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0을 나눌순 없습니다.");

    }
}
