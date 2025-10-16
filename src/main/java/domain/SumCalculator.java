package domain;

import java.util.List;

public class SumCalculator {

    public static long sumCalculator(List<Integer> numList){
        long sum = 0;

        for(Integer num : numList){
            sum += num;
        }

        return sum;
    }
}
