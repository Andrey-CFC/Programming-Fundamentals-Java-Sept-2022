package ListsMoreEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();
        List<String> inputList = Arrays.stream(input.split("")).collect(Collectors.toList());
        for (int i = 0; i < numbersList.size(); i++) {
            int currentNumber = numbersList.get(i);
            int currentSum = 0;
            while (currentNumber > 0) {
                currentSum += currentNumber % 10;
                currentNumber /= 10;
            }
            while (currentSum > inputList.size() - 1) {
                currentSum -= inputList.size();
            }
            System.out.print(inputList.get(currentSum));
            inputList.remove(currentSum);
        }
    }
}
