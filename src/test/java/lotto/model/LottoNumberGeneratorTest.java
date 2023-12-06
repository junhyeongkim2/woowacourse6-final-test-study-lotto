package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.util.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest {
    @DisplayName("로또 번호 생성 오름차순 정렬 테스트")
    @Test
    void sortNumbers_EqualNumbers_Success() {
        //given
        List<Integer> numbers;
        //when
        numbers = LottoNumberGenerator.generateLottoNumbers();
        //then
        assertThat(numbers).isSorted();
    }

}
