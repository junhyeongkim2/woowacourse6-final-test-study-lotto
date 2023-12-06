package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<Rank, Integer> compareNumbers(Map<Rank, Integer> winningResult, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            Rank rank = Rank.valueOf(lotto.compareWinningNumbers(winningNumbers),
                    lotto.compareBonusNumbers(winningNumbers));
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
        return winningResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        lottos.stream().forEach(lotto -> sb.append(lotto.getNumbers().toString()+"\n"));
        return sb.toString();
    }
}
