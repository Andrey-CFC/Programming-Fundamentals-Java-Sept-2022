package AssociativeArraysEx;

import java.util.*;

public class P06StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countStudents = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Double>> studentsGrade = new LinkedHashMap<>();

        for (int student = 1; student <= countStudents; student++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (!studentsGrade.containsKey(name)) {
                studentsGrade.put(name, new ArrayList<>());
            }
            studentsGrade.get(name).add(grade);
        }
        LinkedHashMap<String, Double> averageGradeStudents = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()) {
            String studentName = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrade = getAverageGrade(grades);
            if (averageGrade >= 4.5) {
                averageGradeStudents.put(studentName, averageGrade);
            }
        }
        averageGradeStudents.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));
    }

    private static double getAverageGrade(List<Double> listGrades) {
        double sumGrades = 0;
        for (double grade : listGrades) {
            sumGrades += grade;
        }
        return sumGrades / listGrades.size();
    }
}
