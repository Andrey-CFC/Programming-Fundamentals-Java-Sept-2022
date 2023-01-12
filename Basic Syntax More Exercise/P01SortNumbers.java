package BasicSyntaxMoreEx;

import java.util.Scanner;

public class P01SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int max = 0;
        int min = 0;
        int average = 0;

        if (a >= b) {
            if (a >= c) {
                max = a;
                if (b >= c) {
                    average = b;
                    min = c;
                } else {
                    average = c;
                    min = b;
                }
            } else {
                max = c;
                min = b;
                average = a;
            }
        } else {
            if (b >= c) {
                max = b;
                if (a >= c) {
                    min = c;
                    average = a;
                } else {
                    min = a;
                    average = c;
                }
            } else {
                max = c;
                min = a;
                average = b;
            }
        }
        System.out.println(max);
        System.out.println(average);
        System.out.println(min);
    }
}
