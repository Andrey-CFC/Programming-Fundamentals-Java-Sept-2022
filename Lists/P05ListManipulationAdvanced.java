package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String lineInput = scanner.nextLine();

        while (!lineInput.equals("end")) {
            String[] commandArr = lineInput.split(" ");
            if (commandArr[0].equals("Contains")) {
                int number = Integer.parseInt(commandArr[1]);
                if (numbersList.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            } else if (commandArr[0].equals("Print") && commandArr[1].equals("even")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) % 2 == 0) {
                        System.out.printf("%d ", numbersList.get(i));
                    }
                }
                System.out.println();
            } else if (commandArr[0].equals("Print") && commandArr[1].equals("odd")) {
                for (int i = 0; i < numbersList.size(); i++) {
                    if (numbersList.get(i) % 2 == 1) {
                        System.out.printf("%d ", numbersList.get(i));
                    }
                }
                System.out.println();
            } else if (commandArr[0].equals("Get")) {
                int sum = 0;
                for (int i = 0; i < numbersList.size(); i++) {
                    sum += numbersList.get(i);
                }
                System.out.println(sum);
            } else if (commandArr[0].equals("Filter")) {
                if (commandArr[1].equals(">")) {
                    int limit = Integer.parseInt(commandArr[2]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) > limit) {
                            System.out.printf("%d ", numbersList.get(i));
                        }
                    }
                    System.out.println();
                } else if (commandArr[1].equals(">=")) {
                    int limit = Integer.parseInt(commandArr[2]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) >= limit) {
                            System.out.printf("%d ", numbersList.get(i));
                        }
                    }
                    System.out.println();

                } else if (commandArr[1].equals("<=")) {
                    int limit = Integer.parseInt(commandArr[2]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) <= limit) {
                            System.out.printf("%d ", numbersList.get(i));
                        }
                    }
                    System.out.println();
                } else if (commandArr[1].equals("<")) {
                    int limit = Integer.parseInt(commandArr[2]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) < limit) {
                            System.out.printf("%d ", numbersList.get(i));
                        }
                    }
                    System.out.println();
                }
            }
            lineInput = scanner.nextLine();
        }
    }
}
