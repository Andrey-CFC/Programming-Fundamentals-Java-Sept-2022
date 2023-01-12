package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] priceArr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int entryIndex = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int sumLeft = 0;
        int sumRight = 0;
        if (command.equals("cheap")) {
            if (entryIndex >= 1) {
                for (int i = entryIndex - 1; i >= 0; i--) {
                    if (priceArr[entryIndex] > priceArr[i]) {
                        sumLeft += priceArr[i];
                    }
                }
            }
            if (entryIndex <= priceArr.length - 2) {
                for (int i = entryIndex + 1; i <= priceArr.length - 1; i++) {
                    if (priceArr[entryIndex] > priceArr[i]) {
                        sumRight += priceArr[i];
                    }
                }
            }
            if (sumLeft>=sumRight){
                System.out.printf("Left - %d%n",sumLeft);
            } else {
                System.out.printf("Right - %d%n",sumRight);
            }
        } else if (command.equals("expensive")){
            if (entryIndex >= 1) {
                for (int i = entryIndex - 1; i >= 0; i--) {
                    if (priceArr[entryIndex] <= priceArr[i]) {
                        sumLeft += priceArr[i];
                    }
                }
            }
            if (entryIndex <= priceArr.length - 2) {
                for (int i = entryIndex + 1; i <= priceArr.length - 1; i++) {
                    if (priceArr[entryIndex] <= priceArr[i]) {
                        sumRight += priceArr[i];
                    }
                }
            }
            if (sumLeft>=sumRight){
                System.out.printf("Left - %d%n",sumLeft);
            } else {
                System.out.printf("Right - %d%n",sumRight);
            }
        }
    }
}
