package org.example.calculate;

public class SubtractionOperator implements NewArithmeticOperator {
    @Override
    public boolean supports(String operator) {
        return "-".equals(operator);
    }
    @Override
    public int calculate(PositivieNumber operand1, PositivieNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
