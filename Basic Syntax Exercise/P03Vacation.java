package BasicSyntaxEx;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        String group = scanner.nextLine();
        String day = scanner.nextLine();
        double totalPrice = 0.0;
        double pricePerDay = 0.0;

        switch (group) {
            case "Students":
                if (day.equals("Friday")) {
                    pricePerDay = 8.45;
                } else if (day.equals("Saturday")) {
                    pricePerDay = 9.80;
                } else if (day.equals("Sunday")) {
                    pricePerDay = 10.46;
                } else {
                    break;
                }
                totalPrice = people*pricePerDay;
                if (people>=30){
                    totalPrice *=0.85;
                }
                    break;
            case "Business":
                if (day.equals("Friday")) {
                    pricePerDay = 10.90;
                } else if (day.equals("Saturday")) {
                    pricePerDay = 15.60;
                } else if (day.equals("Sunday")) {
                    pricePerDay = 16.00;
                } else {
                    break;
                }
                totalPrice = people*pricePerDay;
                if (people>=100){
                    totalPrice -= 10*pricePerDay;
                }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    pricePerDay = 15;
                } else if (day.equals("Saturday")) {
                    pricePerDay = 20;
                } else if (day.equals("Sunday")) {
                    pricePerDay = 22.5;
                } else {
                    break;
                }
                totalPrice = people*pricePerDay;
                if (people>=10&&people<=20){
                    totalPrice *=0.95;
                }
                break;
            default:
                break;
        }
        System.out.printf("Total price: %.2f",totalPrice);
    }
}
