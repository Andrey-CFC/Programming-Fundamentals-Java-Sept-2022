package MidExamPreparation;

import java.util.Scanner;

public class DTaV_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int addBonus = Integer.parseInt(scanner.nextLine());
        double currentStBonus = 0;
        double maxBonus = 0;
        int maxAtt = 0;

        for (int i = 1; i <= students; i++) {
            int attOfCurrentStudent = Integer.parseInt(scanner.nextLine());
            currentStBonus = 1.0*attOfCurrentStudent / lectures * (5 + addBonus);
            if (currentStBonus>maxBonus){
                maxBonus = currentStBonus;
                maxAtt = attOfCurrentStudent;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n",Math.ceil(maxBonus));
        System.out.printf("The student has attended %d lectures.%n",maxAtt);
    }
}
