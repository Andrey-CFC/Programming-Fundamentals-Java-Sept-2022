package DataTypesAndVariablesEx;

import java.util.Scanner;

public class P08BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int kegs = Integer.parseInt(scanner.nextLine());
        String kegName = "";
        double radius = 0.0;
        int height = 0;
        String biggestKeg = "";
        double biggestVolume = 0.0;
        for (int i = 1; i <= kegs; i++) {
            kegName = scanner.nextLine();
            radius = Double.parseDouble(scanner.nextLine());
            height = Integer.parseInt(scanner.nextLine());
            if (Math.PI*radius*radius*height>biggestVolume){
                biggestVolume = Math.PI*radius*radius*height;
                biggestKeg = kegName;
            }
        }
        System.out.println(biggestKeg);
    }
}
