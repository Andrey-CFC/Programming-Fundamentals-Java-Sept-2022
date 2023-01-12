package MethodsEx;

import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            boolean isValid = palindromeChecker(input);
            if (isValid) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }

    }

    public static boolean palindromeChecker(String text) {
        boolean isPalindrome = true;
        for (int i = 0; i < text.length() / 2; i++) {
            if (text.charAt(i) != text.charAt(text.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
