package AssociativeArraysEx;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        LinkedHashMap<String, Integer> resultsMap = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> languageSubmissions = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {
            String[] splitArray = command.split("-");
            String name = splitArray[0];
            if (splitArray.length == 3) {
                String language = splitArray[1];
                int points = Integer.parseInt(splitArray[2]);
                if (!resultsMap.containsKey(name)){
                    resultsMap.put(name,points);
                } else {
                    int currentPoints = resultsMap.get(name);
                    if (currentPoints<points){
                        resultsMap.put(name,points);
                    }
                }
                if (!languageSubmissions.containsKey(language)){
                    languageSubmissions.put(language,1);
                } else{
                    languageSubmissions.put(language,languageSubmissions.get(language)+1);
                }
            } else {
                resultsMap.remove(name);
            }

            command = scanner.nextLine();
        }
        System.out.println("Results:");
        resultsMap.entrySet().forEach(entry-> System.out.printf("%s | %d%n",entry.getKey(),entry.getValue()));
        System.out.println("Submissions:");
        languageSubmissions.entrySet().forEach(entry-> System.out.printf("%s - %d%n",entry.getKey(),entry.getValue()));
    }
}
