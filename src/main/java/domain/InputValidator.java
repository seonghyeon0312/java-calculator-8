package domain;

import java.util.List;

public class InputValidator {
    public static void validateFormat(String input) {
        if (input == null) {
            throw new IllegalArgumentException("입력값이 null입니다.");
        }
        if (input.isBlank() && !input.isEmpty())  {
            throw new IllegalArgumentException("입력값에 공백만 포함되어 있습니다.");
        }
        if (input.startsWith("//") && !input.contains("\\n")) {
            throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
        }
        if (!input.startsWith("//") && input.contains("\\n")) {
            throw new IllegalArgumentException("커스텀 구분자 선언 없이 줄바꿈 문자가 포함되어 있습니다.");
        }
    }

    public static void validateDelimiter(String delimiter) {
        if (delimiter.chars().anyMatch(Character::isISOControl)) {
            throw new IllegalArgumentException("제어 문자는 구분자로 사용할 수 없습니다: " + delimiter);
        }

        if (delimiter.matches(".*[.\\^$*+?()\\[\\]{}|\\\\].*")) {
            throw new IllegalArgumentException("정규식 메타문자는 구분자로 사용할 수 없습니다: " + delimiter);
        }

        if (delimiter.matches(".*[0-9\\-].*")) {
            throw new IllegalArgumentException("숫자, 음수는 커스텀 구분자로 사용할 수 없습니다: " + delimiter);
        }
    }
    public static void validateContent(List<String> tokens) {
        for (String token : tokens) {
            if (!token.matches("-?\\d+")) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + token);
            }
            if (Integer.parseInt(token) < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + token);
            }
        }
    }
}
