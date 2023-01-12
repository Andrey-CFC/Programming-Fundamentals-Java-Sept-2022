package BasicSyntax;

import java.util.Scanner;

public class P10MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int i = 1;

        while(i<=10){
            System.out.printf("%d X %d = %d%n",n,i,n*i);
            i++;
        }
    }
}
