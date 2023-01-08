package study.calculate;

public class Formula {

    private static final String DELIMITER = " ";

    public static String[] split(String input) {
        if (validator(input)) {
            throw new IllegalArgumentException("입력값이 null 이거나 빈 공백 문자입니다.");
        }
        return input.split(DELIMITER);
    }

    private static boolean validator(String input) {
        return input == null || input.isEmpty() || input.startsWith(DELIMITER);
    }
}
