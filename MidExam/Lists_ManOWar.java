package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> warship = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt).collect(Collectors.toList());
        int maxHealth = Integer.parseInt(scanner.nextLine());
        boolean sunken = false;
        String command = scanner.nextLine();
        while (!command.equals("Retire")) {
            String[] commandArr = command.split("\\s+");
            String commandName = commandArr[0];
            switch (commandName) {
                case "Fire":
                    int fireIndex = Integer.parseInt(commandArr[1]);
                    int fireDamage = Integer.parseInt(commandArr[2]);
                    if (fireIndex >= 0 && fireIndex <= warship.size() - 1) {
                        if (fireDamage >= warship.get(fireIndex)) {
                            System.out.println("You won! The enemy ship has sunken.");
                            sunken = true;
                            break;
                        } else {
                            warship.set(fireIndex, warship.get(fireIndex) - fireDamage);
                        }
                    }
                    break;
                case "Defend":
                    int defendStartIndex = Integer.parseInt(commandArr[1]);
                    int defendEndIndex = Integer.parseInt(commandArr[2]);
                    int defendDamage = Integer.parseInt(commandArr[3]);
                    if (defendStartIndex >= 0 && defendStartIndex <= pirateShip.size() - 1 && defendEndIndex >= 0 && defendEndIndex <= pirateShip.size() - 1 && defendStartIndex <= defendEndIndex) {
                        for (int i = defendStartIndex; i <= defendEndIndex; i++) {
                            if (defendDamage >= pirateShip.get(i)) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                sunken = true;
                                break;
                            } else {
                                pirateShip.set(i, pirateShip.get(i) - defendDamage);
                            }
                        }
                    }
                    break;
                case "Repair":
                    int repairIndex = Integer.parseInt(commandArr[1]);
                    int repairHealth = Integer.parseInt(commandArr[2]);
                    if (repairIndex >= 0 && repairIndex <= pirateShip.size() - 1) {
                        if (pirateShip.get(repairIndex) + repairHealth > maxHealth) {
                            repairHealth = maxHealth - pirateShip.get(repairIndex);
                        }
                        pirateShip.set(repairIndex, pirateShip.get(repairIndex) + repairHealth);
                    }
                    break;
                case "Status":
                    int damagedCount = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        if (5 * pirateShip.get(i) < maxHealth) {
                            damagedCount++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", damagedCount);
                    break;
            }
            if (sunken) {
                break;
            }
            command = scanner.nextLine();
        }
        if (!sunken) {
            int pirateShipSum = 0;
            int warshipSum = 0;
            for (int i = 0; i < pirateShip.size(); i++) {
                pirateShipSum += pirateShip.get(i);
            }
            for (int i = 0; i < warship.size(); i++) {
                warshipSum += warship.get(i);
            }
            System.out.printf("Pirate ship status: %d%n", pirateShipSum);
            System.out.printf("Warship status: %d%n", warshipSum);
        }
    }
}
