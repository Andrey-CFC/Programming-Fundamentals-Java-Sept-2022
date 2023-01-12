package MethodsMoreEx;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("int")) {
            int numInt = Integer.parseInt(scanner.nextLine());
            System.out.println(multiplyBy2(numInt));
        } else if (type.equals("real")) {
            double numDouble = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.2f%n",multiplyByOneAndAHalf(numDouble));
        } else if (type.equals("string")) {
            String input = scanner.nextLine();
            System.out.println(surroundInputWith$(input));

        }
    }

    public static int multiplyBy2(int n) {
        int result = n * 2;
        return result;
    }
    public static double multiplyByOneAndAHalf(double n) {
        double result = n * 1.5;
        return result;
    }
    public static String surroundInputWith$(String text) {
        String newText = "$"+text+"$";
        return newText;
    }
}
