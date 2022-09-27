package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P10PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialPower = Integer.parseInt(scanner.nextLine());
        int leftPower = initialPower;
        int halfPower = initialPower * 50;
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionF = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        while (leftPower >= distance) {
            leftPower -= distance;
            counter++;
            if (leftPower * 100 == halfPower && exhaustionF != 0) {
                 leftPower /= exhaustionF;
            }
        }
        System.out.println(leftPower);
        System.out.println(counter);
    }
}