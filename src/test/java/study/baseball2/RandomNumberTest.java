package study.baseball2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.baseball.util.Randoms;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    void 임의의_중복없는_숫자_1에서부터_9까지를_반환한다() {
        // given
        final List<Integer> com = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        // when & then
        assertThat(com)
                .hasSize(3)
                .doesNotHaveDuplicates();
    }
}
