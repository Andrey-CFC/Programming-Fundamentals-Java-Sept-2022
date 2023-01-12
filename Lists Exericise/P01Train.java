package ListsEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int wagonLimit = Integer.parseInt(scanner.nextLine());
        String lineInput = scanner.nextLine();
        while (!lineInput.equals("end")) {
            String[] commandArr = lineInput.split(" ");
            if (commandArr[0].equals("Add")) {
                int nextWagon = Integer.parseInt(commandArr[1]);
                wagonsList.add(nextWagon);
            } else {
                int peopleToEnter = Integer.parseInt(commandArr[0]);
                for (int i = 0; i < wagonsList.size(); i++) {
                    if (wagonLimit >= wagonsList.get(i) + peopleToEnter) {
                        wagonsList.set(i, (wagonsList.get(i)+peopleToEnter));
                        break;
                    }
                }
            }

            lineInput = scanner.nextLine();
        }
        System.out.println(wagonsList.toString().replaceAll("[\\[\\],]", ""));
    }
}
