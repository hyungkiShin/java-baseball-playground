package study.baseball.domain;

public class Ball {

    private final Integer position;
    private final Integer ballNumber;

    public Ball(final Integer position, final Integer ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BaseBallStatus play(final Ball ball) {
        if(this.equals(ball)){
            return BaseBallStatus.STRIKE;
        }

        if(ball.matchBallNumber(ballNumber)){
            return BaseBallStatus.BALL;
        }

        return BaseBallStatus.NOTHING;
    }



    // 객체에 메세지를 보내다
    private boolean matchBallNumber(final int ballNumber) {
        return this.ballNumber == ballNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Ball)) return false;
        final Ball ball = (Ball) o;
        return position.equals(ball.position) && ballNumber.equals(ball.ballNumber);
    }
}
