package AssociativeArraysEx;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class P01CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll("\\s+","");

        LinkedHashMap<Character,Integer> charsMap = new LinkedHashMap<>();
        for (char symbol: input.toCharArray()) {

                if (!charsMap.containsKey(symbol)) {
                    charsMap.put(symbol, 1);
                } else {
                    int count = charsMap.get(symbol);
                    charsMap.put(symbol, count + 1);
                }

        }
        charsMap.entrySet().forEach(entry -> System.out.println(entry.getKey()+ " -> "+entry.getValue()));
    }
}
