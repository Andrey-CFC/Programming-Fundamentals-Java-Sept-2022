package DataTypesAndVariablesEx;

import java.math.BigDecimal;
import java.util.Scanner;

public class P11Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int currentSnow = 0;
        int currentTime = 0;
        int currentQuality = 0;
        BigDecimal bestValue =  new BigDecimal(0);
        int bestSnow = 0;
        int bestTime = 0;
        int bestQuality = 0;
        BigDecimal currentValue = new BigDecimal(0);

        for (int i = 1; i <= number; i++) {
            currentSnow = Integer.parseInt(scanner.nextLine());
            currentTime = Integer.parseInt(scanner.nextLine());
            currentQuality = Integer.parseInt(scanner.nextLine());
            currentValue = new BigDecimal(Math.pow((currentSnow/currentTime*1.0),currentQuality));

            if (currentValue.compareTo(bestValue)>0) {
                bestValue = new BigDecimal(Math.pow((currentSnow/currentTime*1.0),currentQuality));;
                bestSnow = currentSnow;
                bestTime = currentTime;
                bestQuality = currentQuality;
            }
        }
        if (number!=0){
            System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestTime, bestValue, bestQuality);
        }
    }
}
