package DataTypesAndVariablesMoreEx;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isBalanced = false;
        boolean closed = true;
        boolean opened = false;
        boolean start = false;
        if (n == 0) {
            System.out.println("UNBALANCED");
            return;
        }
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if (closed && input.equals(")")) {
                closed = false;
                break;
            }
            else if (opened && input.equals("(")) {
                closed = false;
                break;
            }
            else if (!start && input.equals(")")) {
                closed = false;
                break;
            }
            else if (!start && input.equals("(")) {
                start = true;
                opened = true;
                closed = false;
            }
            else if (closed && input.equals("(")) {
                opened = true;
                closed = false;
            }
            else if (opened && input.equals(")")) {
                closed = true;
                opened = false;
            }
        }
        if (closed) {
            isBalanced = true;
        }
        if (isBalanced) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}
