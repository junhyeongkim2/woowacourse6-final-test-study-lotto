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
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class LottoGameController {

    public void start() {
        Order order = new Order(repeatUntilValid(() -> InputView.readBuyAmount()));
        OutputView.printLottoQuanity(order.calculateBuyQuanity());

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < order.calculateBuyQuanity(); i++) {
            lottoList.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }

        Lottos lottos = Lottos.from(lottoList);
        OutputView.printLottoNumbers(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(
                repeatUntilValid(() -> Splitor.splitWiningNumbers(InputView.readWinningNumbers())),
                repeatUntilValid(() -> InputView.readBonusNumber()));

        WinningResult winningResult = WinningResult.of(lottos, winningNumbers);
        OutputView.printWinningresult(winningResult.toString());
        OutputView.printTotalProfit(winningResult.calculateTotalProfit(order));


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
