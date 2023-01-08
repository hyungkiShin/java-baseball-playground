package study.calculate;

public class Calculator {

    private String[] input;

    public Calculator(final String[] input) {
        this.input = input;
    }

    public int calculate() {
        int result = Integer.parseInt(input[0]);

        for (int i = 1; i < input.length; i += 2) {
            result = Operator.of(input[i]).operate(result, Integer.parseInt(input[i + 1]));
        }

        return result;
    }

}
