package javaproject.lotto._3;

import javaproject.lotto._3.constant.Reward;

import java.util.*;

public class Result {

    private Lotto winning;

    private Money usedMoney;

    private Money totalRewards;

    public Result(List<Lotto> purchasedLottos) {
        this.winning = Lotto.create();
        this.usedMoney = new Money(purchasedLottos.size() * Lotto.PRICE);
        this.totalRewards = new Money(calculateTotalRewards(purchasedLottos));
    }

    public void print() {
        System.out.println("=========== 결과 ===========");
        System.out.println("당첨 번호: " + winning.toString());
        System.out.println("총 구매 비용 = " + usedMoney.toUnitMoney() + "원");
        System.out.println("총 당첨 금액 = " + totalRewards.toUnitMoney() + "원");
    }

    private int calculateTotalRewards(List<Lotto> purchasedLottos) {
        int totalRewards = 0;
        for (int i = 0; i < purchasedLottos.size(); i++) {
            int correctCount = calculateCorrectCount(purchasedLottos.get(i));
            Reward reward = Reward.find(correctCount);
            totalRewards += reward.getAmount();

            reward.print();
        }
        return totalRewards;
    }

    private int calculateCorrectCount(Lotto purchasedLotto) {
        int drawCount = 0;
        for (Integer lottoNumber : purchasedLotto.toSet()) {
            for (Integer winningNumber : winning.toSet()) {
                if (lottoNumber == winningNumber) {
                    drawCount++;
                }
            }
        }

        return drawCount;
    }
}