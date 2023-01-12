package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ARR_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numbers = scanner.nextLine();
        int[] numbersArr = Arrays.stream(numbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")){
            String[] commandArr = command.split(" ");
            String commandName = commandArr[0];
            switch (commandName){
                case "swap":
                    int swapIndex1 = Integer.parseInt(commandArr[1]);
                    int swapIndex2 = Integer.parseInt(commandArr[2]);
                    int spareEL = 0;
                    spareEL = numbersArr[swapIndex1];
                    numbersArr[swapIndex1] = numbersArr[swapIndex2];
                    numbersArr[swapIndex2] = spareEL;
                    break;
                case "multiply":
                    int multiplyIndex1 = Integer.parseInt(commandArr[1]);
                    int multiplyIndex2 = Integer.parseInt(commandArr[2]);
                    numbersArr[multiplyIndex1] = numbersArr[multiplyIndex1]*numbersArr[multiplyIndex2];
                    break;
                case "decrease":
                    for (int i = 0; i < numbersArr.length; i++) {
                      numbersArr[i] -= 1;
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (int number = 0; number < numbersArr.length-1; number++) {
            System.out.printf(numbersArr[number] + ", ");
        }
        System.out.print(numbersArr[numbersArr.length-1]);
    }
}
