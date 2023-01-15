package study.baseballRemaster.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Integer> userNumbers;
    private static final String DELIMITER = "";

    public Player(String userInput) {
        this.userNumbers = convertUserNumber(userInput);
    }

    private List<Integer> convertUserNumber(final String userNumbers) {
        validate(userNumbers);
        final String[] numberArrays = userNumbers.split(DELIMITER);
        return getNumberLists(numberArrays);
    }

    private List<Integer> getNumberLists(final String[] numberArrays) {
        List<Integer> numbers = new ArrayList<>();

        for (final String numberArray : numberArrays) {
            numbers.add(toInt(numberArray));
        }

        return numbers;
    }

    private void validate(final String numberArrays) {
        if (numberArrays.length() > 3) {
            throw new IllegalArgumentException("3개의 숫자만 입력해주세요.");
        }
    }

    private Integer toInt(String item) {
        return Integer.valueOf(item);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }
}
