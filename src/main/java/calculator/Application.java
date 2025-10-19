package calculator;

import camp.nextstep.edu.missionutils.Console;
import domain.DelimiterParser;
import domain.InputValidator;
import domain.NumberSplit;
import domain.SumCalculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        try {
            InputValidator.validateFormat(input);

            List<String> parserString = DelimiterParser.parser(input);
            String reg = parserString.get(0);
            String expression = parserString.get(1);

            InputValidator.validateDelimiter(reg);

            List<String> list = NumberSplit.splitString(expression, reg);
            InputValidator.validateContent(list);

            List<Integer> numList = NumberSplit.integerParse(list);
            long result = SumCalculator.sumCalculator(numList);

            System.out.println("결과 : "+result);
        } catch (IllegalArgumentException err){
            System.out.println(err.getMessage());
            Console.close();
            throw err;
        }
    }
}
