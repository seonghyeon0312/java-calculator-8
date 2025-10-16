package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSplit {

    public static List<Integer> splitAndParse(String input, String reg){
        return Arrays.stream(input.split(reg))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
