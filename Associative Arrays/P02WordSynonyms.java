package AssociativeArrays;

import java.util.*;

public class P02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int couples = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, ArrayList<String>> synonymsMap = new LinkedHashMap<>();
        for (int i = 1; i <= couples; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();
            if (!synonymsMap.containsKey(word)) {
                synonymsMap.put(word, new ArrayList<>());
            }
            synonymsMap.get(word).add(synonym);
        }
        for (Map.Entry<String, ArrayList<String>> entry : synonymsMap.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}
