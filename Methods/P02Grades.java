package Methods;

import java.util.Scanner;

public class P02Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double gradeInput = Double.parseDouble(scanner.nextLine());
        printGradeInWord(gradeInput);
    }
    public static void printGradeInWord(double grade){
        if (grade>=2&&grade<3){
            System.out.printf("Fail");
        } else if(grade<3.5){
            System.out.printf("Poor");
        }else if(grade<4.5){
            System.out.printf("Good");
        }else if(grade<5.5){
            System.out.printf("Very good");
        }else {
            System.out.printf("Excellent");
        }
    }
}
