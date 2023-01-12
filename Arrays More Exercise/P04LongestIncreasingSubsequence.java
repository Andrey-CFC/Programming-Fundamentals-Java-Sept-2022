package ArraysMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] numbersArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = numbersArr.length;
        int[] length = new int[n];
        int[] previous = new int[n];
        int left = 0;
        int maxLength = 0;
        int lastIndex = -1;

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            previous[i] = -1;
            for (int j = 0; j < i; j++) {
                if (numbersArr[j] < numbersArr[i] && length[j] >= length[i]) {
                    length[i] = 1 + length[j];
                    previous[i] = j;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            if (maxLength < length[k]) {
                maxLength = length[k];
                lastIndex = k;
            }
        }
        int[] lisSeq = new int[maxLength];
        while (lastIndex != -1) {
            lisSeq[--maxLength] = numbersArr[lastIndex];
            lastIndex = previous[lastIndex];
        }
        System.out.println(Arrays.toString(lisSeq).replaceAll("[,\\[\\]]", "").trim());
    }
}
