package study.calculate;

import java.util.Scanner;

public class StringCalculate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        final Calculator calculator = new Calculator(new Formula(input));
        final int calculate = calculator.calculate();

        System.out.println("result = " + calculate);
    }
}
