package AssociativeArraysEx;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class P09ForceBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();
        while (!command.equals("Lumpawaroo")) {
            if (command.contains(" | ")) {
                String group = command.split("\\s+\\|\\s+")[0];
                String user = command.split("\\s+\\|\\s+")[1];
                if (!map.containsKey(group)) {
                    map.put(group, new ArrayList<>());
                }
                boolean doesExist = false;
                for (List<String> listUsers : map.values()) {
                    if (listUsers.contains(user)) {
                        doesExist = true;
                        break;
                    }
                }
                if (!doesExist) {
                    map.get(group).add(user);
                }
            } else if (command.contains(" -> ")) {
                String user = command.split("\\s+->\\s+")[0];
                String group = command.split("\\s+->\\s+")[1];
                map.entrySet().forEach(entry -> entry.getValue().remove(user));
                if (map.containsKey(group)) {
                } else {
                    map.put(group, new ArrayList<>());
                }
                map.get(group).add(user);
                System.out.printf("%s joins the %s side!%n", user, group);

            }

            command = scanner.nextLine();
        }
        map.entrySet().stream().filter(entry -> entry.getValue().size() > 0).forEach(entry -> {System.out.printf("Side: %s, Members: %d%n",entry.getKey(),entry.getValue().size());
        entry.getValue().forEach(user -> System.out.println("! "+user));});

    }
}
