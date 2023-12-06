package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final String DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨번호에 중복된 숫자가 발생했습니다. 다시 입력해 주세요.";
    private final String INVALID_RANGE_WINNING_NUMBER_ERROR_MESSAGE = "[ERROR] 당첨번호에 범위를 벗어난 숫자가 발생했습니다. 다시 입력해 주세요.";
    private final String DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE = "[ERROR] 중복된 보너스 번호가 발생했습니다. 다시 입력해 주세요.";
    private final int START_NUMBER = 1;
    private final int END_NUMBER = 45;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateDuplicateWinningNumbers(winningNumbers);
        validateInValidRangeNumbers(winningNumbers);
        validateDuplicateBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContain(int lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }

    public boolean isBonus(int lottoNumber) {
        return lottoNumber == bonusNumber;
    }

    private void validateDuplicateWinningNumbers(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().collect(Collectors.toList()).size() != winningNumbers.size()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validateInValidRangeNumbers(List<Integer> winningNumbers) {
        if (!winningNumbers.stream().allMatch(number -> number >= START_NUMBER && number <= END_NUMBER)) {
            throw new IllegalArgumentException(INVALID_RANGE_WINNING_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateDuplicateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERROR_MESSAGE);
        }
    }


}
