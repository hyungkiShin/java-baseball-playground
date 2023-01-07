package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    void Set의_size_메소드를_활용해_Set의_크기를_확인하는_학습테스트를_구현한다() {
        // given
        final int size = numbers.size();
        // when & then
        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void Set의_contains_메소드를_활용해_1과_2_와_3의_값이_존재하는지를_확인한다(int number) {
        // given & when & then
        assertThat(numbers.contains(number)).isTrue();
    }

    @DisplayName(" 1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void test_for_CsvSource(int number, boolean expected) {
        // given & when & then
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }
}
