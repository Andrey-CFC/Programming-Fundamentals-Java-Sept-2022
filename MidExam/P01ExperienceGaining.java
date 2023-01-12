package MidExamPreparation;

import java.util.Scanner;

public class P01ExperienceGaining {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double neededExperience = Double.parseDouble(scanner.nextLine());
        int countOfBattles = Integer.parseInt(scanner.nextLine());
        double experience = 0.0;
        int battles = 0;

        for (int i = 1; i <= countOfBattles; i++) {
            double currentBattleExp = Double.parseDouble(scanner.nextLine());
            battles++;
            experience += currentBattleExp;
            if (i % 3 == 0) {
                experience += 0.15 * currentBattleExp;
            }
            if (i % 5 == 0) {
                experience -= 0.1*currentBattleExp;
            }
            if (experience>=neededExperience){
                System.out.printf("Player successfully collected his needed experience for %d battles.%n",battles);
                break;
            }
        }
        if (experience<neededExperience){
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.%n",neededExperience-experience);
        }
    }
}
