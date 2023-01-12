package Methods;

import java.util.Scanner;

public class P03PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numInput = Integer.parseInt(scanner.nextLine());
        printTriangle(numInput);
    }

    public static void printTriangle(int num) {
        for (int i = 1; i <= num; i++) {
            printLine(i);
        }
        for (int i = num-1; i >=1 ; i--) {
            printLine(i);
        }
    }
    public static void printLine(int row) {
        for (int i = 1; i <= row; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
