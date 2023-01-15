package study.baseballRemaster.controller;

import study.baseballRemaster.enums.GameStatus;
import study.baseballRemaster.model.Game;
import study.baseballRemaster.model.Judge;
import study.baseballRemaster.model.Player;
import study.baseballRemaster.view.GamePrevView;
import study.baseballRemaster.view.GameResultView;

public class GameController {

    public static void init() {
        do {
            playGame();
        } while (GameStatus.PLAY == GamePrevView.continueGame());
        GameResultView.endGameMessage();
    }

    private static void playGame() {
        final Game game = new Game();
        Judge judge;
        do {
            Player player = new Player(GamePrevView.playerNumbers());
            judge = game.start(player);
            GameResultView.statistics(judge);
        } while (judge.gameEnd() == false);
    }

}
