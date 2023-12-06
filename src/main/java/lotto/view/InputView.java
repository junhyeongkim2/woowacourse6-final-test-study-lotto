package lotto.view;

import camp.nextstep.edu.missionutils.Console;

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
        return input;
    }

    public static String readBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return input;
    }

    public static void validateReadBuyAmount(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 구입금액이 입력되었습니다. 다시 입력해 주세요.");
        }
    }


}
