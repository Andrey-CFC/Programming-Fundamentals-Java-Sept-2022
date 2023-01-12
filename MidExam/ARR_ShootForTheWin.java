package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ARR_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int counter = 0;
        while (!command.equals("End")) {
            int currentIndex = Integer.parseInt(command);
            if (currentIndex<0||currentIndex> targets.length-1){
                command = scanner.nextLine();
                continue;
            }
            if (targets[currentIndex]!=-1){
                int currentValue = targets[currentIndex];
                for (int i = 0; i < targets.length; i++) {
                    if (targets[i] != -1) {
                        if (i != currentIndex && targets[i] > currentValue) {
                            targets[i] -= currentValue;
                        } else if (i != currentIndex && targets[i] <= currentValue) {
                            targets[i] += currentValue;
                        }
                    }
                }
                targets[currentIndex] = -1;
                counter++;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", counter);
        if (targets.length > 1) {
            for (int i = 0; i < targets.length-1; i++) {
                System.out.printf("%d ", targets[i]);
            }
        }
        System.out.printf("%d", targets[targets.length - 1]);
    }
}
