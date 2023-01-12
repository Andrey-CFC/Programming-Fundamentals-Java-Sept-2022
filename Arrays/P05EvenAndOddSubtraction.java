package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class P05EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int even = 0;
        int odd = 0;
                for  (int item : numbersArr){
                    if (item%2==0){
                        even += item;
                    } else {
                        odd += item;
                    }
                }
        System.out.println(even-odd);
    }
}
