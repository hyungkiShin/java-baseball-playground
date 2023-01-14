package study.baseballRemaster;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    @Test
    @DisplayName("123 을 입력했을때 1,2 이면 ball")
    void ballTest() {
        // given
        Balls balls = new Balls(Arrays.asList(1,2,3));
        // when
        BallStatus status = balls.play(new Ball(1,2));
        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("123 을 입력했을때 1,1 이면 strike")
    void strikeTest() {
        // given
        Balls balls = new Balls(Arrays.asList(1,2,3));
        // when
        BallStatus status = balls.play(new Ball(1,1));
        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("123 을 입력했을때 1,1 이면 strike")
    void nothingTest() {
        // given
        Balls balls = new Balls(Arrays.asList(1,2,3));
        // when
        BallStatus status = balls.play(new Ball(1,4));
        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
