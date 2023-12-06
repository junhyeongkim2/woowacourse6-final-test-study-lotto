package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능


    @DisplayName("로또 번호와 winningNumbers 5등 테스트")
    @Test
    void compareNumbers_MatchThree_Success() {
        //given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 7, 8, 9), 10);
        //when
        int matchCount = lotto.compareWinningNumbers(winningNumbers);
        boolean isBonus = lotto.compareBonusNumbers(winningNumbers);
        //then
        assertThat(matchCount).isEqualTo(3);
        assertThat(isBonus).isFalse();
    }

    @DisplayName("로또 번호 오름차순 정렬 테스트")
    @Test
    void sortNumbers_EqualNumbers_Success() {
        //given
        Lotto lotto;
        //when
        lotto = new Lotto(List.of(1, 2, 3, 8, 5, 6));
        //then
        assertThat(lotto.getNumbers()).isEqualTo(List.of(1,2,3,5,6,8));
    }


}