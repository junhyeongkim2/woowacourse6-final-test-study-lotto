package lotto.view;

import lotto.model.Lottos;

public class OutputView {

    public static void printLottoQuanity(int quanity) {
        System.out.println("\n"+quanity + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(Lottos lottos) {
        lottos.getLottos().stream().forEach(lotto -> System.out.println(lotto.getNumbers()));
    }


}
