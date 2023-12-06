package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.util.LottoNumberGenerator;
import lotto.model.Lottos;
import lotto.model.WinningNumbers;
import lotto.util.Splitor;
import lotto.view.InputView;
import lotto.view.OutputView;
import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;

public class LottoGameController {

    public void start() {
        int buyAmount = Integer.parseInt(InputView.readBuyAmount());
        int quanity = calculateBuyQuanity(buyAmount);
        OutputView.printLottoQuanity(quanity);

        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quanity; i++) {
            lottoList.add(new Lotto(LottoNumberGenerator.generateLottoNumbers()));
        }

        Lottos lottos = Lottos.from(lottoList);
        OutputView.printLottoNumbers(lottos);

        WinningNumbers winningNumbers = new WinningNumbers(Splitor.splitWiningNumbers(InputView.readWinningNumbers()),
                Integer.parseInt(InputView.readBonusNumber()));


    }

    public int calculateBuyQuanity(int buyAmount) {
        return buyAmount / 1000;
    }


}
