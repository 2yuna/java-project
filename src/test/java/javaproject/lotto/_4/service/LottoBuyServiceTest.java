package javaproject.lotto._4.service;

import javaproject.lotto._4.model.Lotto;
import javaproject.lotto._4.model.Ticket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LottoBuyServiceTest {

    @Autowired
    private LottoService buyService;

    @ParameterizedTest
    @ValueSource(ints = { 3 })
    void buyLotto(int ticketCount) {
        // given
        Ticket ticket = new Ticket(ticketCount);

        // when
        List<Lotto> lottos = buyService.buy(ticket);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }

        // then
        assertThat(lottos.size()).isEqualTo(ticketCount);
    }
}