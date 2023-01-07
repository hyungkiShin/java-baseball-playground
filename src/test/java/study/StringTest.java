package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void 테스트_1과2를_로_split_했을_때_1과_2로_잘_분리되는지_확인한다() {

        // given
        String input = "1,2";

        // when
        final String[] split = input.split(",");

        // then
        assertThat(split).contains("1", "2").containsExactly("1", "2");
    }

    @Test
    void 테스트_2_괄호를_제거하고_1과2를_반환하도록_구현한다() {
        // given
        String input = "(1,2)";
        // when
        final String substring = input.substring(1, input.length() - 1);
        final String[] split = substring.split(",");

        // then
        assertThat(split).contains("1","2").containsExactly("1", "2");
    }

    @Test
    @DisplayName("charAt 메소드를 이용해 특정 위치의 문자를 가져올때 위치값을 벗어나면 StringIndexOutOfBoundsException이 발생하는지 확인한다.")
    void charAt_test_exception() {
        // given
        final String input = "abc";

        // when & then
        assertThatThrownBy(() -> input.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
