package MethodsEx;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(sum(a,b),c));

    }
    public static int sum(int a, int b){
        int sum = a+b;
        return sum;

    }
    public  static int subtract (int a, int b){
        int subtract = a-b;
        return subtract;
    }
}
