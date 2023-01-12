package MethodsMoreEx;

import java.util.Scanner;

public class P03LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double firstLineLength = lengthOfLine(x1,y1,x2,y2);
        double x3 = Double.parseDouble(scanner.nextLine());
        double y3 = Double.parseDouble(scanner.nextLine());
        double x4 = Double.parseDouble(scanner.nextLine());
        double y4 = Double.parseDouble(scanner.nextLine());
        double secondLineLength = lengthOfLine(x3,y3,x4,y4);
        if (firstLineLength>=secondLineLength){
            closestPointToCenterByCoordinates(x1,y1,x2,y2);
        } else {
            closestPointToCenterByCoordinates(x3,y3,x4,y4);
        }


    }

    public static void closestPointToCenterByCoordinates(double x1, double y1, double x2, double y2) {
        double distance1 = Math.sqrt((Math.pow(x1, 2) + Math.pow(y1, 2)));
        double distance2 = Math.sqrt((Math.pow(x2, 2) + Math.pow(y2, 2)));
        if (distance1 <= distance2) {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x1, y1, x2, y2);
        } else {
            System.out.printf("(%.0f, %.0f)(%.0f, %.0f)", x2, y2, x1, y1);
        }
    }

    public static double lengthOfLine(double x1, double y1, double x2, double y2) {
        double distance = Math.sqrt((Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2)));
        return distance;
    }
}
