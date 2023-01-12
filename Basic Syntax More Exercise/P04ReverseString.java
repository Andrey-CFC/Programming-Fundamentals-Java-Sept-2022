package BasicSyntaxMoreEx;

import java.util.Scanner;

public class P04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int length = input.length();

        for (int i = 0; i < length; i++) {
            char letter = input.charAt(length-i-1);
            System.out.printf("%c",letter);
        }

    }
}
