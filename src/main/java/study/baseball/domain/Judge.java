package study.baseball.domain;

public class Judge {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(final BaseBallStatus status) {
        if (status.isStrike()) {
            this.strike += 1;
        }
        if(status.isBall()) {
            this.ball += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
