package study.baseball.domain;

public enum BaseBallStatus {
    NOTHING, STRIKE, BALL;

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }
}
