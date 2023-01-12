package Methods;

import java.util.Scanner;

public class P05Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String productInput = scanner.nextLine();
        double quantityInput = Double.parseDouble(scanner.nextLine());
        productPrice(productInput,quantityInput);

    }

    public static void productPrice(String product, double quantity) {
        double result = 0;
        switch (product) {
            case "coffee":
                result = 1.5 * quantity;
                break;
            case "water":
                result = 1.0 * quantity;
                break;
            case "coke":
                result = 1.4 * quantity;
                break;
            case "snacks":
                result = 2.0 * quantity;
                break;
            default:
                break;
        }
        System.out.printf("%.2f",result);
    }
}
