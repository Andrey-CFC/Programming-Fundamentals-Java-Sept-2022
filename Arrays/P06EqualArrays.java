package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P06EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int errorIndex = 0;
        boolean isIdentical = true;
        int sum = 0;
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i]==secondArr[i]){
                sum += firstArr[i];
            } else {
                isIdentical = false;
                errorIndex = i;
                break;
            }
        }
        if (isIdentical){
            System.out.printf("Arrays are identical. Sum: %d%n",sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.%n",errorIndex);
        }
    }
}
