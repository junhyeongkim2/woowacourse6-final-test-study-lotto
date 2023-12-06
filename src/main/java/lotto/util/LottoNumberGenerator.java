package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberGenerator {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LIMIT = 6;

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.addAll(Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LIMIT));
        sortNumbers(numbers);
        return numbers;
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }


}
