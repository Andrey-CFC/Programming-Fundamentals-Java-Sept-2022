package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> shoppingList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("Go Shopping!")) {
            String[] commandArr = command.split(" ");
            String commandName = commandArr[0];
            switch (commandName) {
                case "Urgent":
                    String urgentItem = commandArr[1];
                    if (!shoppingList.contains(urgentItem)) {
                        shoppingList.add(0, urgentItem);
                    }
                    break;
                case "Unnecessary":
                    String unnecessaryItem = commandArr[1];
                    if (shoppingList.contains(unnecessaryItem)) {
                        shoppingList.remove(unnecessaryItem);
                    }
                    break;
                case "Correct":
                    String oldItem = commandArr[1];
                    String newItem = commandArr[2];
                    if (shoppingList.contains(oldItem)) {
                        shoppingList.set(shoppingList.indexOf(oldItem), newItem);
                    }
                    break;
                case "Rearrange":
                    String rearrangeItem = commandArr[1];
                    if (shoppingList.contains(rearrangeItem)) {
                        shoppingList.remove(rearrangeItem);
                        shoppingList.add(rearrangeItem);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf(String.join(", ", shoppingList));
    }
}
