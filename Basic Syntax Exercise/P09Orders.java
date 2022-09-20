package BasicSyntaxEx;

import java.util.Scanner;

public class P09Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int orders = Integer.parseInt(scanner.nextLine());
        double orderPr = 0;
        double totalPr = 0;
        for (int i = 1; i <= orders ; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsules = Integer.parseInt(scanner.nextLine());
            orderPr = pricePerCapsule*days*capsules;
            System.out.printf("The price for the coffee is: $%.2f%n",orderPr);
            totalPr += orderPr;
            orderPr = 0;
        }
        System.out.printf("Total: $%.2f",totalPr);

    }
}
