package study.baseballRemaster.view;

import study.baseballRemaster.model.Judge;

public class GameResultView {

    public static void statistics(final Judge result) {
        if (result.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        if (result.hasBall() && result.hasStrike()) {
            System.out.printf("%d볼 %d스트라이크%n", result.getBall(), result.getStrike());
            return;
        }
        if (result.hasBall()) {
            System.out.printf("%d볼%n", result.getBall());
            return;
        }
        System.out.printf("%d스트라이크%n", result.getStrike());
    }

    public static void endGameMessage() {
        System.out.println("게임 종료");
    }
}
