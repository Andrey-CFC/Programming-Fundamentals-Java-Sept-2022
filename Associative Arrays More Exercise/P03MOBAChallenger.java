package AssociativeArraysMoreEx;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P03MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> playersMap = new LinkedHashMap<>();

        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String playerName = input.split(" -> ")[0];
                String position = input.split(" -> ")[1];
                int skill = Integer.parseInt(input.split(" -> ")[2]);
                if (!playersMap.containsKey(playerName)) {
                    playersMap.put(playerName, new LinkedHashMap<>());
                    playersMap.get(playerName).put(position, skill);
                } else {
                    if (playersMap.get(playerName).containsKey(position)) {
                        if (playersMap.get(playerName).get(position) < skill) {
                            playersMap.get(playerName).put(position, skill);
                        }
                    } else {
                        playersMap.get(playerName).put(position, skill);
                    }
                }
            }
            if (input.contains("vs")) {
                String firsPlayer = input.split(" vs ")[0];
                String secondPlayer = input.split(" vs ")[1];
                if (playersMap.containsKey(firsPlayer) && playersMap.containsKey(secondPlayer)) {
                    boolean isEquals = false;
                    for (String position1 : playersMap.get(firsPlayer).keySet()) {
                        for (String position2 : playersMap.get(secondPlayer).keySet()) {
                            if (position1.equals(position2)) {
                                isEquals = true;
                                break;
                            }
                        }
                    }
                    if (isEquals) {
                        if (playersMap.get(firsPlayer).values().stream().mapToInt(i -> i).sum() >
                                playersMap.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            playersMap.remove(secondPlayer);
                        } else if (playersMap.get(firsPlayer).values().stream().mapToInt(i -> i).sum() <
                                playersMap.get(secondPlayer).values().stream().mapToInt(i -> i).sum()) {
                            playersMap.remove(firsPlayer);
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        playersMap.entrySet().stream().sorted((p1, p2) -> {
                    int sort = Integer.compare(p2.getValue().values().stream().mapToInt(i -> i).sum(),
                            p1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (sort == 0) {
                        sort = p1.getKey().compareTo(p2.getKey());
                    }
                    return sort;
                })
                .forEach(entry -> {
                    System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().
                            mapToInt(i -> i).sum());
                    entry.getValue().entrySet().stream().sorted((e1, e2) -> {
                        int sort = Integer.compare(e2.getValue(), e1.getValue());
                        if (sort == 0) {
                            sort = e1.getKey().compareTo(e2.getKey());
                        }
                        return sort;
                    }).forEach(e -> {
                        System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
                    });
                });
    }
}
