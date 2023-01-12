package DataTypesAndVariablesMoreEx;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String input = "";
        String output = "";
        for (int i = 1; i <=n ; i++) {
            input = scanner.nextLine();
            char letter = input.charAt(0);
            letter += key;
            output += "" + letter;
        }
        System.out.println(output);
    }
}
