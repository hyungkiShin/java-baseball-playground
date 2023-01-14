package study.baseballRemaster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumberGeneratorTest {

    @Test
    @DisplayName("배열의_길이가_3이고_중복이_없어야_한다")
    void randomNumberTest() {
        // given
        final NumberGenerator numberGenerator = new NumberGenerator();
        final List<Integer> generate = numberGenerator.generate();
        // when & then
        assertThat(generate).hasSize(3)
                .doesNotHaveDuplicates();
    }
}
