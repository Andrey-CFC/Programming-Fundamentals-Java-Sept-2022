package ArraysMoreEx;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] fibonacci = new int[3];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacci[2] = 2;
        if (n>=3) {
            for (int i = 2; i < n - 1; i++) {
                fibonacci[0] = fibonacci[1];
                fibonacci[1] = fibonacci[2];
                fibonacci[2] = fibonacci[0] + fibonacci[1];
            }
            System.out.println(fibonacci[2]);
        } else {
            System.out.println(fibonacci[n]);
        }
    }
}
