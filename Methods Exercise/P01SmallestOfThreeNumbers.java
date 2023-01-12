package MethodsEx;

import java.util.Scanner;

public class P01SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumberInput = Integer.parseInt(scanner.nextLine());
        int secondNumberInput = Integer.parseInt(scanner.nextLine());
        int thirdNumberInput = Integer.parseInt(scanner.nextLine());

        System.out.println(smallestNumberOfThree(firstNumberInput,secondNumberInput,thirdNumberInput));

    }

    public static int smallestNumberOfThree(int a, int b, int c) {
        int smallest = 0;
        if (a <= b && a <= c) {
            smallest = a;
        } else if (b <= a && b <= c) {
            smallest = b;
        } else {
            smallest = c;
        }
        return smallest;
    }
}
