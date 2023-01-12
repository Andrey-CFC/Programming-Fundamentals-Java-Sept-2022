package MethodsEx;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        matrix(n);

    }

    public static void matrix(int number) {
        for (int rows = 1; rows <= number; rows++) {
            for (int elements = 1; elements <= number; elements++) {
                System.out.printf("%d ", number);

            }
            System.out.println();
        }
    }
}
