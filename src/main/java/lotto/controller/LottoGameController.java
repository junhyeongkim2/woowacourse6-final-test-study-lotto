package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.Order;
import lotto.model.WinningResult;
import lotto.util.LottoNumberGenerator;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.Splitor;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    private Order order;
    private Lottos lottos;
    private WinningResult winningResult;

    public void start() {
        printOrder();
        printLottos();
        printResult(readWinningNumbers());
    }

    private WinningNumbers readWinningNumbers() {
        List<Integer> winningNumbers = repeatUntilValid(
                () -> Splitor.splitWiningNumbers(InputView.readWinningNumbers()));
        int bonusNumber = repeatUntilValid(() -> InputView.readBonusNumber());
        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private void printOrder() {
        order = new Order(repeatUntilValid(() -> InputView.readBuyAmount()));
        OutputView.printLottoQuanity(order.calculateBuyQuanity());
    }

    private void printLottos() {
        lottos = createLottos(order);
        OutputView.printLottoNumbers(lottos);
    }

    private void printResult(WinningNumbers winningNumbers) {
        winningResult = WinningResult.of(lottos, winningNumbers);
        OutputView.printWinningresult(winningResult.toString());
        OutputView.printTotalProfit(winningResult.calculateTotalProfit(order));
    }

    private Lottos createLottos(Order order) {
        List<Lotto> tempLottos = new ArrayList<>();
        for (int i = 0; i < order.calculateBuyQuanity(); i++) {
            tempLottos.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }
        Lottos lottos = Lottos.from(tempLottos);
        return lottos;
    }

    private <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return repeatUntilValid(function);
        }
    }


}
