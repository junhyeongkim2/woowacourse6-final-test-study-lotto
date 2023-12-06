package lotto.view;

import lotto.model.Lottos;

public class OutputView {

    public static void printLottoQuanity(int quanity) {
        System.out.println("\n" + quanity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
        System.out.println();
    }

    public static void printWinningresult(String winningResult) {
        System.out.print("\n" + winningResult);
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.printf("총 수익률은 %.1f%%입니다.", totalProfit);
    }
}
