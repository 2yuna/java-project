package javaproject.lotto._2;

import java.util.List;
import java.util.Set;

public class Printer {

    private List<Set<Integer>> numberSetList;

    public static final int MAX_PRINT = 10;

    public Printer(List<Set<Integer>> numberSetList) {
        this.numberSetList = numberSetList;
    }

    public void print() {
        for (Set<Integer> printNumberSet : colander()) {
            for (Integer printNumber : printNumberSet) {
                System.out.print(printNumber + "\t");
            }
            System.out.println();
        }

        printDot();
    }

    private boolean isExceed() {
        return numberSetList.size() > MAX_PRINT ? true : false;
    }

    private List<Set<Integer>> colander() {
        if (isExceed()) {
            return numberSetList.subList(0, MAX_PRINT + 1);
        }
        return numberSetList;
    }

    private void printDot() {
        if (isExceed()) {
            System.out.println("...");
        }
    }
}