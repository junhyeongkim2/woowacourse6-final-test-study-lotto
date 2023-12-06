package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public boolean isBonusNumber(WinningNumbers winningNumbers) {
        return false;
    }
}
