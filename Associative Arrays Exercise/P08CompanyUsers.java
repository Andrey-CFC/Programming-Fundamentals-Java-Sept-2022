package AssociativeArraysEx;

import java.util.*;

public class P08CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        LinkedHashMap<String, List<String>> companiesMap = new LinkedHashMap<>();
        while (!command.equals("End")) {
            String companyName = command.split("\\s+->\\s+")[0];
            String employeesID = command.split("\\s+->\\s+")[1];
            if (!companiesMap.containsKey(companyName)) {
                List<String> employees = new ArrayList<>();
                employees.add(employeesID);
                companiesMap.put(companyName, employees);
            } else {
                List<String> employees = companiesMap.get(companyName);
                if (!employees.contains(employeesID)) {
                    employees.add(employeesID);
                }
            }
            command = scanner.nextLine();
        }
        companiesMap.entrySet().forEach(entry -> {
            System.out.printf("%s%n", entry.getKey());
            entry.getValue().forEach(employee -> System.out.printf("-- %s%n", employee));
        });
    }
}
