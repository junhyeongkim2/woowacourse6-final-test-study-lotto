package lotto.view;

import lotto.model.Lottos;

public class OutputView {

    private static final String SPACING = "\n";
    private static final String QUANITY_MESSAGE = "개를 구매했습니다.";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static void printLottoQuanity(int quanity) {
        System.out.println(SPACING + quanity + QUANITY_MESSAGE);
    }

    public static void printLottoNumbers(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public static void printWinningresult(String winningResult) {
        System.out.print(SPACING + winningResult);
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.printf(PROFIT_MESSAGE, totalProfit);
    }
}
