package DataTypesAndVariables;

import java.util.Scanner;

public class P05ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimeter = scanner.nextLine();
        String result = String.format("%s%s%s",firstName,delimeter,lastName);
        System.out.printf(result);
    }
}
