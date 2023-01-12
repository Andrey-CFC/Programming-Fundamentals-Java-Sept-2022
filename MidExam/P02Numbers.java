package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("Finish")) {
            String[] commandArr = command.split("\\s+");
            String commandName = commandArr[0];
            switch (commandName) {
                case "Add":
                    int elementToAdd = Integer.parseInt(commandArr[1]);
                    numbers.add(elementToAdd);
                    break;
                case "Remove":
                    int elementToRemove = Integer.parseInt(commandArr[1]);
                    if (numbers.contains(elementToRemove)) {
                        numbers.remove(Integer.valueOf(elementToRemove));
                    }
                    break;
                case "Replace":
                    int elementToReplace = Integer.parseInt(commandArr[1]);
                    int elementToReplaceWith = Integer.parseInt(commandArr[2]);
                    if (numbers.contains(elementToReplace)) {
                        numbers.set(numbers.indexOf(elementToReplace), elementToReplaceWith);
                    }
                    break;
                case "Collapse":
                    int valueOfCollapse = Integer.parseInt(commandArr[1]);
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) < valueOfCollapse) {
                            numbers.remove(i);
                            i = -1;
                        }
                    }
                    break;
            }

            command = scanner.nextLine();
        }
        if (numbers.size() > 1) {
            for (int i = 0; i < numbers.size() - 1; i++) {
                System.out.printf("%d ", numbers.get(i));
            }
        }
        System.out.printf("%d", numbers.get(numbers.size() - 1));
    }
}
