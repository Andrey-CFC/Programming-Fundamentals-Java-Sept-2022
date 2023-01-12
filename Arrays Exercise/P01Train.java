package ArraysEx;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int elements = Integer.parseInt(scanner.nextLine());
        int[] numbersArr = new int[elements];
        int sum = 0;
        for (int i = 0; i < elements; i++) {
            numbersArr[i] = Integer.parseInt(scanner.nextLine());
            sum+=numbersArr[i];
            System.out.printf("%d ",numbersArr[i]);

        }
        System.out.println();
        System.out.println(sum);
    }
}
