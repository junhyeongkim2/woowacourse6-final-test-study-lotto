package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {

    public static int readBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateReadBuyAmount(input);
        return Integer.parseInt(input);
    }

    public static String readWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateWinningNumbersForm(input);
        return input;
    }

    public static int readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        validateIsValidRangeBonusNumber(input);
        validateIsIntegerBonusNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateReadBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구입금액이 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateWinningNumbersForm(String input) {
        Pattern pattern = Pattern.compile("^\\d+(,\\d+)*$");
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 형식의 당첨번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateIsValidRangeBonusNumber(String input) {
        if (Integer.parseInt(input) < 1 || Integer.parseInt(input) > 45) {
            throw new IllegalArgumentException("[ERROR] 잘못된 범위의 보너스 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }

    private static void validateIsIntegerBonusNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 보너스 번호가 입력되었습니다. 다시 입력해 주세요.");
        }
    }


}
