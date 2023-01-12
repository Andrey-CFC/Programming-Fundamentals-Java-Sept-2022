package ListsEx;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondDeck = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;
        while (firstDeck.size() != 0 && secondDeck.size() != 0) {
            int firstPlayerCard = firstDeck.get(0);
            int secondPlayerCard = secondDeck.get(0);
            firstDeck.remove(0);
            secondDeck.remove(0);

            if (firstPlayerCard> secondPlayerCard) {
                firstDeck.add(firstPlayerCard);
                firstDeck.add(secondPlayerCard);
            } else if (firstPlayerCard < secondPlayerCard) {
                secondDeck.add(secondPlayerCard);
                secondDeck.add(firstPlayerCard);
            }
        }
        if (firstDeck.size() == 0) {
            for (int j = 0; j < secondDeck.size(); j++) {
                sum += secondDeck.get(j);
            }
            System.out.printf("Second player wins! Sum: %d%n", getPlayersCardsSum(secondDeck));

        } else if (secondDeck.size() == 0) {
            for (int j = 0; j < firstDeck.size(); j++) {
                sum += firstDeck.get(j);
            }
            System.out.printf("First player wins! Sum: %d%n", getPlayersCardsSum(firstDeck));
        }
    }
    private static int getPlayersCardsSum (List<Integer> list){
        int sum = 0;
        for (int card:list) {
            sum += card;
        }
        return sum;
    }
}
