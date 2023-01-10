package study.calculate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> first + second),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return first / second;
    });

    private String symbol;

    private BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    // 캐싱해서 순회 피하기
    private static final Map<String, Operator> SYMBOL_MAP = new HashMap<>();
    static {
        for (Operator oper : values()) {
            SYMBOL_MAP.put(oper.symbol, oper);
        }
    }

    public static Operator getSymbol(final String param) {
        if (SYMBOL_MAP.containsKey(param) == false) {
            throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
        }
        return SYMBOL_MAP.get(param);

    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }

}
