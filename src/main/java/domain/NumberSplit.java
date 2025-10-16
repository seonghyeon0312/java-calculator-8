package domain;

import java.util.Arrays;
import java.util.List;

public class NumberSplit {

    public static List<String> splitString(String input, String reg) {
        return Arrays.asList(input.split(reg));
    }

    public static List<Integer> integerParse(List<String> list) {
        return list.stream()
                .map(Integer::parseInt)
                .toList();
    }
}
