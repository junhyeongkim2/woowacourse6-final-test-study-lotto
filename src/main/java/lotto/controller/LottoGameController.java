package lotto.controller;

import java.util.ArrayList;
import java.util.List;
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
        Order order = new Order(InputView.readBuyAmount());
        OutputView.printLottoQuanity(order.calculateBuyQuanity());

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < order.calculateBuyQuanity(); i++) {
            lottoList.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }

        Lottos lottos = Lottos.from(lottoList);
        OutputView.printLottoNumbers(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(Splitor.splitWiningNumbers(InputView.readWinningNumbers()),
                InputView.readBonusNumber());

        WinningResult winningResult = WinningResult.of(lottos, winningNumbers);
        OutputView.printWinningresult(winningResult.toString());
        OutputView.printTotalProfit(winningResult.calculateTotalProfit(order));


    }


}
