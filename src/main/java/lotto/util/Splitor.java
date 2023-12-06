package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitor {
    private static final String SPLIT_STRING = ",";

    public static List<Integer> splitWiningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(SPLIT_STRING)).map(Integer::parseInt).collect(Collectors.toList());
    }
}
