package MethodsEx;

import java.util.Scanner;

public class P06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        middleElementsOfText(input);
    }
    public static void middleElementsOfText(String text){
        if (text.length()%2==0){
            System.out.printf("%c%c",text.charAt(text.length()/2-1),text.charAt(text.length()/2));
        } else {
            System.out.printf("%c",text.charAt((text.length()-1)/2));
        }
    }
}
