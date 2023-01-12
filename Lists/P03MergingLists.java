package Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mergingList = new ArrayList<>();
        int iterations = 0;
        int secondIterations = 0;
        int minSize = Math.min(firstList.size(), secondList.size());
        for (int i = 0; i < minSize; i++) {
            int numFirstList = firstList.get(i);
            int numSecondList = secondList.get(i);
            mergingList.add(numFirstList);
            mergingList.add(numSecondList);
        }
        if (firstList.size() > secondList.size()) {
            mergingList.addAll(firstList.subList(minSize, firstList.size()));
        } else if (firstList.size() < secondList.size()) {
            mergingList.addAll(secondList.subList(minSize, secondList.size()));
        }

        for (int i = 0; i < mergingList.size(); i++) {
            System.out.printf("%d ", mergingList.get(i));
        }
    }
}
