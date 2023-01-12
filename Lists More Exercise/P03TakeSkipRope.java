package ListsMoreEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inputList = Arrays.stream(input.split("")).collect(Collectors.toList());
        List<String> symbols = new ArrayList<>();
        List<Integer> digits = new ArrayList<>();
        List<Integer> digitsTake = new ArrayList<>();
        List<Integer> digitsSkip = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            char currentSymbol = inputList.get(i).charAt(0);
            if (currentSymbol >= 48 && currentSymbol <= 57) {
                digits.add(Integer.valueOf(inputList.get(i)));
            } else {
                symbols.add(inputList.get(i));
            }
        }
        for (int i = 0; i < digits.size(); i++) {
            if (i % 2 == 0) {
                digitsTake.add(digits.get(i));
            } else {
                digitsSkip.add(digits.get(i));
            }
        }

        int counter = 0;
        for (int j = 0; j < digitsTake.size(); j++) {
            int currentTake = digitsTake.get(j);
            int currentSkip = digitsSkip.get(j);
            boolean end = false;
            int currentCounter = 0;
            if (counter>= symbols.size()){
                break;
            }
            for (int i = counter; i < (counter + currentTake); i++) {
                if (counter + currentCounter >= symbols.size()) {
                    end = true;
                    break;
                }
                if (counter + currentTake > i) {
                    System.out.printf(symbols.get(i));
                    currentCounter++;
                }
            }
            if (end) {
                break;
            }
            counter += currentTake;
            counter += currentSkip;
        }
    }
}
