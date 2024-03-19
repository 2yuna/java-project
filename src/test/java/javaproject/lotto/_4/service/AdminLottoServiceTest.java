package javaproject.lotto._4.service;

import javaproject.lotto._3.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AdminLottoServiceTest {

    @Autowired
    private AdminLottoService adminLottoService;
    
    @Test
    @DisplayName("로또를 추첨하면 당첨번호를 반환한다.")
    void lottoDraw() {
        // given & when
        Lotto winning = adminLottoService.draw();
        System.out.println(winning);

        // then
        assertThat(winning).isInstanceOf(Lotto.class);
    }
}