package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {


    @DisplayName("로또 비교 결과 정상 생성 테스트")
    @Test
    void WinningResult_equalResult_Success() {
        //given
        WinningResult winningResult = new WinningResult(
                Lottos.from(7000),
                new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7));
        //when
        winningResult.getResult();
        //then

    }


}
