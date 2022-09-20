package BasicSyntaxEx;

import java.util.Scanner;

public class P06StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int length = (int) (Math.log10(number) + 1);
        int sumOfFact = 0;
        int fact = 1;
        int digit = 0;

        for (int i = 1; i <= length; i++) {
            digit = (int) ((number / Math.pow(10, i-1)) % 10);
            if (digit == 0) {
                sumOfFact += fact;
                continue;
            } else {
                for (int j = 1; j <= digit; j++) {
                    fact *= j;
                }
                sumOfFact += fact;
                fact = 1;
            }
        }
        if (sumOfFact == number) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
