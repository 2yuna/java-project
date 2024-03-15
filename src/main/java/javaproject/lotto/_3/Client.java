package javaproject.lotto._3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int buyTicketCount = reader.input();

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyTicketCount; i++) {
            lottos.add(Lotto.create());
        }

        Printer printer = new Printer(lottos);
        printer.print();

        Statistic statistic = Statistic.calculate(lottos);
        statistic.sort();
        statistic.print();

        Result result = new Result(lottos);
        result.print();
    }
}