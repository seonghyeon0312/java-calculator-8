package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private InputValidator validator;

    @BeforeEach
    void setUp() {
        validator = new InputValidator();
    }

    @Test
    @DisplayName("입력이 null이면 IllegalArgumentException 발생")
    void validateFormat_nullInput_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat(null));
    }

    @Test
    @DisplayName("공백만 있는 문자열은 IllegalArgumentException 발생")
    void validateFormat_blankOnly_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat(" "));
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat("\t\n "));
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat("          "));
    }

    @Test
    @DisplayName("빈 문자열은 예외 없이 통과해야 함")
    void validateFormat_emptyString_passes() {
        assertDoesNotThrow(() -> validator.validateFormat(""));
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식이면 IllegalArgumentException 발생")
    void validateFormat_invalidCustomDelimiter_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat("//*1*2*3"));
        assertThrows(IllegalArgumentException.class, () -> validator.validateFormat("*\n1*2*3"));
    }

    @Test
    @DisplayName("올바른 커스텀 구분자 형식은 예외 없이 통과해야 함")
    void validateFormat_validCustomDelimiter_passes() {
        assertDoesNotThrow(() -> validator.validateFormat("//\\\n1;2;3"));
    }



    @Test
    @DisplayName("숫자가 아닌 값이 포함되면 IllegalArgumentException 발생")
    void validateContent_nonNumeric_throwsException() {
        List<String> tokens = List.of("1", "a", "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateContent(tokens));
    }

    @Test
    @DisplayName("음수가 포함되면 IllegalArgumentException 발생")
    void validateContent_negativeNumber_throwsException() {
        List<String> tokens = List.of("1", "-2", "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateContent(tokens));
    }

    @Test
    @DisplayName("모든 토큰이 양의 정수일 때 예외 없이 통과")
    void validateContent_allPositive_passes() {
        List<String> tokens = List.of("1", "2", "3");
        assertDoesNotThrow(() -> validator.validateContent(tokens));
    }

    @Test
    @DisplayName("사용 불가능한 구분자 목록 검증")
    public void validateDelimiter(){
        String reg = "\b";
        String num = "4";
        String minus = "-3";

        assertThrows(IllegalArgumentException.class, () -> validator.validateDelimiter(reg));
        assertThrows(IllegalArgumentException.class, () -> validator.validateDelimiter(num));
        assertThrows(IllegalArgumentException.class, () -> validator.validateDelimiter(minus));
    }
}