package Methods;

import java.util.Scanner;

public class P04Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commandInput = scanner.nextLine();
        int firstNumInput = Integer.parseInt(scanner.nextLine());
        int secondNumInput = Integer.parseInt(scanner.nextLine());

        switch (commandInput) {
            case "add":
                addNumbers(firstNumInput, secondNumInput);
                break;
            case "multiply":
                multiplyNumbers(firstNumInput, secondNumInput);
                break;
            case "substract":
                substractNumbers(firstNumInput, secondNumInput);
                break;
            case "divide":
                divideNumbers(firstNumInput, secondNumInput);
                break;
            default:
                break;
        }

    }

    public static void addNumbers(int firstNum, int secondNum) {
        int result = firstNum + secondNum;
        System.out.println(result);
    }

    public static void multiplyNumbers(int firstNum, int secondNum) {
        int result = firstNum * secondNum;
        System.out.println(result);
    }

    public static void substractNumbers(int firstNum, int secondNum) {
        int result = firstNum - secondNum;
        System.out.println(result);
    }

    public static void divideNumbers(int firstNum, int secondNum) {
        int result = firstNum / secondNum;
        System.out.println(result);
    }
}
