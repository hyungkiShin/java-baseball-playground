package study.baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {

    @Test
    void 컴퓨터는_중복되지_않는_3자리_숫자를_랜덤하게_생성_해야_한다() {
        // given
        Computer computer = new Computer();
        // when & then
        final List<Integer> randomNumber = computer.getRandomNumber();
        assertThat(randomNumber)
                .hasSize(3)
                .containsAnyOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .doesNotHaveDuplicates();
    }
}