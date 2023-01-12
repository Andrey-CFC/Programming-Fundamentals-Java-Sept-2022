package MidExamPreparation;

import java.util.Scanner;

public class DTaV_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double foodKg = Double.parseDouble(scanner.nextLine());
        double foodG = foodKg * 1000;
        double hayKg = Double.parseDouble(scanner.nextLine());
        double hayG = hayKg * 1000;
        double coverKg = Double.parseDouble(scanner.nextLine());
        double coverG = coverKg * 1000;
        double pigWeightKg = Double.parseDouble(scanner.nextLine());
        double pigWeightG = 1000 * pigWeightKg;
        boolean isEnough = true;

        for (int day = 1; day <= 30; day++) {
            foodG -= 300;
            if (day % 2 == 0) {
                double currentHay = 0.05 * foodG;
                hayG -= currentHay;
            }
            if (day % 3 == 0) {
                double currentCover = pigWeightG / 3;
                coverG -= currentCover;
            }
            if (foodG <= 0 || hayG <= 0 || coverG <= 0) {
                isEnough = false;
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }
        if (isEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.%n", foodG / 1000, hayG / 1000, coverG / 1000);
        }

    }
}
