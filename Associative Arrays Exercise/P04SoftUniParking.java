package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class P04SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, String> register = new LinkedHashMap<>();

        for (int i = 1; i <= commands; i++) {
            String command = scanner.nextLine();
            String commandName = command.split("\\s+")[0];
            if (commandName.equals("register")) {
                String registerName = command.split("\\s+")[1];
                String plateNumber = command.split("\\s+")[2];
                if (!register.containsKey(registerName)) {
                    register.put(registerName, plateNumber);
                    System.out.printf("%s registered %s successfully%n", registerName, plateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", register.get(registerName));
                }
            } else if (commandName.equals("unregister")) {
                String unregisterName = command.split("\\s+")[1];
                if (register.containsKey(unregisterName)) {
                    register.remove(unregisterName);
                    System.out.printf("%s unregistered successfully%n",unregisterName);
                } else {
                    System.out.printf("ERROR: user %s not found%n",unregisterName);
                }
            }
        }
        register.entrySet().forEach(entry-> System.out.printf("%s => %s%n",entry.getKey(),entry.getValue()));
    }
}
