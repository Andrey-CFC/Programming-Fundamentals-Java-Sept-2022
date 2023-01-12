package Arrays;

import java.util.Scanner;

public class P01DaysOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] daysOfWeekArr = {
         "Monday",
         "Tuesday",
         "Wednesday",
         "Thursday",
         "Friday",
         "Saturday",
         "Sunday"
        };

        int n = Integer.parseInt(scanner.nextLine());
        if (n>=1&&n<=7){
            System.out.println(daysOfWeekArr[n-1]);
        } else {
            System.out.printf("Invalid day!%n");
        }
    }
}
