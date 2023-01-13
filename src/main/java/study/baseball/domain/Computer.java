package study.baseball.domain;

import study.baseball.util.Randoms;

import java.util.List;

public class Computer {

    private List<Integer> randomNumber;

    private final int MAX_LENGTH = 3;
    private final int MIN = 1;
    private final int MAX = 9;

    public Computer() {
        this.randomNumber = Randoms.pickUniqueNumbersInRange(MIN, MAX, MAX_LENGTH);
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
