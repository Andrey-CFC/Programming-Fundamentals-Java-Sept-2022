package Methods;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resultText = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(repeatString(n,resultText));
    }
    public static String repeatString(int n, String text){
        String result ="";
        for (int i = 0; i < n; i++) {
            result = result + text;
        }
        return result;
    }
}
