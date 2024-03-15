package javaproject.lotto._2;

import java.util.*;

public class Lotto {

    private int ticketCount;

    private List<Set<Integer>> tickets = new ArrayList<>();

    public static final Random RANDOM = new Random();
    public static final int ROW_COUNT = 6;

    public Lotto(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public List<Set<Integer>> logic() {
        for (int i = 0; i < ticketCount; i++) {
            Set<Integer> lotto = new HashSet<>();
            while (lotto.size() < ROW_COUNT) {
                int lottoNumber = RANDOM.nextInt(45) + 1;
                lotto.add(lottoNumber);
            }
            tickets.add(lotto);
        }
        return tickets;
    }
}
