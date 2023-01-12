package MethodsMoreEx;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        productSign(num1, num2, num3);

    }

    public static void productSign(int a, int b, int c) {
        int smallest = smallestNumberOfThree(a, b, c);
        int biggest = biggestNumberOfThree(a, b, c);
        int middle = middleNumberOfThree(a, b, c);
        if (a == 0 || b == 0 || c == 0) {
            System.out.println("zero");
        } else if (smallest > 0) {
            System.out.println("positive");
        } else if (biggest < 0) {
            System.out.println("negative");
        } else if (middle > 0) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
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

    public static int biggestNumberOfThree(int a, int b, int c) {
        int biggest = 0;
        if (a >= b && a >= c) {
            biggest = a;
        } else if (b >= a && b >= c) {
            biggest = b;
        } else {
            biggest = c;
        }
        return biggest;
    }

    public static int middleNumberOfThree(int a, int b, int c) {
        int middle = 0;
        if (a >= b && a >= c) {
            if (b >= c) {
                middle = b;
            } else {
                middle = c;
            }
        } else if (b >= a && b >= c) {
            if (a >= c) {
                middle = a;
            } else {
                middle = c;
            }
        } else {
            if (a >= b) {
                middle = a;
            } else {
                middle = b;
            }
        }
        return middle;
    }
}
