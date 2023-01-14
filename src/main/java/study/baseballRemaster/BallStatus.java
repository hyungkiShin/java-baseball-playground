package study.baseballRemaster;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isNothing() {
        return this != NOTHING;
    }
}
