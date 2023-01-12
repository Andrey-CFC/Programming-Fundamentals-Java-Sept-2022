package MidExamPreparation;

import java.util.Scanner;

public class DTaV_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int secondCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int thirdCapacityPerHour = Integer.parseInt(scanner.nextLine());
        int totalCapacityPerHour = firstCapacityPerHour + secondCapacityPerHour + thirdCapacityPerHour;
        int students = Integer.parseInt(scanner.nextLine());
        int hours = 0;
        while (students > 0) {
            students -= totalCapacityPerHour;
            hours++;
            if (hours % 4 == 0) {
                hours++;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
