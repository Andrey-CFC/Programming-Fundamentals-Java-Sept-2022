package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inventoryList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            List<String> commandList = Arrays.stream(command.split(" - ")).collect(Collectors.toList());
            String commandName = commandList.get(0);
            switch (commandName) {
                case "Collect":
                    if (!inventoryList.contains(commandList.get(1))) {
                        inventoryList.add(commandList.get(1));
                    }
                    break;
                case "Drop":
                    if (inventoryList.contains(commandList.get(1))) {
                        inventoryList.remove(commandList.get(1));
                    }
                    break;
                case "Combine Items":
                    String[] items = commandList.get(1).split(":");
                    String oldItem = items[0];
                    String newItem = items[1];
                    if (inventoryList.contains(oldItem)) {
                        int indexOfOldItem = inventoryList.indexOf(oldItem);
                        inventoryList.add(indexOfOldItem + 1, newItem);
                    }
                    break;
                case "Renew":
                    if (inventoryList.contains(commandList.get(1))) {
                        String itemToRenew = commandList.get(1);
                        inventoryList.remove(itemToRenew);
                        inventoryList.add(itemToRenew);
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.printf(String.join(", ", inventoryList));
    }
}
