package ArraysMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class P01EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] result = new int[n];
        int letter = 0;
        String input = "";
        int sum = 0;
        int spareEl = 0;
        for (int i = 0; i < n; i++) {
            input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                letter = input.charAt(j);
                switch (letter) {
                    case 65:
                    case 97:
                    case 69:
                    case 101:
                    case 73:
                    case 105:
                    case 79:
                    case 111:
                    case 85:
                    case 117:
                        sum += letter * input.length();
                        break;
                    default:
                        sum += letter / input.length();
                        break;
                }
            }
            result[i] = sum;
            sum = 0;
        }
        for (int k = 1; k < result.length; k++) {
            for (int l = 0; l < k; l++) {
                if (result[k] < result[l]) {
                    spareEl = result[l];
                    result[l] = result[k];
                    result[k] = spareEl;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d%n", result[i]);
        }
    }
}

