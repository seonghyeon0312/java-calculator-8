package domain;

public class DelimiterParser {
    static String basicDelimiter = "[,:]";

    public static String parser(String input) {
        if(input.startsWith("//") && input.contains("\n")) {
            int end = input.indexOf("\n");
            int start = 2;
            return input.substring(start, end);
        }
        return basicDelimiter;
    }
}
