package BasicSyntaxEx;

import java.util.Scanner;

public class P11RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPr = Double.parseDouble(scanner.nextLine());
        double mousePr = Double.parseDouble(scanner.nextLine());
        double keyboardPr = Double.parseDouble(scanner.nextLine());
        double displayPr = Double.parseDouble(scanner.nextLine());

        int lostHeadsets = lostGames/2;
        int lostMouses = lostGames/3;
        int lostKeyboards = lostGames/6;
        int lostDisplays = lostGames/12;
        double expenses = lostHeadsets*headsetPr+lostMouses*mousePr+lostKeyboards*keyboardPr+lostDisplays*displayPr;

        System.out.printf("Rage expenses: %.2f lv.",expenses);
    }
}
