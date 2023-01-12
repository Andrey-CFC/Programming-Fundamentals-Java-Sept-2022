package MidExamPreparation;

import java.util.Scanner;

public class DTaV_BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysPirating = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        double plunderManaged = 0;
        double plunderTarget = Double.parseDouble(scanner.nextLine());
        for (int i = 1; i <= daysPirating; i++) {
            plunderManaged += plunderPerDay;
            if (i % 3 == 0) {
                plunderManaged += 0.5 * plunderPerDay;
            }
            if (i % 5 == 0) {
                plunderManaged *= 0.7;
            }
        }
        if (plunderManaged >= plunderTarget) {
            System.out.printf("Ahoy! %.2f plunder gained.", plunderManaged);
      } else {
           double percentage = 100.0*plunderManaged/plunderTarget;
           System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }
    }
}
