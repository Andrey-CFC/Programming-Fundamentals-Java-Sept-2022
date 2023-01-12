package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String lineInput = scanner.nextLine();

        while (!lineInput.equals("End")) {
            String[] commandArr = lineInput.split(" ");
            switch (commandArr[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(commandArr[1]);
                    numbersList.add(numberToAdd);
                    break;
                case "Insert":
                    int numberToInsert = Integer.parseInt(commandArr[1]);
                    int indexToInsert = Integer.parseInt(commandArr[2]);
                    if (indexToInsert >= 0 && indexToInsert <= numbersList.size() - 1) {
                        numbersList.add(indexToInsert, numberToInsert);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(commandArr[1]);
                    if (indexToRemove >= 0 && indexToRemove <= numbersList.size() - 1) {
                        numbersList.remove(indexToRemove);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    if (commandArr[1].equals("left")) {
                        int count = Integer.parseInt(commandArr[2]);
                        for (int i = 1; i <= count; i++) {
                            int spareEl = numbersList.get(0);
                            for (int j = 0; j < numbersList.size() - 1; j++) {
                                numbersList.set(j, numbersList.get(j + 1));
                            }
                            numbersList.set(numbersList.size() - 1, spareEl);
                        }
                    } else {
                        int count = Integer.parseInt(commandArr[2]);
                        for (int i = 1; i <= count; i++) {
                            int spareEl = numbersList.get(numbersList.size() - 1);
                            for (int j = numbersList.size() - 1; j > 0; j--) {
                                numbersList.set(j, numbersList.get(j - 1));
                            }
                            numbersList.set(0, spareEl);
                        }
                    }
                    break;
            }
            lineInput = scanner.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
