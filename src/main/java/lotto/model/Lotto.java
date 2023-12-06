package lotto.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int compareWinningNumbers(WinningNumbers winningNumbers) {
        return (int) numbers.stream().filter(number -> winningNumbers.isContain(number)).count();
    }

    public boolean compareBonusNumbers(WinningNumbers winningNumbers) {
        return numbers.stream().allMatch(number -> winningNumbers.isBonus(number));
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


}
