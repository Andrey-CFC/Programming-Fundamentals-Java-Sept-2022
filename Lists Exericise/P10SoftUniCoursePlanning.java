package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialCourses = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!command.equals("course start")) {
            String[] commandArr = command.split(":");
            String typeOfCommand = commandArr[0];
            String course = commandArr[1];
            switch (typeOfCommand) {
                case "Add":
                    if (!initialCourses.contains(course)) {
                        initialCourses.add(course);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(commandArr[2]);
                    if (!initialCourses.contains(course)) {
                        initialCourses.add(index, course);
                    }
                    break;
                case "Remove":
                    if (initialCourses.contains(course)) {
                        initialCourses.remove(course);
                    }
                    int indexCourse = initialCourses.indexOf(course);
                    if (initialCourses.get(indexCourse + 1).equals(course + "-Exercise")) {
                        initialCourses.remove(indexCourse + 1);
                    }
                    break;
                case "Swap":
                    String secondCourse = command.split(":")[2];
                    if (initialCourses.contains(course) && initialCourses.contains(secondCourse)) {
                        int firstCourseIndex = initialCourses.indexOf(course);
                        int secondCourseIndex = initialCourses.indexOf(secondCourse);
                        initialCourses.set(firstCourseIndex, secondCourse);
                        initialCourses.set(secondCourseIndex, course);
                        String firstCourseEx = course + "-Exercise";
                        String secondCourseEx = secondCourse + "-Exercise";
                        if (initialCourses.contains(firstCourseEx)) {
                            initialCourses.remove(initialCourses.indexOf(firstCourseEx));
                            initialCourses.add(initialCourses.indexOf(course) + 1, firstCourseEx);
                        }
                        if (initialCourses.contains(secondCourseEx)) {
                            initialCourses.remove(initialCourses.indexOf(secondCourseEx));
                            initialCourses.add(initialCourses.indexOf(secondCourse) + 1, secondCourseEx);
                        }
                    }
                    break;
                case "Exercise":
                    String lessonExToAdd = course + "-Exercise";
                    int indexOfCourse = initialCourses.indexOf(course);
                    if (initialCourses.contains(course)) {
                        if (indexOfCourse == initialCourses.size() - 1) {
                            initialCourses.add(indexOfCourse + 1, lessonExToAdd);
                        } else if (!initialCourses.get(indexOfCourse + 1).equals(lessonExToAdd)) {
                            initialCourses.add(indexOfCourse + 1, lessonExToAdd);
                        }
                    } else {
                        initialCourses.add(course);
                        initialCourses.add(lessonExToAdd);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printList(initialCourses);
    }

    private static void printList(List<String> elements) {
        int count = 1;
        for (String element : elements) {
            System.out.println(count + "." + element);
            count++;
        }
    }
}
