package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P07MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter = 1;
        int element = 0;
        int max = 1;
        for (int i = numbersArr.length - 1; i > 0; i--) {
            if (numbersArr[i] == numbersArr[i - 1]) {
                counter += 1;
                if (max <= counter) {
                    element = numbersArr[i];
                    max = counter;
                }
            } else {
                counter = 1;
            }
        }
        for (int i = 1; i <= max; i++) {
            System.out.printf("%d ", element);
        }
    }
}
