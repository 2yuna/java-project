package javaproject.lotto._2;

import java.util.*;

public class Statistic {

    private List<Integer> numbers;

    Map<Integer, Integer> frequencyMap = new HashMap<>();


    public Statistic(List<Integer> numbers) {
        this.numbers = numbers;
        this.frequencyMap = frequency();
    }

    public static Statistic toFlatMap(List<Set<Integer>> collectionInts) {
        return new Statistic(collectionInts.stream()
                .flatMap(data -> data.stream())
                .toList());
    }

    public Map<Integer, Integer> frequency() {
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : numbers) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        return map;
    }

    public List<Integer> sort() {
        List keySet = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(keySet);
        keySet.sort((o1, o2) -> frequencyMap.get(o2).compareTo(frequencyMap.get(o1)));
        return keySet;
    }

    public void print() {
        System.out.println("=========== 통계 ===========");
        for (Integer key : sort()) {
            System.out.println("로또 번호: " + key + " -> " + frequencyMap.get(key));
        }
    }
}