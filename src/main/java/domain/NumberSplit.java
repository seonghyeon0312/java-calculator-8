package domain;

import java.util.Arrays;
import java.util.List;

public class NumberSplit {

    public static List<String> splitString(String input, String reg) {
        reg = "[" + reg + "]";
        return Arrays.asList(input.split(reg));
    }

    public static List<Integer> integerParse(List<String> list) {
        return list.stream()
                .filter(s -> !s.isBlank())
                .map(Integer::parseInt)
                .toList();
    }
}
