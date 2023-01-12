package MethodsEx;

import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        charactersInBetween(firstSymbol,secondSymbol);

    }
    public static void charactersInBetween(char a, char b){
        if(a<=b) {
            for (int i = a + 1; i < b; i++) {
                System.out.printf("%c ", i);

            }
        } else {
            for (int i = b + 1; i < a; i++) {
                System.out.printf("%c ", i);

            }
        }
    }
}
