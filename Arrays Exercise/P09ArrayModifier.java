package ArraysEx;

import java.util.Arrays;
import java.util.Scanner;

public class P09ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int index1 = 0;
        int index2 = 0;
        int spareEl = 0;
        while (!command.equals("end")) {
            if (command.equals("decrease")) {
                for (int i = 0; i < numbersArr.length; i++) {
                    numbersArr[i] -= 1;
                }
            } else {
                String[] commandArr = command.split(" ");
                index1 = Integer.parseInt(commandArr[1]);
                index2 = Integer.parseInt(commandArr[2]);
                if (commandArr[0].equals("swap")) {
                    spareEl = numbersArr[index1];
                    numbersArr[index1] = numbersArr[index2];
                    numbersArr[index2] = spareEl;
                } else if (commandArr[0].equals("multiply")) {
                    numbersArr[index1] *= numbersArr[index2];
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i< numbersArr.length - 1; i++) {
            System.out.printf("%d, ", numbersArr[i]);
        }
        System.out.printf("%d",numbersArr[numbersArr.length-1]);
    }
}
