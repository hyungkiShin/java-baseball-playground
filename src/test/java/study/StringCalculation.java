package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculation {


    @Test
    @DisplayName(" \"2 + 3 * 4 / 2\"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다")
    void stringCalculate() {
        // given
        final String input = "2 + 3 * 4 / 2";

        final String[] parseString = input.split(" ");

        final ArrayList<String> operator = new ArrayList<>();

        final ArrayList<Integer> numbers = new ArrayList<>();

        // when
        for (final String s : parseString) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                operator.add(s);
            } else {
                numbers.add(Integer.parseInt(s));
            }
        }

        Integer result = numbers.get(0);

        for (int i = 0; i < operator.size(); i++) {
            result = calculate(result, operator.get(i), numbers.get(i + 1));
        }

        // then
        assertThat(result).isEqualTo(10);
    }

    private int calculate(int number, String operator, int number2) {

        switch (operator) {
            case "+":
                return add(number, number2);
            case "-":
                return subtract(number, number2);
            case "*":
                return multiply(number, number2);
            case "/":
                return divide(number, number2);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
    }

    private static int add(int number, int number2) {
        return number + number2;
    }

    private static int subtract(int number, int number2) {
        return number - number2;
    }

    private static int multiply(int number, int number2) {
        return number * number2;
    }

    private static int divide(int number, int number2) {
        if (number == 0) {
            throw new IllegalArgumentException("0을 나눌순 없습니다.");
        }
        return number / number2;
    }


    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:3", "3:4"}, delimiter = ':')
    void test_add(int number, int number2) {
        // given & when & then
        assertThat(add(number, 1)).isEqualTo(number2);
    }

    @DisplayName("뺄셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "2:1", "3:2"}, delimiter = ':')
    void test_subtract(int number, int number2) {
        // given & when & then
        assertThat(subtract(number, 1)).isEqualTo(number2);
    }

    @DisplayName("곱셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:2", "2:4", "3:6"}, delimiter = ':')
    void test_multiply(int number, int number2) {
        // given & when & then
        assertThat(multiply(number, 2)).isEqualTo(number2);
    }

    @DisplayName("나눗셈 테스트")
    @Test
    void test_divide() {
        // given & when & then

        // 일반적인 나눗셈 테스트
        assertThat(divide(2, 2)).isEqualTo(1);

        // 0을 나누는 경우
        assertThatThrownBy(() ->
                divide(0, 2)).isInstanceOf(IllegalArgumentException.class).hasMessage("0을 나눌순 없습니다.");

    }
}
