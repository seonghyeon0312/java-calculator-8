package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSplitTest {

    public NumberSplit numberSplit;

    @Test
    @DisplayName("구분자를 기준으로 나눈 후에 Integer로 변환 테스트")
    void splitAndParseTest() {
        String basic = "1,3,5:7";
        String custom = "1/3/5/7";

        List<Integer> numList = Arrays.asList(1,3,5,7);

        assertEquals(numList, numberSplit.splitAndParse(basic, "[,:]"));
        assertEquals(numList, numberSplit.splitAndParse(custom, "/"));
    }

}