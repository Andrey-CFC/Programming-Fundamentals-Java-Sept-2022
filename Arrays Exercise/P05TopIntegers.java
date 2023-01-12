package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isBigger = true;
        for (int i = 0; i < numbersArr.length; i++) {
             for (int j = i+1; j< numbersArr.length; j++) {
                if (numbersArr[i] <= numbersArr[j]) {
                    isBigger = false;
                    break;
                } else {
                    isBigger = true;
                }
            }
            if (i==numbersArr.length-1){
                isBigger = true;
            }
            if (isBigger) {
                System.out.printf("%d ", numbersArr[i]);
            }
        }
    }
}
