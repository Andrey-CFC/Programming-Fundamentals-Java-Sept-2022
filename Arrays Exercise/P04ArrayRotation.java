package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());
        int spareElement = 0;
        for (int i = 1; i <= rotations; i++) {
            for (int j = 0; j < numbersArr.length; j++) {
                if (j == 0) {
                    spareElement = numbersArr[0];
                } else {

                    numbersArr[j - 1] = numbersArr[j];
                    numbersArr[j] = spareElement;
                }
            }
        }
        for (int item : numbersArr) {
            System.out.printf("%d ", item);
        }
    }
}
