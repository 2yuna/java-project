package javaproject.lotto._2;

import java.util.List;
import java.util.Set;

public class Printer {

    private List<Set<Integer>> intCollectionArr;

    public static final int MAX_PRINT = 10;

    public Printer(List<Set<Integer>> intCollectionArr) {
        this.intCollectionArr = intCollectionArr;
    }

    public void print() {
        for (Set<Integer> printIntCollection : colander()) {
            for (Integer printInt : printIntCollection) {
                System.out.print(printInt + "\t");
            }
            System.out.println();
        }

        printDot();
    }

    private boolean isExceed() {
        return intCollectionArr.size() > MAX_PRINT ? true : false;
    }

    private List<Set<Integer>> colander() {
        if (isExceed()) {
            return intCollectionArr.subList(0, MAX_PRINT + 1);
        }
        return intCollectionArr;
    }

    private void printDot() {
        if (isExceed()) {
            System.out.println("...");
        }
    }
}
