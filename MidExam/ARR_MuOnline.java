package MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ARR_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dungeonRooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        boolean dead = false;
        for (int i = 0; i < dungeonRooms.length; i++) {
            String[] currentRoom = dungeonRooms[i].split(" ");
            String command = currentRoom[0];
            switch (command) {
                case "potion":
                    int healed = Integer.parseInt(currentRoom[1]);
                    if (health + healed > 100){
                        healed = 100 - health;
                        health = 100;
                    } else {
                        health += healed;
                    }
                    System.out.printf("You healed for %d hp.%n", healed);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int bitcoinsFound = Integer.parseInt(currentRoom[1]);
                    bitcoins += bitcoinsFound;
                    System.out.printf("You found %d bitcoins.%n", bitcoinsFound);
                    break;
                default:
                    int monsterAttack = Integer.parseInt(currentRoom[1]);
                    health -= monsterAttack;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                        dead = true;
                    }
                    break;
            }
            if (dead) {
                break;
            }
        }
        if (!dead){
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n",bitcoins);
            System.out.printf("Health: %d",health);
        }
    }
}
