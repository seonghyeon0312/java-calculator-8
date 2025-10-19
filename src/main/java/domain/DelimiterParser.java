package domain;

import java.util.List;
import java.util.ArrayList;

public class DelimiterParser {

    public static List<String> parser(String input) {
        List<String> result = new ArrayList<>();
        if(input.startsWith("//") && input.contains("\\n")) {
            int end = input.indexOf("\\n");
            int start = 2;
            String reg = input.substring(start, end-1);
            result.add(reg);
            result.add(input.substring(end+2));
            return result;
        }
        result.add(",:");
        result.add(input);
        return result;
    }
}
