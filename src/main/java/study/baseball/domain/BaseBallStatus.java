package study.baseball.domain;

public enum BaseBallStatus {
    NOTHING, STRIKE, BALL;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
