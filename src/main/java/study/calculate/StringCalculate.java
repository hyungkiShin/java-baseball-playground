package study.calculate;

import java.util.Scanner;

public class StringCalculate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String input = scanner.nextLine();

        final String[] parseString = Formula.split(input);
        final int result = new Calculator(parseString).calculate();

        System.out.println("result = " + result);
    }
}
