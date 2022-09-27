package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P03Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int lifts = (int) Math.ceil(1.0*people/capacity);
        System.out.println(lifts);
    }
}
