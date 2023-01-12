package MethodsEx;

import java.util.Scanner;

public class P04PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean isLong = passwordLength(input);
        boolean rightContent = passwordContent(input);
        boolean hasTwoDigits = passwordHas2Digits(input);

        if (isLong == false) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (rightContent == false) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (hasTwoDigits == false) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isLong == true && rightContent == true && hasTwoDigits == true) {
            System.out.println("Password is valid");
        }
    }

    public static boolean passwordLength(String text) {
        boolean isValid = false;
        if (text.length() >= 6 && text.length() <= 10) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean passwordContent(String text) {
        char a = ' ';
        boolean isValid = true;
        for (int i = 0; i < text.length(); i++) {
            a = text.charAt(i);
            if ((a >= 0 && a <= 47) || (a >= 58 && a <= 64) || (a >= 91 && a <= 96)|| (a >= 123)) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    public static boolean passwordHas2Digits(String text) {
        char a = ' ';
        int digitCounter = 0;
        boolean isValid = false;
        for (int i = 0; i < text.length(); i++) {
            a = text.charAt(i);
            if (a >= 48 && a <= 57) {
                digitCounter++;
            }
        }
        if (digitCounter >= 2) {
            isValid = true;
        }
        return isValid;
    }
}
