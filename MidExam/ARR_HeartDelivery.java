package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ARR_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] neighbourhood = Arrays.stream(input.split("@")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        int position = 0;

        while (!command.equals("Love!")) {
            String[] commandArr = command.split("\\s+");
            int lengthOfJump = Integer.parseInt(commandArr[1]);
            position += lengthOfJump;
            if (position >= neighbourhood.length) {
                position = 0;
            }
            if (neighbourhood[position] == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", position);
                command = scanner.nextLine();
                continue;
            }
            neighbourhood[position] -= 2;
            if (neighbourhood[position] == 0) {
                System.out.printf("Place %d has Valentine's day.%n", position);
                command = scanner.nextLine();
                continue;
            }

            command = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.%n", position);
        int sum = 0;
        for (int i = 0; i < neighbourhood.length; i++) {
            if (neighbourhood[i] != 0) {
                sum++;
            }
        }
        if (sum > 0) {
            System.out.printf("Cupid has failed %d places.", sum);
        } else {
            System.out.printf("Mission was successful.");
        }
    }
}
