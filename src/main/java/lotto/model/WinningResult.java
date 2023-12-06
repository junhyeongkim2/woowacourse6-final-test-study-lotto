package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private Lottos lottos;
    private WinningNumbers winningNumbers;

    private Map<Rank, Integer> winningResult;


    private WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult of(Lottos lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> winningResult = new EnumMap<Rank, Integer>(Rank.class);
        initializeResult(winningResult);
        List<Lotto> lottoList = lottos.getLottos();

        for (int i = 0; i < lottoList.size(); i++) {
            int matchCount = lottoList.get(i).compareWinningNumbers(winningNumbers);
            boolean isBonus = lottoList.get(i).compareBonusNumbers(winningNumbers);
            Rank rank = Rank.valueOf(matchCount, isBonus);
            System.out.println(rank);
            winningResult.put(rank, winningResult.get(rank) + 1);
        }

        return new WinningResult(winningResult);
    }

    public static void initializeResult(Map<Rank, Integer> winningResult) {
        Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, 0));
    }


    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(winningResult);
    }


}
