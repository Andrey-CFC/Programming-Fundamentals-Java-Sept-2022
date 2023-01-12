package BasicSyntax;

import java.util.Scanner;

public class P04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialHour = Integer.parseInt(scanner.nextLine());
        int initialMinutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = initialHour*60+initialMinutes+30;
        int hour = totalMinutes/60;
        int minutes = totalMinutes-hour*60;
        if (hour>23){
            hour = 0;
        }

        System.out.printf("%d:%02d",hour,minutes);
    }
}
