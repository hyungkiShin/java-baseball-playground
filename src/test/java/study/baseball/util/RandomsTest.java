package study.baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomsTest {

    private static final int MAX_LENGTH = 3;
    @Test
    @DisplayName("중복없는 3자리 숫자배열을 생성한다")
    void 중복없는_3자리_숫자배열을_생성한다() {
        // given
        final List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 9, MAX_LENGTH);
        // when & then
        assertThat(integers)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }
}