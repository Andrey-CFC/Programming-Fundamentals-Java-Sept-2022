package Methods;

import java.util.Scanner;

public class P11MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.0f",calculator(firstNum,operator,secondNum));
    }

    public static double calculator(int a, String operator, int b){
        double result = 0.0;

        switch (operator){
            case "*":
                result = a*b;
                break;
            case "+":
                result = a+b;
                break;
            case "/":
                result = 1.0*a/b;
                break;
            case "-":
                result = a-b;
                break;
        }
        return result;
    }
}
