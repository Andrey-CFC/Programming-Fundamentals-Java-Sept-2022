package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P05PrintPartOfAsciiTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit1 = Integer.parseInt(scanner.nextLine());
        int limit2 = Integer.parseInt(scanner.nextLine());
        int currentChar = 0;
        for (int i = limit1; i <= limit2; i++) {
            currentChar = i;
            System.out.printf("%c ",currentChar);
        }
    }
}
