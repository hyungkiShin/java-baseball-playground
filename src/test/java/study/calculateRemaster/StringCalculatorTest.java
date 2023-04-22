package study.calculateRemaster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringCalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자가 정상적으로 반환되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2|true", "1:2|true", "1//2|true", "1\n2|true"}, delimiter = '|')
    void passStringParseTest(String str, boolean expected) {
        // given
        final String[] split = parseString(str);
        // when & then
        assertThat(split[0].contains("1")).isEqualTo(expected);
        assertThat(split[1].contains("2")).isEqualTo(expected);
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자가 정상적으로 반환되어야 한다.")
    @ParameterizedTest

    @CsvSource(value = {"\"//;\\n1;2;3\"|true"}, delimiter = '|')
    void passCustomStringParseTest(String str, boolean expected) {
        // given
        final String[] split = parseString(str);
        // when & then
        assertThat(split[0].contains("1")).isEqualTo(expected);
        assertThat(split[1].contains("2")).isEqualTo(expected);
    }

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자가 정상적으로 반환되어야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"1*2, 1&2"}, delimiter = '|')
    void unPassStringParseTest(String str) {
        // given
        assertThatThrownBy(() -> parseString(str))
                // when & then
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Invalid pattern");
    }

    public static String[] parseString(String input) {
//        final Pattern pattern = Pattern.compile("[,:]");
//        final Matcher matcher = pattern.matcher(input);
//
//        if (matcher.find() == false) {
//            throw new RuntimeException("Invalid pattern");
//        }
//        return pattern.split(input);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
            // 덧셈 구현
        }
        throw new RuntimeException("Invalid pattern");
    }
}
