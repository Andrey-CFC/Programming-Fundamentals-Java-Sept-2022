package BasicSyntaxEx;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalMoney = 0.0;
        while (!input.equals("Start")) {
            double coinInserted = Double.parseDouble(input);
            if (coinInserted != 0.1 && coinInserted != 0.2 && coinInserted != 0.5 && coinInserted != 1.0 && coinInserted != 2.0) {
                System.out.printf("Cannot accept %.2f%n", coinInserted);
                input = scanner.nextLine();
                continue;
            } else {
                totalMoney += coinInserted;
                input = scanner.nextLine();
                continue;
            }
        }
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            if (product.equals("Nuts")) {
                if (totalMoney >= 2.0) {
                    totalMoney -= 2.0;
                    System.out.printf("Purchased Nuts%n");
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }
            } else if (product.equals("Water")) {
                if (totalMoney >= 0.7) {
                    totalMoney -= 0.7;
                    System.out.printf("Purchased Water%n");
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }

            } else if (product.equals("Crisps")) {
                if (totalMoney >= 1.5) {
                    totalMoney -= 1.5;
                    System.out.printf("Purchased Crisps%n");
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }
            } else if (product.equals("Soda")) {
                if (totalMoney >= 0.8) {
                    totalMoney -= 0.8;
                    System.out.printf("Purchased Soda%n");
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }
            } else if (product.equals("Coke")) {
                if (totalMoney >= 1.0) {
                    totalMoney -= 1.0;
                    System.out.printf("Purchased Coke%n");
                } else {
                    System.out.printf("Sorry, not enough money%n");
                }
            } else {
                System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f%n", totalMoney);
    }
}