package AssociativeArraysEx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P05Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        LinkedHashMap<String, List<String>> courses = new LinkedHashMap<>();
        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];
            if (!courses.containsKey(courseName)) {
                courses.put(courseName, new ArrayList<>());
            }
            courses.get(courseName).add(studentName);
            input = scanner.nextLine();
        }
        courses.entrySet().forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue().size());
            entry.getValue().forEach(student -> System.out.printf("-- %s%n", student));
        });
    }
}
