package ArraysMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class P06LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfField = Integer.parseInt(scanner.nextLine());
        int[] startingPositions = Arrays.stream(scanner.nextLine().split("\\ +")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[lengthOfField];

        for (int i = 0; i < startingPositions.length; i++) {
            if (startingPositions[i] >= 0 && startingPositions[i] <= lengthOfField - 1) {
                field[startingPositions[i]] = 1;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] commandArr = input.split("\\ +");
            int startingIndex = Integer.parseInt(commandArr[0]);
            int flyLength = Integer.parseInt(commandArr[2]);
            boolean isPlaced = false;

            if (startingIndex < 0 || startingIndex > lengthOfField - 1 || field[startingIndex] == 0) {
                isPlaced = true;
            } else if (flyLength < 0) {
                flyLength = Math.abs(flyLength);
                if (commandArr[1].equals("left")) {
                    commandArr[1] = "right";
                    if (flyLength + startingIndex > lengthOfField - 1) {
                        isPlaced = true;
                    }
                } else if (commandArr[1].equals("right")) {
                    commandArr[1] = "left";
                    if (startingIndex - flyLength < 0) {
                        isPlaced = true;
                    }
                }
            } else if (flyLength == 0) {
                isPlaced = true;
            }
            if (commandArr[1].equals("left")) {
                while (!isPlaced) {
                    if (startingIndex - flyLength < 0) {
                        field[startingIndex] = 0;
                        isPlaced = true;
                    } else {
                        if (field[startingIndex - flyLength] == 0) {
                            field[startingIndex - flyLength] = 1;
                            field[startingIndex] = 0;
                            isPlaced = true;
                        } else if (field[startingIndex - flyLength] == 1) {
                            flyLength *= 2;
                        }
                    }
                }
            } else if (commandArr[1].equals("right")) {
                while (!isPlaced) {
                    if (startingIndex + flyLength > lengthOfField - 1) {
                        field[startingIndex] = 0;
                        isPlaced = true;
                    } else {
                        if (field[startingIndex + flyLength] == 0) {
                            field[startingIndex + flyLength] = 1;
                            field[startingIndex] = 0;
                            isPlaced = true;
                        } else if (field[startingIndex + flyLength] == 1) {
                            flyLength *= 2;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int element : field) {
            System.out.print(element + " ");
        }
    }
}
