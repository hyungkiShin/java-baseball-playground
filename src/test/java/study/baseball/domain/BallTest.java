package study.baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BallTest {

    private Ball ball;

    @Test
    void 컴퓨터가_제시한_세자리의_숫자중에_한자리만_다르다면_볼_이어야_한다() {
        // given
        Ball ball = new Ball(1,4);

        // when
        BaseBallStatus status = ball.play(new Ball(2,4));

        // then
        assertThat(status).isEqualTo(BaseBallStatus.BALL);
    }

    @Test
    void 컴퓨터가_제시한_세자리의_숫자중에_같은숫자가_없다면_다르다면_낫싱_이어야_한다() {
        // given
        Ball ball = new Ball(1,4);

        // when
        BaseBallStatus status = ball.play(new Ball(2,3));

        // then
        assertThat(status).isEqualTo(BaseBallStatus.NOTHING);
    }

    @Test
    void 컴퓨터가_제시한_숫자와_모두_같다면_스트라이크_이어야_한다() {
        // given
        Ball ball = new Ball(1,4);

        // when
        BaseBallStatus status = ball.play(new Ball(1,4));

        // then
        assertThat(status).isEqualTo(BaseBallStatus.STRIKE);
    }
}
