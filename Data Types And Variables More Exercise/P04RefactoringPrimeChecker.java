package DataTypesAndVariablesMoreEx;

import java.util.Scanner;

public class P04RefactoringPrimeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= limit; i++) {
            boolean isPrime = true;
            for (int devisor = 2; devisor < i; devisor++) {
                if (i % devisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            System.out.printf("%d -> %b%n", i, isPrime);
        }
    }
}
