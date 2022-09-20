package BasicSyntaxEx;

import java.util.Scanner;

public class P05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        int length = password.length();
        int counter = 1;
        boolean isLocked = false;


        while (counter <= 4) {
            String try1 = scanner.nextLine();
            if (length == try1.length()) {
                for (int j = 0; j < length; j++) {
                    if (password.charAt(j) == try1.charAt(length - j - 1)) {
                        isLocked = true;
                    } else {
                        isLocked = false;
                    }
                }
                if (isLocked == true) {
                    System.out.printf("User %s logged in.%n", password);
                    break;
                } else {
                    if (counter <= 3) {
                        System.out.println("Incorrect password. Try again.");
                    } else {
                        System.out.printf("User %s blocked!%n", password);
                    }
                }
            } else {
                if (counter <= 3) {
                    System.out.println("Incorrect password. Try again.");
                } else {
                    System.out.printf("User %s blocked!%n", password);
                }
            }
            counter++;
        }
      }
}
