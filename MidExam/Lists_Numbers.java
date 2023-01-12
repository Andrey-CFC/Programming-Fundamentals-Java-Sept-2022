package MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class Lists_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> topList = new ArrayList<>();
        int counter = 0;
        double listSum = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            listSum += numbersList.get(i);
        }
        double average = listSum / numbersList.size();
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) > average) {
                topList.add(numbersList.get(i));
                counter++;
            }
        }
        if (counter >= 1) {
            Collections.sort(topList);
            Collections.reverse(topList);
            if (counter > 5) {
                counter = 5;
            }
            int[] topArr = new int[counter];
            for (int i = 0; i < counter; i++) {
                topArr[i] = topList.get(i);
            }
            if (counter > 1) {
                for (int i = 0; i < counter - 1; i++) {
                    System.out.printf("%d ", topArr[i]);
                }
            }
            System.out.printf("%d", topArr[counter - 1]);
        } else {
            System.out.printf("No");
        }
    }
}
