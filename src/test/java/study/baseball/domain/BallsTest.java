package study.baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    void ball() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1,2));
        assertThat(status).isEqualTo(BaseBallStatus.BALL);
    }

    @Test
    void nothing() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1,4));
        assertThat(status).isEqualTo(BaseBallStatus.NOTHING);
    }

    @Test
    void strike() {
        Balls answers = new Balls(Arrays.asList(1, 2, 3));
        BaseBallStatus status = answers.play(new Ball(1,1));
        assertThat(status).isEqualTo(BaseBallStatus.STRIKE);
    }
}
