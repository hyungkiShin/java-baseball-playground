package study.baseballRemaster;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> randomNumber;

    public Balls(final NumberGenerator numberGenerator) {
        this.randomNumber = mapBall(numberGenerator.getRandomNumbers());
    }

    public Balls(final List<Integer> numbers) {
        this.randomNumber = mapBall(numbers);
    }

    public List<Ball> mapBall(final List<Integer> numbers) {
        List<Ball> result = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            result.add(new Ball(i + 1, numbers.get(i)));
        }
        return result;
    }

    public BallStatus play(final Ball ball) {
        return getBallStatus(ball);
    }

    private BallStatus getBallStatus(final Ball ball) {
        for (Ball item : randomNumber) {
            BallStatus play = item.play(ball);
            if (play.isNothing()) {
                return play;
            }
        }
        return BallStatus.NOTHING;
    }
}
