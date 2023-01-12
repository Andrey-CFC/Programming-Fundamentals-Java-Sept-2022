package MethodsEx;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(vowelsCounter(input));

    }

    public static int vowelsCounter(String text) {
        int counter = 0;
        char a = ' ';
        for (int i = 0; i < text.length(); i++) {
            a = text.charAt(i);
            switch (a) {
                case 'a':
                case 'A':
                case 'e':
                case 'E':
                case 'u':
                case 'U':
                case 'i':
                case 'I':
                case 'o':
                case 'O':
                    counter++;
                    break;
                default:
                    break;
            }
        }
        return counter;
    }
}
