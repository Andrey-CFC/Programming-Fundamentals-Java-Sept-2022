package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P09SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());
        int dailyYield = startingYield;

        int extractedSpice = 0;
        int workingDays = 0;
        while (dailyYield >= 100) {
            extractedSpice += dailyYield - 26;
            dailyYield -= 10;
            workingDays += 1;
        }
        if (extractedSpice >= 26) {
            extractedSpice -= 26;
        }
        System.out.println(workingDays);
        System.out.println(extractedSpice);
    }
}
