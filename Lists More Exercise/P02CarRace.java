package ListsMoreEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> raceTimes = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int rounds = (raceTimes.size() - 1) / 2;
        double firstPlayerTime = 0.0;
        double secondPlayerTime = 0.0;
        for (int i = 0; i < rounds; i++) {
            if (raceTimes.get(i) == 0) {
                firstPlayerTime *= 0.8;
            }
            firstPlayerTime += raceTimes.get(i);
            if (raceTimes.get(raceTimes.size() - 1 - i) == 0) {
                secondPlayerTime *= 0.8;
            }
            secondPlayerTime += raceTimes.get(raceTimes.size() - 1 - i);
        }
        if (firstPlayerTime>secondPlayerTime){
            System.out.printf("The winner is right with total time: %.1f%n",secondPlayerTime);
        } else {
            System.out.printf("The winner is left with total time: %.1f%n",firstPlayerTime);
        }
    }
}
