package lotto.model;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class WinningResultTest {


    @DisplayName("로또 비교 결과 정상 생성 테스트")
    @Test
    void WinningResult_equalResult_Success() {
        //given
        WinningResult winningResult;
        //when
        winningResult = WinningResult.of(
                Lottos.from(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7)))),
                new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7));
        Map<Rank, Integer> result = winningResult.getResult();
        //then
        assertThat(result.get(Rank.FIRST)).isEqualTo(1);
        assertThat(result.get(Rank.THIRD)).isEqualTo(1);
    }


    @DisplayName("로또 총 수익률 정상 계산 테스트")
    @Test
    void calculateTotalProfit_equalResult_Success() {
        //given
        WinningResult winningResult;
        //when
        winningResult = WinningResult.of(
                Lottos.from(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7)))),
                new WinningNumbers(List.of(5, 6, 7, 11, 12, 13), 9));
        Map<Rank, Integer> result = winningResult.getResult();
        //then
        double totalProfit = winningResult.calculateTotalProfit(new Order(8000));
        assertThat(totalProfit).isEqualTo(62.5);

    }


}
