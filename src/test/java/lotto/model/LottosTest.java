package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("로또 2개 생성 테스트")
    @Test
    void lottos_IsCreateSixLotto_Success() {
        //given
        Lottos lottos;
        //when
        lottos = Lottos.from(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7))));
        //then
        assertThat(lottos.getLottos().size()).isEqualTo(2);
    }

}
