package study.baseballRemaster.model;

public class Judge {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(final BallStatus play) {
        if (play.isStrike()) {
            strike += 1;
        }

        if (play.isBall()) {
            ball += 1;
        }
    }

    public boolean gameEnd() {
        return this.strike == 3;
    }
}
