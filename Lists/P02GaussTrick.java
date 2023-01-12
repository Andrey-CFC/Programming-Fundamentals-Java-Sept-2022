package Lists;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int half = numbersList.size()/2;
        for (int i = 0; i < half; i++) {
            int first = numbersList.get(i);
            int second = numbersList.get(numbersList.size()-1);
            numbersList.set(i, first + second);
            numbersList.remove(numbersList.size()-1);
        }
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.printf("%d ",numbersList.get(i));
        }
    }
}
