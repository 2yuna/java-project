package javaproject.lotto._4.service;

import javaproject.lotto._4.model.Lotto;
import javaproject.lotto._4.model.Ticket;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LottoService {

    public List<Lotto> buy(Ticket ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket.getCount(); i++) {
            lottos.add(Lotto.create());
        }

        return lottos;
    }
}