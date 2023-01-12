package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        int counter = 0;
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < numbersArr.length; i++) {
            for (int j = i + 1; j < numbersArr.length; j++) {
                sumRight += numbersArr[j];
            }
            for (int l = i - 1; l >= 0; l--) {
                sumLeft += numbersArr[l];
            }
            if (sumLeft == sumRight) {
                System.out.println(i);
                counter++;
            }
            sumLeft = 0;
            sumRight = 0;
        }
        if (counter==0){
            System.out.println("no");
        }
    }
}
