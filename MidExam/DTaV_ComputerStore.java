package MidExamPreparation;

import java.util.Scanner;

public class DTaV_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double totalPrice = 0;
        while (!input.equals("special") && !input.equals("regular")) {
            double currentPrice = Double.parseDouble(input);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }
            totalPrice += 1.2 * currentPrice;
            input = scanner.nextLine();
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            double priceWithoutTaxes = totalPrice/1.2;
            double taxes = priceWithoutTaxes/5;
            if (input.equals("special")) {
                totalPrice *= 0.9;
            }
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n",priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$%n",taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$%n",totalPrice);
        }
    }
}
