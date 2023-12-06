package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("로또 6000원 구매 로또 발행 기능 테스트")
    @Test
    void lottos_IsCreateSixLotto_Success() {
        //given
        Lottos lottos;
        //when
        lottos = Lottos.from(6000);
        //then
        assertThat(lottos.getLottos().size()).isEqualTo(6);
    }

}
