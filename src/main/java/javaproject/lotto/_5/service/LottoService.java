package javaproject.lotto._5.service;

import javaproject.lotto._5.model.Lotto;
import javaproject.lotto._5.model.Ticket;
import javaproject.lotto._5.model.constant.Reward;
import javaproject.lotto._5.repository.LottoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LottoService {

    private final LottoRepository lottoRepository;

    @Transactional
    public void buy(Ticket ticket) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticket.getCount(); i++) {
            lottos.add(Lotto.create());
        }

        lottoRepository.saveAll(lottos);
    }

    @Transactional(readOnly = true)
    public void draw() {
        Lotto drawedLotto = Lotto.create();
        List<Lotto> lottos = lottoRepository.findAll();

        int totalRewards = 0;
        for (Lotto lotto : lottos) {
            int drawCount = 0;
            for (Integer winningNumber : drawedLotto.toSet()) {
                if (lotto.toSet().contains(winningNumber)) {
                    drawCount++;
                }
            }
            Reward reward = Reward.find(drawCount);
            totalRewards += reward.getAmount();
        }

        int totalRevenue = lottos.size() * Lotto.PRICE;
        System.out.println("총 수익 : " + totalRevenue);
        System.out.println("상금 배분 : " + totalRewards);
        System.out.println("영업 이익 : " + (totalRevenue - totalRewards));
    }
}