package study.baseballRemaster.model;

import study.baseballRemaster.util.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    private List<Integer> randomNumbers;

    public NumberGenerator() {
        this.randomNumbers = generate();
    }

    public List<Integer> generate() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(numbers);
    }

    public List<Integer> getRandomNumbers() {
        return randomNumbers;
    }
}
