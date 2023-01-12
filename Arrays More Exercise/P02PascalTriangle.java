package ArraysMoreEx;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[] previousRowArr = new int[60];
        previousRowArr[0] = 1;
        previousRowArr[1] = 1;
        int[] currentRowArr = new int[60];
        int one = 1;
        if (rows == 1) {
            System.out.println(one);
        } else if (rows == 2) {
            System.out.println(one);
            System.out.printf("%d %d%n", previousRowArr[0], previousRowArr[1]);
        } else {
            System.out.println(one);
            System.out.printf("%d %d%n", previousRowArr[0], previousRowArr[1]);
            for (int i = 3; i <= rows; i++) {

                currentRowArr = new int[i];
                currentRowArr[0] = 1;
                currentRowArr[currentRowArr.length - 1] = 1;
                if (i % 2 == 0) {
                    for (int j = 1; j <= i / 2; j++) {
                        currentRowArr[j] = previousRowArr[j - 1] + previousRowArr[j];
                        currentRowArr[currentRowArr.length - 1 - j] = currentRowArr[j];
                    }
                } else {
                    for (int j = 1; j <= (i + 1) / 2; j++) {
                        currentRowArr[j] = previousRowArr[j - 1] + previousRowArr[j];
                        if (j != currentRowArr.length - 1) {
                            currentRowArr[currentRowArr.length - 1 - j] = currentRowArr[j];
                        }
                    }
                }
                for (int l = 0; l < currentRowArr.length - 1; l++) {
                    System.out.printf("%d ", currentRowArr[l]);
                }
                System.out.printf("%d%n", currentRowArr[currentRowArr.length - 1]);
                previousRowArr = currentRowArr;
            }
        }
    }
}
