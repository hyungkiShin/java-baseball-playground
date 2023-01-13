package study.baseball.domain;

import study.baseball.util.Randoms;

import java.util.List;

public class Computer {

    private List<Integer> randomNumber;
    private final int MAX_LENGTH = 3;

    public Computer() {
        this.randomNumber = Randoms.pickUniqueNumbersInRange(1, 9, MAX_LENGTH);
    }

    public List<Integer> getRandomNumber() {
        return randomNumber;
    }
}
