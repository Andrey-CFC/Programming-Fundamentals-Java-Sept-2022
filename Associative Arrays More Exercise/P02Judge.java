package AssociativeArraysMoreEx;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class P02Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashMap<String, TreeMap<String, Integer>> contestMap = new LinkedHashMap<>();
        while (!input.equals("no more time")) {
            String username = input.split(" -> ")[0];
            String contest = input.split(" -> ")[1];
            int points = Integer.parseInt(input.split(" -> ")[2]);
            TreeMap<String, Integer> contestPoints = new TreeMap<>();
            contestPoints.put(username, points);
            if (!contestMap.containsKey(contest)) {
                contestMap.put(contest, contestPoints);
            } else {
                if (contestMap.get(contest).containsKey(username)) {
                    contestMap.get(contest).put(username, Math.max(points, contestMap.get(contest).get(username)));
                } else {
                    contestMap.get(contest).put(username, points);
                }
            }

            input = scanner.nextLine();
        }
        AtomicInteger number = new AtomicInteger();
        contestMap.forEach((key, value) -> {
            System.out.printf("%s: %d participants%n", key, value.size());
            number.set(1);
            Map<String, Integer> studentsRow = new HashMap<>();
            studentsRow = value;
            studentsRow.entrySet().stream().sorted((username, mark) -> {
                if (Objects.equals(mark.getValue(), username.getValue())) {
                    return username.getKey().compareTo(mark.getKey());
                } else {
                    return mark.getValue() - username.getValue();
                }
            }).forEach((row) -> System.out.printf("%d. %s <::> %d%n", number.getAndIncrement(), row.getKey(), row.getValue()));
        });
        TreeMap<String, Integer> totalRanking = new TreeMap<>();
        for (Map.Entry<String, TreeMap<String, Integer>> entry : contestMap.entrySet()) {
            for (Map.Entry<String, Integer> entryPoints : entry.getValue().entrySet()) {
                totalRanking.putIfAbsent(entryPoints.getKey(), 0);
                totalRanking.put(entryPoints.getKey(), totalRanking.get(entryPoints.getKey()) + entryPoints.getValue());
            }
        }
        System.out.println("Individual standings:");
        number.set(1);
        totalRanking.entrySet().stream().sorted((element2,element1)->{
            int sort = Integer.compare(element1.getValue(), element2.getValue());
            if (sort==0){
                sort = element2.getKey().compareTo(element1.getKey());
            }
            return sort;
        }).forEach(e -> {System.out.printf("%d. %s -> %d%n", number.getAndIncrement(), e.getKey(), e.getValue());
        });
    }
}
