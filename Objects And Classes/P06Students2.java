package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06Students2 {
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

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setHometown(String hometown) {
            this.hometown = hometown;
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

            if (isStudentExisting(studentsList, firstName, lastName)) {
                Students currentStudent = getStudent(studentsList, firstName, lastName);
                currentStudent.setFirstName(firstName);
                currentStudent.setLastName(lastName);
                currentStudent.setAge(age);
                currentStudent.setHometown(hometown);
            } else {
                Students currentStudent = new Students(firstName, lastName, age, hometown);
                studentsList.add(currentStudent);
            }
            input = scanner.nextLine();
        }
        String hometown = scanner.nextLine();
        for (Students item : studentsList) {
            if (item.getHometown().equals(hometown)) {
                System.out.printf("%s %s is %d years old%n", item.getFirstName(), item.getLastName(), item.getAge());
            }
        }
    }

    private static boolean isStudentExisting(List<Students> students, String firstName, String lastName) {
        for (Students item : students) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }

    public static Students getStudent(List<Students> students, String firstName, String lastName) {
        Students existingStudent = null;
        for (Students student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }
}
