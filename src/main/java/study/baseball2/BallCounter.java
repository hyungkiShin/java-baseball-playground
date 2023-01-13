package study.baseball2;

public class BallCounter {
    private int pos;
    private int number;

    public BallCounter(final int pos, final int number) {
        this.pos = pos;
        this.number = number;
    }

    public BallStatus play(final BallCounter ball) {
        if(this.equals(ball)) {
            return BallStatus.STRIKE;
        }

        if (this.number == ball.number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof BallCounter)) return false;
        final BallCounter that = (BallCounter) o;
        return pos == that.pos && number == that.number;
    }
}
