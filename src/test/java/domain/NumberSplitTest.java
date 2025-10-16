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

        List<String> list = Arrays.asList("1","3","5","7");
        assertEquals(list, numberSplit.splitString(basic, "[,:]"));
        assertEquals(list, numberSplit.splitString(custom, "/"));
        assertEquals(Arrays.asList(1,3,5,7), numberSplit.integerParse(list));
    }

}