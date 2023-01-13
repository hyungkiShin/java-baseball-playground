package study.calculate;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FormulaTest {

    @ParameterizedTest(name = "#{index} - Run test with args={0}")
    @NullSource // pass a null value
    @ValueSource(strings = {"", " "})
    void null_혹은_빈_값을_보낼때_checked_Exception(String input) {
        // given & when & then
        assertThatThrownBy(() ->
                new Formula(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 null 이거나 빈 공백 문자입니다.");
    }
}