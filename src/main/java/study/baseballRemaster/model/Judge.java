package study.baseballRemaster.model;

import study.baseballRemaster.enums.BallStatus;

public class Judge {

    private int strike = 0;
    private int ball = 0;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasBall(){
        return ball > 0;
    }

    public boolean hasStrike(){
        return strike > 0;
    }

    public boolean isNothing(){
        return strike == 0 && ball == 0;
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
