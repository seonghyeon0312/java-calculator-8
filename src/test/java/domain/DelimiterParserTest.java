package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterParserTest {

    private DelimiterParser delimiterParser;

    @Test
    @DisplayName("커스텀 구분자 추출 확인")
    public void customDelimiter(){
        String input = "//isdf\\n1i2d3f4";
        List<String> result = Arrays.asList("isdf", "1i2d3f4");
        assertEquals(result, delimiterParser.parser(input));
    }

    @Test
    @DisplayName("기본 구분자 추출 확인")
    public void basicDelimiter(){
        String input = "1,2:3";
        List<String> result = Arrays.asList(",:", "1,2:3");

        assertEquals(result, delimiterParser.parser(input));
    }
}