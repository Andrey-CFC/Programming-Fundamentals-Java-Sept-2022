package DataTypesAndVariablesMoreEx;

import java.util.Scanner;

public class P02FromLeftToRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String leftNum = "";
            for (int j = 0; j <= input.length() - 1; j++) {
                char leftNumDigit = input.charAt(j);
                if (leftNumDigit == 32) {
                    counter++;
                    break;
                } else {
                    counter++;
                    leftNum += leftNumDigit;
                }
            }
            String rightNum = "";
            for (int k = counter; k <= input.length() - 1; k++) {
                char rightNumDigit = input.charAt(k);
                rightNum += rightNumDigit;
            }
            double rightNumber = Double.parseDouble(rightNum);
            double leftNumber = Double.parseDouble(leftNum);
            int sum = 0;
            if (leftNumber > rightNumber) {
                for (int l = 0; l <= leftNum.length() - 1; l++) {
                    char leftNumSymbol = leftNum.charAt(l);
                    if (leftNumSymbol >= 48 && leftNumSymbol <= 57) {
                        String letter = "" + leftNumSymbol;
                        int digit = Integer.parseInt(letter);
                        sum += digit;
                    }
                }
            } else {
                for (int l = 0; l <= rightNum.length() - 1; l++) {
                    char rightNumSymbol = rightNum.charAt(l);
                    if (rightNumSymbol >= 48 && rightNumSymbol <= 57) {
                        String letter = "" + rightNumSymbol;
                        int digit = Integer.parseInt(letter);
                        sum += digit;
                    }
                }
            }
            counter = 0;
            System.out.println(sum);
        }
    }
}