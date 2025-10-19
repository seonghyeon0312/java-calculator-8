package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SumCalculatorTest {

    public SumCalculator sumCalculator;

    @Test
    @DisplayName("합산 계산 테스트")
    void sumCalculatorTest() {
        List<Integer> numList = Arrays.asList(1,3,5,7);
        assertEquals(16, sumCalculator.sumCalculator(numList));
    }
}