package org.example.calculate;

import org.example.calculate.PositivieNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

public class PositivieNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createTest() {
        assertThatCode(() -> new PositivieNumber(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 또는 음수를 전달할 수 없습니다.");
    }
}
