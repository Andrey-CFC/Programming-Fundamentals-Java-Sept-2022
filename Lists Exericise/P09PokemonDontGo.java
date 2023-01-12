package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int sumRemovedEl = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index >= 0 && index <= numbers.size() - 1) {
                int removedElement = numbers.get(index);
                sumRemovedEl += removedElement;
                numbers.remove(index);
                modifyList(numbers, removedElement);
            } else if (index < 0) {
                int firstEl = numbers.get(0);
                sumRemovedEl += firstEl;
                numbers.remove(0);
                int lastEl = numbers.get(numbers.size() - 1);
                numbers.add(0, lastEl);
                modifyList(numbers, firstEl);
            } else if (index > numbers.size() - 1) {
                int lastEl = numbers.get(numbers.size() - 1);
                sumRemovedEl += lastEl;
                numbers.remove(numbers.size() - 1);
                int firstEl = numbers.get(0);
                numbers.add(firstEl);
                modifyList(numbers, lastEl);
            }
        }
        System.out.println(sumRemovedEl);
    }

    private static void modifyList(List<Integer> numbers, int removedElement) {
        for (int i = 0; i <= numbers.size() - 1; i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber <= removedElement) {
                currentNumber += removedElement;
            } else {
                currentNumber -= removedElement;
            }
            numbers.set(i, currentNumber);
        }
    }
}
