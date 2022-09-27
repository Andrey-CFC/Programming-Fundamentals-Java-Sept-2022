package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int currentPour = 0;
        int capacity = 255;
        int filled = 0;
        for (int i = 1; i <= n; i++) {
            currentPour = Integer.parseInt(scanner.nextLine());
            if (capacity>=filled+currentPour){
                filled += currentPour;
            } else {
                System.out.printf("Insufficient capacity!%n");
            }
        }
        System.out.println(filled);
    }
}
