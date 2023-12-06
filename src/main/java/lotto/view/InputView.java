package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    private static final String BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIINING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static final String VALIDATE_READ_BUY_AMOUNT_MESSAGE = "[ERROR] 잘못된 구입금액이 입력되었습니다. 다시 입력해 주세요.";
    private static final String VALIDATE_WINNING_NUMBERS_FORM = "[ERROR] 잘못된 형식의 당첨번호가 입력되었습니다. 다시 입력해 주세요.";
    private static final String VALIDATE_IS_VALID_RANGE_BONUS_NUMBER = "[ERROR] 잘못된 범위의 보너스 번호가 입력되었습니다. 다시 입력해 주세요.";
    private static final String VALIDATE_IS_INTEGER_BONUS_NUMBER = "[ERROR] 숫자가 아닌 보너스 번호가 입력되었습니다. 다시 입력해 주세요.";
    private static final String REGEX = "^\\d+(,\\d+)*$";
    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 45;


    public static int readBuyAmount() {
        System.out.println(BUY_AMOUNT_MESSAGE);
        String input = Console.readLine();
        validateReadBuyAmount(input);
        return Integer.parseInt(input);
    }

    public static String readWinningNumbers() {
        System.out.println(WIINING_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateWinningNumbersForm(input);
        return input;
    }

    public static int readBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validateIsValidRangeBonusNumber(input);
        validateIsIntegerBonusNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateReadBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_READ_BUY_AMOUNT_MESSAGE);
        }
    }

    private static void validateWinningNumbersForm(String input) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(VALIDATE_WINNING_NUMBERS_FORM);
        }
    }

    private static void validateIsValidRangeBonusNumber(String input) {
        if (Integer.parseInt(input) < START_NUMBER || Integer.parseInt(input) > END_NUMBER) {
            throw new IllegalArgumentException(VALIDATE_IS_VALID_RANGE_BONUS_NUMBER);
        }
    }

    private static void validateIsIntegerBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_IS_INTEGER_BONUS_NUMBER);
        }
    }


}
