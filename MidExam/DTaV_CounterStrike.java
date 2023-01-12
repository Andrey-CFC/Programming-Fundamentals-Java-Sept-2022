package MidExamPreparation;

import java.util.Scanner;

public class DTaV_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int battleCounter = 0;
        boolean dead = false;
        while (!command.equals("End of battle")) {
            int currentDistance = Integer.parseInt(command);
            if (energy >= currentDistance) {
                energy -= currentDistance;
                battleCounter++;
                if (battleCounter % 3 == 0) {
                    energy += battleCounter;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy%n", battleCounter, energy);
                dead = true;
                break;
            }
            command = scanner.nextLine();
        }
        if (!dead) {
            System.out.printf("Won battles: %d. Energy left: %d%n", battleCounter, energy);
        }
    }
}
