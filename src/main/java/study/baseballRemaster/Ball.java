package study.baseballRemaster;

import java.util.Objects;

public class Ball {
    private final int position;
    private final int ballNumber;

    public Ball(final int position, final int ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(final Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.ballNumber == ball.ballNumber) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        final Ball ball = (Ball) o;
        return position == ball.position && ballNumber == ball.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
