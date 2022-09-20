package BasicSyntaxEx;

import java.util.Scanner;

public class P10PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightsaberPr = Double.parseDouble(scanner.nextLine());
        double robesPr = Double.parseDouble(scanner.nextLine());
        double beltsPr = Double.parseDouble(scanner.nextLine());

        double lightsabers = Math.ceil(1.1 * students);
        int belts = students - students / 6;

        double totalCost = lightsaberPr * lightsabers + students * robesPr + belts * beltsPr;

        if (totalCost <= budget) {
            System.out.printf("The money is enough - it would cost %.2flv.", totalCost);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", totalCost - budget);
        }

    }
}
