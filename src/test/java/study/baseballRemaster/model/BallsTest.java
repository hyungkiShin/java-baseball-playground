package study.baseballRemaster.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.baseballRemaster.enums.BallStatus;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BallsTest {

    private Balls balls;

    @BeforeEach
    void setUp() {
        balls = new Balls(Arrays.asList(2,4,5));
    }

    @Test
    @DisplayName("컴퓨터가 245 일때 유저의 첫번째 자리가 1 숫자가 4 이면 ball")
    void ballTest() {
        // given & when
        BallStatus status = balls.play(new Ball(1,4));
        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터가 245 일때 유저의 첫번째 자리가 1 숫자가 2 이면 strike")
    void strikeTest() {
        // given & when
        BallStatus status = balls.play(new Ball(1,2));
        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("컴퓨터가 245 일때 유저의 첫번째 자리가 1 숫자가 4 이면 nothing")
    void nothingTest() {
        // given & when
        BallStatus status = balls.play(new Ball(1,4));
        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("사용자가 123 을 입력할때 컴퓨터의 수가 245 이면 -> 1 BALL")
    void upgradeBallTest() {
        // given & when
        Judge report = balls.play(new Player("123"));
        // then
        assertThat(report.getStrike()).isZero();
        assertThat(report.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("사용자가 245 을 입력할때 컴퓨터의 수가 245 이면 -> 3 STRIKE")
    void upgradeStrikeTest() {
        // given & when
        Judge report = balls.play(new Player("245"));
        // then
        assertThat(report.getStrike()).isEqualTo(3);
        assertThat(report.getBall()).isZero();
        assertThat(report.gameEnd()).isTrue();
    }

    @Test
    @DisplayName("사용자가 245 을 입력할때 컴퓨터의 수가 245 이면 -> NOTHING")
    void upgradeNothingTest() {
        // given & when
        Judge report = balls.play(new Player("678"));
        // then
        assertThat(report.getStrike()).isZero();
        assertThat(report.getBall()).isZero();
    }
}
