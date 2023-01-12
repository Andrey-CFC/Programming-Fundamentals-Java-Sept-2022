package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        int[] bomb = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int bombNumber = bomb[0];
        int bombPower = bomb[1];
        int sum = 0;
        int differenceMinus = 0;
        int differencePlus = 0;
        for (int i = 0; i < numbersList.size(); i++) {
            if (bombNumber == numbersList.get(i)) {
                numbersList.remove(i);
                for (int j = 1; j <= bombPower; j++) {
                    if (i - differenceMinus<= numbersList.size() - 1) {
                        numbersList.remove(i - differenceMinus);
                    }
                    if (i - 1 - differenceMinus >= 0) {
                        numbersList.remove(i - 1 - differenceMinus);
                        differenceMinus++;
                    }
                }
                i=-1;
            }
        }
        for (int i = 0; i < numbersList.size(); i++) {
            sum += numbersList.get(i);

        }
        System.out.println(sum);

    }
}
