package javaproject.lotto._5.integration.service;

import javaproject.lotto._5.model.Ticket;
import javaproject.lotto._5.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LottoServiceTest {

    @Autowired
    LottoService lottoService;

    @Test
    @DisplayName("로또 구매")
    void 로또_구매() {
        lottoService.buy(new Ticket(30));
    }

    @Test
    @DisplayName("로또 추첨")
    void 로또_추첨() {
        lottoService.draw();
    }
}