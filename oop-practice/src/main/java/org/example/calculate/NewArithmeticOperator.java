package org.example.calculate;

public interface NewArithmeticOperator {
    boolean supports(String operator);
    int calculate(PositivieNumber operand1, PositivieNumber operand2);
}
