package study.baseballRemaster.enums;

public enum GameStatus {
    PLAY,
    END;

    public static GameStatus from(String answer) {
        if("1".equals(answer)){
            return PLAY;
        }
        return END;
    }
}
