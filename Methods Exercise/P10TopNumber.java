package MethodsEx;

import java.util.Scanner;

public class P10TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean isValid1 = false;
        boolean isValid2 = false;
        for (int i = 1; i <= n ; i++) {
            isValid1 = sumOfDigitsDivisibleBy8(i);
            isValid2 = numHasAtLeastOneOddDigit(i);
            if (isValid1==true&&isValid2==true){
                System.out.println(i);
            }
        }
    }
    public static boolean sumOfDigitsDivisibleBy8(int number){
        boolean isValid = false;
        int sum = 0;
        while(number>0){
            sum += number%10;
            number = number/10;
        }
        if (sum%8==0){
            isValid = true;
        }
        return isValid;
    }
    public static boolean numHasAtLeastOneOddDigit(int number){
        boolean isValid = false;
        while(number>0){
            if ((number%10)%2==1){
                isValid = true;
                break;
            }
            number = number/10;
        }
        return isValid;
    }
}
