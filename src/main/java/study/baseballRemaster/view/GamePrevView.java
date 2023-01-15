package study.baseballRemaster.view;

import study.baseballRemaster.enums.GameStatus;
import study.baseballRemaster.util.Console;

public class GamePrevView {

    public static String readLine(){
        return Console.readLine();
    }

    public static String playerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public static GameStatus continueGame() {
        System.out.println("게임을 새로 시작하려면1, 종료하려면 2를 입력하세요.");
        return GameStatus.from(readLine());
    }
}
