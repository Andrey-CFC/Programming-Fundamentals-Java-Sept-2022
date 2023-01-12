package ListsEx;

import java.util.*;
import java.util.stream.Collectors;

public class P07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lineInput = scanner.nextLine();
        List<String> numbersList = Arrays.stream(lineInput.split("\\|")).collect(Collectors.toList());
        Collections.reverse(numbersList);
         System.out.println(numbersList.toString().replace("[","")
                                                    .replace("]","")
                                                    .trim()
                                                    .replaceAll(",","")
                                                    .replaceAll("\\s+"," "));


    }
}
