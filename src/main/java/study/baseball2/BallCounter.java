package study.baseball2;

public class BallCounter {
    private int pos;
    private int number;

    public BallCounter(final int pos, final int number) {
        this.pos = pos;
        this.number = number;
    }

    public BallStatus play(final BallCounter ball) {
        if(this.number == ball.number && this.pos == ball.pos) {
            return BallStatus.STRIKE;
        }

        if (this.number == ball.number) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }
}
