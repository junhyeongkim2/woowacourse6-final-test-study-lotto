package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicateWinningNumbers();
        validateInValidRangeNumbers();
        validateDuplicateBonusNumber();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isBonus(int lottoNumber) {
        return lottoNumber == bonusNumber;
    }

    public void validateDuplicateWinningNumbers() {
        if (winningNumbers.stream().distinct().collect(Collectors.toList()).size() != winningNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 발생했습니다. 다시 입력해 주세요.");
        }
    }

    public void validateInValidRangeNumbers() {
        if (!winningNumbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨번호에 중복된 숫자가 발생했습니다. 다시 입력해 주세요.");
        }
    }

    public void validateDuplicateBonusNumber() {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복된 보너스 번호가 발생했습니다. 다시 입력해 주세요.");
        }
    }


}
