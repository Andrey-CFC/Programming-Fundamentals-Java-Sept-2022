package MethodsMoreEx;

import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        tribonacciElement(n);

    }

    public static void tribonacciElement(int num) {
        int[] array = new int[num];
        array[0] = 1;
        System.out.printf("%d ",array[0]);
        if (num > 1) {
            array[1] = 1;
            System.out.printf("%d ",array[1]);
        }
        if (num > 2) {
            array[2] = 2;
            System.out.printf("%d ",array[2]);
        }
        if (num > 3) {
            for (int i = 3; i < num; i++) {
                array[i] = array[i - 1] + array[i - 2] + array[i - 3];
                System.out.printf("%d ",array[i]);
            }
        }
    }
}
