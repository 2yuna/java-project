package javaproject.lotto._3.constant;

import java.util.Arrays;
import java.util.Objects;

public enum Reward {

    FIRST(6, 1_000_000_000, "10억", "1등"),
    SECOND(5, 20_000_000, "2000만원", "2등"),
    THIRD(4, 1_000_000, "100만원", "3등"),
    FORTH(3, 50_000, "5만원", "4등"),

    LOSE(null,  0,  "0원", "낙첨")
    ;

    private final Integer correctCount;

    private final int amount;

    private final String amountText;

    private final String rankText;

    Reward(Integer correctCount, int amount, String amountText, String rankText) {
        this.correctCount = correctCount;
        this.amount = amount;
        this.amountText = amountText;
        this.rankText = rankText;
    }

    public static Reward find(int correctCount) {
        return Arrays.stream(values())
                .filter(r -> Objects.nonNull(r.correctCount))
                .filter(r -> r.correctCount.equals(correctCount))
                .findFirst()
                .orElse(LOSE);
    }

    public void print() {
        if (this != LOSE) {
            System.out.println(rankText + ", " + amountText);
        }
    }

    public int getAmount() {
        return amount;
    }
}
