package javaproject.lotto._2;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Client {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int buyTicketCount = reader.buy();

        Lotto lotto = new Lotto(buyTicketCount);
        List<Set<Integer>> lottoTickets = lotto.logic();

        Printer printer = new Printer(lottoTickets);
        printer.print();

        Statistic statistic = Statistic.toFlatMap(lottoTickets);
        statistic.frequency();
        statistic.sort();
        statistic.print();
    }
}