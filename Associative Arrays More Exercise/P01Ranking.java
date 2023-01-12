package AssociativeArraysMoreEx;

import java.util.*;

public class P01Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contests = scanner.nextLine();
        LinkedHashMap<String, String> contestsMap = new LinkedHashMap<>();
        while (!contests.equals("end of contests")) {
            String contest = contests.split(":")[0];
            String password = contests.split(":")[1];
            contestsMap.put(contest, password);
            contests = scanner.nextLine();
        }
        String input = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> studentsMap = new TreeMap<>();
        while (!input.equals("end of submissions")) {
            String studentContest = input.split("=>")[0];
            String studentPassword = input.split("=>")[1];
            String studentUsername = input.split("=>")[2];
            int studentPoints = Integer.parseInt(input.split("=>")[3]);
            if (contestsMap.containsKey(studentContest)) {
                if (contestsMap.get(studentContest).equals(studentPassword)) {
                    LinkedHashMap<String, Integer> studentsPoints = new LinkedHashMap<>();
                    studentsPoints.put(studentContest, studentPoints);
                    if (!studentsMap.containsKey(studentUsername)) {
                        studentsMap.put(studentUsername, studentsPoints);
                    } else {
                        if (studentsMap.get(studentUsername).containsKey(studentContest)) {
                            studentsMap.get(studentUsername).put(studentContest, Math.max(studentPoints, studentsMap.get(studentUsername).get(studentContest)));
                        } else {
                            studentsMap.get(studentUsername).put(studentContest, studentPoints);
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }
        int maxSum = Integer.MIN_VALUE;
        String bestStudent = "";
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : studentsMap.entrySet()) {
            int sum = entry.getValue().values().stream().mapToInt(i -> i).sum();
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : studentsMap.entrySet()) {
            if (entry.getValue().values().stream().mapToInt(i -> i).sum() == maxSum) {
                System.out.printf("Best candidate is %s with total %d points.%n", entry.getKey(), maxSum);
            }
        }
        System.out.println("Ranking: ");

        studentsMap.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet().stream().sorted((contest, points) -> points.getValue() - contest.getValue()).forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        });
    }
}
