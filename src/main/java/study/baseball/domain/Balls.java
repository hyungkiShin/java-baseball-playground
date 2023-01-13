package study.baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> answers;

    public Balls(final List<Integer> answers) {
        this.answers = mapBall(answers);
    }

    private static List<Ball> mapBall(final List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public Judge play(List<Integer> balls) {
        Balls userBalls = new Balls(balls);
        Judge result = new Judge();
        for (Ball answer : answers) {
            BaseBallStatus status = userBalls.play(answer);
            result.report(status);
        }
        return result;
    }

    public BaseBallStatus play(final Ball userBall) {
        return answers.stream()
                .map(answer -> answer.play(userBall))
                .filter(BaseBallStatus::isNotNothing)
                .findFirst()
                .orElse(BaseBallStatus.NOTHING);
    }
}
