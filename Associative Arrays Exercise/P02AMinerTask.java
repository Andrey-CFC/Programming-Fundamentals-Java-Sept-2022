package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        LinkedHashMap<String, Integer> resourcesMap = new LinkedHashMap<>();
        while (!command.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!resourcesMap.containsKey(command)) {
                resourcesMap.put(command, quantity);
            } else {
                int currentQuantity = resourcesMap.get(command);
                resourcesMap.put(command, currentQuantity + quantity);
            }
            command = scanner.nextLine();
        }
        resourcesMap.entrySet().forEach(entry -> System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue()));
    }
}
