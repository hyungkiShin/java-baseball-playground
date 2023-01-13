package study.baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls;

    public Balls(final List<Integer> answers) {
        this.balls = mapBall(answers);
    }

    private static List<Ball> mapBall(final List<Integer> answers) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            balls.add(new Ball(i + 1, answers.get(i)));
        }
        return balls;
    }

    public BaseBallStatus play(final Ball userBall) {
        return balls.stream()
                .map(answer -> answer.play(userBall))
                .filter(BaseBallStatus::isNotNothing)
                .findFirst()
                .orElse(BaseBallStatus.NOTHING);
    }
}
