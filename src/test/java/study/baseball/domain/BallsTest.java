package study.baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void play_nothing() {
        // given
        final Balls answers = new Balls(Arrays.asList(1, 2, 3));

        // when
        Judge result = answers.play(Arrays.asList(4, 5, 6));

        // then
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    void play_1strike_1ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        Judge result = answers.play(Arrays.asList(1, 4, 2));
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    void play_3strike() {
        Balls answers = new Balls(Arrays.asList(1,2,3));
        Judge result = answers.play(Arrays.asList(1, 2, 3));
        assertThat(result.getStrike()).isEqualTo(3);
        assertThat(result.isGameEnd()).isTrue();
    }

    @Test
    void ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1, 2));
        assertThat(status).isEqualTo(BaseBallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1, 4));
        assertThat(status).isEqualTo(BaseBallStatus.NOTHING);
    }

    @Test
    void strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1, 1));
        assertThat(status).isEqualTo(BaseBallStatus.STRIKE);
    }
}
