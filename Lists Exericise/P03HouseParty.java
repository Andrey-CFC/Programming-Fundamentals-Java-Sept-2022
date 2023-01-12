package ListsEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfNames = new ArrayList<>();
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String command = scanner.nextLine();
            String[] commandArr = command.split(" ");
            String name = commandArr[0];
            if (commandArr[2].equals("going!")) {
                if (!listOfNames.contains(commandArr[0])) {
                    listOfNames.add(name);
                } else {
                    System.out.printf(name + " is already in the list!%n");
                }
            } else {
                if (listOfNames.contains(commandArr[0])) {
                    listOfNames.remove(commandArr[0]);
                } else {
                    System.out.printf(name + " is not in the list!%n");
                }
            }

        }
        for (int i = 0; i < listOfNames.size(); i++) {
            System.out.println(listOfNames.get(i));
        }
    }
}
