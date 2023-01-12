package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P08MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numbersArr.length - 1; i++) {
            for (int j = i + 1; j < numbersArr.length; j++) {
                if (numbersArr[i] + numbersArr[j] == target) {
                    System.out.printf("%d %d%n", numbersArr[i], numbersArr[j]);
                }
            }
        }
    }
}
