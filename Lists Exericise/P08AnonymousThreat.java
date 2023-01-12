package ListsEx;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("3:1")) {
            String[] commandArr = command.split(" ");
            if (commandArr[0].equals("merge")) {
                int startIndex = Integer.parseInt(commandArr[1]);
                int endIndex = Integer.parseInt(commandArr[2]);
                String concatenation = "";
                if (startIndex < 0) {
                    startIndex = 0;
                }
                if (endIndex > list.size() - 1) {
                    endIndex = list.size() - 1;
                }
                boolean indexesAreValid = startIndex <= list.size() - 1 && endIndex >= 0 && startIndex < endIndex;
                if (indexesAreValid) {
                    for (int i = startIndex; i <= endIndex; i++) {
                        concatenation += list.get(startIndex);
                        list.remove(startIndex);
                    }
                    list.add(startIndex, concatenation);
                }
            } else if (commandArr[0].equals("divide")) {
                int index = Integer.parseInt(commandArr[1]);
                int partitions = Integer.parseInt(commandArr[2]);
                if (index >= 0 && index <= list.size() - 1) {
                    String elementForPartition = list.get(index);
                    list.remove(index);
                    int lengthOfNewElements = elementForPartition.length() / partitions;
                    int startingIndexOfText = 0;
                    for (int i = 1; i < partitions; i++) {
                        list.add(index, elementForPartition.substring(startingIndexOfText, startingIndexOfText + lengthOfNewElements));
                        index++;
                        startingIndexOfText += lengthOfNewElements;
                    }
                    list.add(index, elementForPartition.substring(startingIndexOfText));
                }
            }
            command = scanner.nextLine();
        }
        System.out.println(String.join(" ", list));
    }
}

