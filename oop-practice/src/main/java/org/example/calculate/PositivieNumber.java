package org.example.calculate;

public class PositivieNumber {
    private final int value;

    public PositivieNumber(int value) {
        validate(value);
        this.value = value;
    }
    private void validate(int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }
    private boolean isNegativeNumber(int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
