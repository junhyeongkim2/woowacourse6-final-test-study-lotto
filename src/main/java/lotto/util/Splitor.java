package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitor {
    public static List<Integer> splitWiningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(",")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
