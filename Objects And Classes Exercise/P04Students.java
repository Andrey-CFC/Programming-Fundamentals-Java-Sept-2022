package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P04Students {
    static class Students {
        private String firstName;
        private String lastName;
        private double grade;

        public Students(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public double getGrade() {
            return this.grade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] currentStudentArr = input.split("\\s+");
            String firstName = currentStudentArr[0];
            String lastName = currentStudentArr[1];
            double grade = Double.parseDouble(currentStudentArr[2]);
            Students currentStudent = new Students(firstName, lastName, grade);
            studentsList.add(currentStudent);
            grades.add(grade);

        }
        Collections.sort(grades);
        Collections.reverse(grades);
        for (int i = 0; i < grades.size(); i++) {
            Students currentStudent = getStudent(studentsList, grades.get(i));
            System.out.printf("%s %s: %.2f%n", currentStudent.getFirstName(), currentStudent.getLastName(), currentStudent.getGrade());
        }
    }

    public static Students getStudent(List<Students> students, double grade) {
        Students studentOfGrade = null;
        for (Students student : students) {
            if (student.getGrade() == grade) {
                studentOfGrade = student;
            }
        }
        return studentOfGrade;
    }
}

