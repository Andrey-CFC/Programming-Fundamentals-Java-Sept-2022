package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P05Students {
    static class Students {
        private String firstName;
        private String lastName;
        private int age;
        private String hometown;

        public Students(String firstName, String lastName, int age, String hometown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.hometown = hometown;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public String getHometown() {
            return this.hometown;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Students> studentsList = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] studentDataArr = input.split("\\s+");
            String firstName = studentDataArr[0];
            String lastName = studentDataArr[1];
            int age = Integer.parseInt(studentDataArr[2]);
            String hometown = studentDataArr[3];
            Students currentStudent = new Students(firstName,lastName,age,hometown);
            studentsList.add(currentStudent);
            input = scanner.nextLine();
        }
        String hometown = scanner.nextLine();
        for (Students item:studentsList) {
            if (item.getHometown().equals(hometown)){
                System.out.printf("%s %s is %d years old%n",item.getFirstName(),item.getLastName(),item.getAge());
            }
        }

    }
}
