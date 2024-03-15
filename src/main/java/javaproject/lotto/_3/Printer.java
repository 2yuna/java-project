package javaproject.lotto._3;

import java.util.List;

public class Printer {

    private List<Lotto> lottos;

    public static final int MAX_PRINT = 10;

    public Printer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void print() {
        for (Lotto lotto : colander()) {
            for (Integer lottoNumber : lotto.toSet()) {
                System.out.print(lottoNumber + "\t");
            }
            System.out.println();
        }

        printDot();
    }

    private boolean isExceed() {
        return lottos.size() > MAX_PRINT ? true : false;
    }

    private List<Lotto> colander() {
        if (isExceed()) {
            return lottos.subList(0, MAX_PRINT + 1);
        }
        return lottos;
    }

    private void printDot() {
        if (isExceed()) {
            System.out.println("...");
        }
    }
}