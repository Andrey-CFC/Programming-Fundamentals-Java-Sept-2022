package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String lineInput = scanner.nextLine();
        while (!lineInput.equals("end")) {
            String[] commandArr = lineInput.split(" ");
            if (commandArr[0].equals("Delete")) {
                int elementForDelete = Integer.parseInt(commandArr[1]);
                for (int i = numbersList.size()-1; i >=0; i--) {
                    if (elementForDelete == numbersList.get(i)) {
                        numbersList.remove(i);
                        i = numbersList.size()-1;
                    }
                }
            } else if (commandArr[0].equals("Insert")) {
                int elementForInserting = Integer.parseInt(commandArr[1]);
                int indexForInserting = Integer.parseInt(commandArr[2]);
                numbersList.add(indexForInserting, elementForInserting);
            }
            lineInput = scanner.nextLine();
        }
        System.out.println(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
