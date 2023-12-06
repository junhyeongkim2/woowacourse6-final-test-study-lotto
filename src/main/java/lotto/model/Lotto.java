package lotto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final String DUPLICATE_LOTTO_NUMBER = "[ERROR] 로또 번호에 중복이 발생했습니다.";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(DUPLICATE_LOTTO_NUMBER);
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
