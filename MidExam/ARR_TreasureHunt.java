package MidExamPreparation;

import java.util.Scanner;

public class ARR_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String loot = scanner.nextLine();
        String[] lootArr = new String[100];
        String[] lootArr2 = loot.split("\\|");
        int lootArrLength = lootArr2.length;
        for (int i = 0; i < lootArrLength; i++) {
            lootArr[i] = lootArr2[i];
        }
        String command = scanner.nextLine();
        int index = 0;
        int count = 0;
        int counter = 0;
        int sumLength = 0;
        String spareEl = "";
        int repeats = 0;

        while (!command.equals("Yohoho!")) {
            String[] commandArr = command.split(" ");
            if (commandArr[0].equals("Loot")) {
                for (int i = 1; i < commandArr.length; i++) {
                    if (lootArrLength > 0) {
                        for (int j = 0; j < lootArrLength; j++) {
                            if (commandArr[i].equals(lootArr[j])) {
                                repeats++;
                            }
                        }
                        if (repeats == 0) {
                            spareEl = commandArr[i];
                            lootArrLength++;
                            for (int k = lootArrLength - 1; k > 0; k--) {
                                lootArr[k] = lootArr[k - 1];
                            }
                            lootArr[0] = spareEl;
                        } else {
                            repeats = 0;
                        }
                    } else {
                        lootArrLength = commandArr.length - 1;
                        for (int m = commandArr.length - 1; m > 0; m--) {
                            lootArr[commandArr.length - 1 - m] = commandArr[m];
                        }
                    }
                }
            } else if (commandArr[0].equals("Drop")) {
                index = Integer.parseInt(commandArr[1]);
                if (index >= 0 && index <= lootArrLength - 1) {
                    spareEl = lootArr[index];
                    for (int i = index; i < lootArrLength - 1; i++) {
                        lootArr[i] = lootArr[i + 1];
                    }
                    lootArr[lootArrLength - 1] = spareEl;
                }
            } else if (commandArr[0].equals("Steal")) {
                count = Integer.parseInt(commandArr[1]);
                if (count <= lootArrLength) {
                    for (int i = lootArrLength - count; i < lootArrLength - 1; i++) {
                        System.out.printf("%s, ", lootArr[i]);
                        lootArr[i] = "";
                    }
                    System.out.printf("%s%n", lootArr[lootArrLength - 1]);
                    lootArr[lootArrLength - 1] = "";
                    lootArrLength -= count;
                } else {
                    for (int i = 0; i < lootArrLength - 1; i++) {
                        System.out.printf("%s, ", lootArr[i]);
                        lootArr[i] = "";
                    }
                    System.out.printf("%s%n", lootArr[lootArrLength - 1]);
                    lootArr[lootArrLength - 1] = "";
                    lootArrLength = 0;
                }
            }
            command = scanner.nextLine();
        }
        for (int i = 0; i < lootArrLength; i++) {
            sumLength += lootArr[i].length();
            if (!lootArr[i].equals("")) {
                counter++;
            }
        }
        if (counter != 0) {
            System.out.printf("Average treasure gain: %.2f pirate credits.%n", 1.0 * sumLength / counter);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}
