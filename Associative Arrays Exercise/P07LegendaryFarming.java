package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Scanner;

public class P07LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> legendaryItems = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> junkItems = new LinkedHashMap<>();
        legendaryItems.put("shards", 0);
        legendaryItems.put("fragments", 0);
        legendaryItems.put("motes", 0);
        boolean won = false;
        while (!won) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            for (int i = 0; i < inputArr.length; i += 2) {
                int quantity = Integer.parseInt(inputArr[i]);
                String material = inputArr[i + 1].toLowerCase();
                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    int currentQuantity = legendaryItems.get(material);
                    legendaryItems.put(material, currentQuantity + quantity);
                } else {
                    if (!junkItems.containsKey(material)) {
                        junkItems.put(material, quantity);
                    } else {
                        int currentQuantity = junkItems.get(material);
                        junkItems.put(material, currentQuantity + quantity);
                    }
                }
                if (legendaryItems.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    legendaryItems.put("shards", legendaryItems.get("shards") - 250);
                    won = true;
                    break;
                } else if (legendaryItems.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    legendaryItems.put("fragments", legendaryItems.get("fragments") - 250);
                    won = true;
                    break;
                } else if (legendaryItems.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    legendaryItems.put("motes", legendaryItems.get("motes") - 250);
                    won = true;
                    break;
                }

            }
            if (won) {
                break;
            }
        }
        legendaryItems.entrySet().forEach(entry -> System.out.printf("%s: %s%n", entry.getKey(), entry.getValue()));
        junkItems.entrySet().forEach(entry -> System.out.printf("%s: %s%n", entry.getKey(), entry.getValue()));
    }
}
