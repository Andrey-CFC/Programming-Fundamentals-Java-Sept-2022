package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ARR_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String wagons = scanner.nextLine();
        int[] wagonsArr = Arrays.stream(wagons.split("\\s+")).mapToInt(Integer::parseInt).toArray();
        boolean noPeople = false;
        boolean notFull = false;

            for (int i = 0; i < wagonsArr.length; i++) {
                if (wagonsArr[i] < 4) {
                    int currentDifference = 4 - wagonsArr[i];
                    if (currentDifference <= people) {
                        people -= currentDifference;
                        wagonsArr[i] = 4;
                    } else {
                        if (people != 0) {
                            wagonsArr[i] += people;
                            people = 0;
                        }
                    }
                }
            }
        if (people == 0) {
            noPeople = true;
        }
        for (int i = 0; i < wagonsArr.length; i++) {
            if (wagonsArr[i] < 4) {
                notFull = true;
            }
        }
        if (noPeople && notFull) {
            System.out.println("The lift has empty spots!");
            if (wagonsArr.length > 1) {
                for (int i = 0; i < wagonsArr.length - 1; i++) {
                    System.out.printf("%d ", wagonsArr[i]);
                }
            }
            System.out.printf("%d", wagonsArr[wagonsArr.length - 1]);
        } else if (!notFull && !noPeople) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
            if (wagonsArr.length > 1) {
                for (int i = 0; i < wagonsArr.length - 1; i++) {
                    System.out.printf("%d ", wagonsArr[i]);
                }
            }
            System.out.printf("%d", wagonsArr[wagonsArr.length - 1]);
        } else if (!notFull && noPeople) {
            if (wagonsArr.length > 1) {
                for (int i = 0; i < wagonsArr.length - 1; i++) {
                    System.out.printf("%d ", wagonsArr[i]);
                }
            }
            System.out.printf("%d", wagonsArr[wagonsArr.length - 1]);
        }
    }
}
