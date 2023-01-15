package study.baseballRemaster.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.baseballRemaster.enums.BallStatus;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    private Ball ball;

    @BeforeEach
    void setup() {
        ball = new Ball(1, 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:8", "3:4", "5:6", "7:8", "9:5"}, delimiter = ':')
    @DisplayName("컴퓨터가 생성한 숫자 자릿수와 랜덤 넘버가 하나도 맞지 않을 경우 -> NOTHING")
    void nothingTest(int num1, int num2) {
        // given & when
        BallStatus status = ball.play(new Ball(num1, num2));
        // then
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    @DisplayName("컴퓨터 넘버가 1,2 유저 넘버가 2,2 일경우 -> BALL")
    void ballTest() {
        // given & when
        BallStatus status = ball.play(new Ball(2, 2));
        // then
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("컴퓨터 넘버가 1,2 유저 넘버가 1,2 일경우 -> STRIKE")
    void strikeTest() {
        // given & when
        BallStatus status = ball.play(new Ball(1, 2));
        // then
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }
}
