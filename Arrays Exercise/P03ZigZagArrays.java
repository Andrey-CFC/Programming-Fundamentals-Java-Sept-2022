package ArraysEx;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int elements = Integer.parseInt(scanner.nextLine());
        int[] firstArr = new int[elements];
        int[] secondArr = new int[elements];
        int[] currentArr = new int[2];
        for (int i = 0; i < elements; i++) {
            String currentLine = scanner.nextLine();
            currentArr = Arrays.stream(currentLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            if (i % 2 == 1) {
                secondArr[i] = currentArr[0];
                firstArr[i] = currentArr[1];
            } else {
                secondArr[i] = currentArr[1];
                firstArr[i] = currentArr[0];
            }
        }
        for (int item : firstArr) {
            System.out.printf("%d ", item);
        }
        System.out.println();
        for (int item : secondArr) {
            System.out.printf("%d ", item);
        }
    }
}
