package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> sequence = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        boolean noMatching = false;
        String input = scanner.nextLine();
        int counter = 1;
        while (!input.equals("end")) {
            int[] indexes = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int firstIndex = indexes[0];
            int secondIndex = indexes[1];
            int counterOfMatches = 0;
            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex >= sequence.size() || secondIndex < 0 || secondIndex >= sequence.size()) {
                int currentSize = sequence.size();
                String elementToAdd = "-" + counter + "a";
                sequence.add(currentSize / 2, elementToAdd);
                sequence.add(currentSize / 2, elementToAdd);
                System.out.println("Invalid input! Adding additional elements to the board");
            } else {
                if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                    String removedItem = sequence.get(firstIndex);
                    if (firstIndex > secondIndex) {
                        sequence.remove(firstIndex);
                        sequence.remove(secondIndex);
                    } else {
                        sequence.remove(secondIndex);
                        sequence.remove(firstIndex);
                    }
                    System.out.printf("Congrats! You have found matching elements - %s!%n", removedItem);

                } else {
                    System.out.println("Try again!");
                }
            }
            for (int i = 0; i < sequence.size(); i++) {
                for (int j = i + 1; j < sequence.size(); j++) {
                    if (sequence.get(i).equals(sequence.get(j))) {
                        counterOfMatches++;
                    }
                }
            }
            if (counterOfMatches == 0) {
                System.out.printf("You have won in %d turns!%n", counter);
                noMatching = true;
                break;
            }
            input = scanner.nextLine();
            counter++;
        }
        if (!noMatching) {
            System.out.println("Sorry you lose :(");
            System.out.println(String.join(" ", sequence));
        }

    }
}
