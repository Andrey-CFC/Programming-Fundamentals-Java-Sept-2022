package MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Lists_MovingTargets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandArr = command.split("\\s+");
            String commandType = commandArr[0];
            switch (commandType) {
                case "Shoot":
                    int shootIndex = Integer.parseInt(commandArr[1]);
                    int shotPower = Integer.parseInt(commandArr[2]);
                    if (shootIndex >= 0 && shootIndex <= targets.size() - 1) {
                        if (targets.get(shootIndex) - shotPower > 0) {
                            targets.set(shootIndex, targets.get(shootIndex) - shotPower);
                        } else {
                            targets.remove(shootIndex);
                        }
                    }
                    break;
                case "Strike":
                    int strikeIndex = Integer.parseInt(commandArr[1]);
                    int strikeRadius = Integer.parseInt(commandArr[2]);
                    if (strikeIndex - strikeRadius >= 0 && strikeIndex + strikeRadius <= targets.size() - 1) {
                        for (int i = strikeIndex-strikeRadius; i <= strikeIndex+strikeRadius; i++) {
                            targets.remove(strikeIndex-strikeRadius);
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
                case "Add":
                    int addIndex = Integer.parseInt(commandArr[1]);
                    int addValue = Integer.parseInt(commandArr[2]);
                    if (addIndex >= 0 && addIndex <= targets.size() - 1) {
                        targets.add(addIndex, addValue);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        if (targets.size() > 1) {
            for (int i = 0; i < targets.size() - 1; i++) {
                System.out.printf(targets.get(i) + "|");
            }
        }
        System.out.print(targets.get(targets.size() - 1));
    }
}
