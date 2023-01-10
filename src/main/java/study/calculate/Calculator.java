package study.calculate;

import java.util.regex.Pattern;

public class Calculator {

    private static final Pattern regExp = Pattern.compile("^[0-9]*$");

    private Formula formula;

    public Calculator(final Formula formula) {
        this.formula = formula;
    }

    public int calculate() {
        int result = 0;

        Operator currentOperator = Operator.PLUS; // 첫번째 연산자는 초기화 ( 사실 아무값이나 상관없음 )

        for (String param : formula.getFormula()) {
            if (regExp.matcher(param).find() == false) { // 숫자가 아닌 경우
                currentOperator = Operator.getSymbol(param); // 연산자를 가져온다.
                continue;
            }
            result = currentOperator.operate(result, Integer.parseInt(param)); // 숫자인 경우 연산
        }
        return result; // 결과 반환
    }
}
