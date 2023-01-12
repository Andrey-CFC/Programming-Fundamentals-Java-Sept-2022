package ListsMoreEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double savings = Double.parseDouble(scanner.nextLine());
        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumSetWorking = new ArrayList<>();
        for (int i = 0; i < drumSet.size(); i++) {
            drumSetWorking.add(drumSet.get(i));
        }
        String input = scanner.nextLine();

        while (!input.equals("Hit it again, Gabsy!")) {
            int currentHitPower = Integer.parseInt(input);
            for (int i = 0; i < drumSetWorking.size(); i++) {
                drumSetWorking.set(i, drumSetWorking.get(i) - currentHitPower);
                if (drumSetWorking.get(i)<= 0) {
                    if (savings >= drumSet.get(i) * 3) {
                        drumSetWorking.set(i, drumSet.get(i));
                        savings -= drumSet.get(i) * 3;
                    } else {
                        drumSet.remove(i);
                        drumSetWorking.remove(i);
                        i--;
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < drumSetWorking.size(); i++) {
            System.out.printf("%d ", drumSetWorking.get(i));
        }
        System.out.println();
        System.out.printf("Gabsy has %.2flv.%n", savings);

    }
}
