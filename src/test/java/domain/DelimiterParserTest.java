package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DelimiterParserTest {

    private DelimiterParser delimiterParser;

//    @BeforeEach
//    void beforeEach(){
//        delimiterParser = new DelimiterParser();
//    }

    @Test
    @DisplayName("커스텀 구분자 추출 확인")
    public void customDelimiter(){
        String input = "//isdf\n1i2d3f4";

        String reg = delimiterParser.parser(input);

        assertEquals(reg, "isdf");
    }

    @Test
    @DisplayName("기본 구분자 추출 확인")
    public void basicDelimiter(){
        String input = "1,2:3";

        String reg = delimiterParser.parser(input);

        assertEquals(reg, "[,:]");
    }
}