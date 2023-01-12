package MethodsEx;

import java.math.BigDecimal;
import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        long firstFactorial = factorial(firstNumber);
        long secondFactorial = factorial(secondNumber);

        double resultDivision = division(firstFactorial, secondFactorial);
        //double result = 1.0*factorial(firstNumber)/factorial(secondNumber);
        System.out.printf("%.2f", resultDivision);


    }

    public static long factorial(long n) {
        long result = 1;
        if (n >= 1) {
            for (long i = n; i >= 1; i--) {
                result *= i;
            }
        }
        return result;
    }

    public static double division(long a, long b) {
        double resultDivision = 1.0 * a / b;
        return resultDivision;
    }
}
