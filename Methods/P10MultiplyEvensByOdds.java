package Methods;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getMultipleOfEvensAndOdds(n));
    }

    public static int getMultipleOfEvensAndOdds(int n) {
        int evenSum = getSumOfEvenDigits(n);
        int oddSum = getSumOfOddDigits(n);
        return evenSum * oddSum;
    }

    public static int getSumOfEvenDigits(int n) {
        int evenSum = 0;
        int abs = Math.abs(n);
        while (abs > 0) {
            if (abs % 2 == 0) {
                evenSum += abs % 10;
            }
            abs = abs / 10;
        }
        return evenSum;
    }
    public static int getSumOfOddDigits(int n){
        int oddSum = 0;
        int abs = Math.abs(n);
        while (abs > 0) {
            if (abs % 2 == 1) {
                oddSum += abs % 10;

            }             abs = abs / 10;
        }
        return oddSum;
    }
}
