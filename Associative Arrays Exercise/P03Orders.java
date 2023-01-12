package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Double> productPrice = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> productQuantity = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("buy")) {
            String product = command.split(" ")[0];
            double price = Double.parseDouble(command.split(" ")[1]);
            int quantity = Integer.parseInt(command.split(" ")[2]);
            productPrice.put(product, price);
            if (!productQuantity.containsKey(product)) {
                productQuantity.put(product, quantity);
            } else {
                productQuantity.put(product, productQuantity.get(product) + quantity);
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : productPrice.entrySet()) {
            String product = entry.getKey();
            double totalCost = entry.getValue() * productQuantity.get(product);
            System.out.printf("%s -> %.2f%n",product,totalCost);
        }
    }
}
