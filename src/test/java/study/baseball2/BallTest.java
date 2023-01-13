package study.baseball2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    @Test
    @DisplayName("위치와 숫자 값이 같은경우는 STRIKE 이다")
    void ballTest() {

        //given -> computer
        BallCounter ballCounter = new BallCounter(1,2);

        // when -> user
        BallStatus status = ballCounter.play(new BallCounter(1,2));

        // then -> judge
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("위치는 다른데 숫자 값이 같은경우는 BALL 이다")
    void strikeTest() {

        //given -> computer
        BallCounter ballCounter = new BallCounter(1,2);

        // when -> user
        BallStatus status = ballCounter.play(new BallCounter(2,2));

        // then -> judge
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("위치와 숫자 값이 모두 다른 경우는 NOTHING 이다")
    void nothingTest() {

        //given -> computer
        BallCounter ballCounter = new BallCounter(1,2);

        // when -> user
        BallStatus status = ballCounter.play(new BallCounter(2,3));

        // then -> judge
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
