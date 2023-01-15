package study.baseballRemaster.model;

public class Game {

    private final Balls balls;

    public Game() {
        this.balls = new Balls(new NumberGenerator());
    }

    public Judge start(final Player player) {
        return balls.play(player);
    }
}
