package study.calculate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

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