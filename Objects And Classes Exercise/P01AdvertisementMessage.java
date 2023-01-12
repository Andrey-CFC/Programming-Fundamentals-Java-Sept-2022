package ObjectsAndClassesEx;

import java.util.Random;
import java.util.Scanner;

public class P01AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrasesArr = {"Excellent product.",
                "Such a great product.",
                "I always use that product.",
                "Best product of its category.",
                "Exceptional product.",
                "I can’t live without this product."};
        String[] eventsArr = {"Now I feel good.",
                "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.",
                "I feel great!"};
        String[] authorsArr = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] citiesArr = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};
        Random rndGenerator = new Random();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int indexPhrase = rndGenerator.nextInt(phrasesArr.length);
            int indexEvents = rndGenerator.nextInt(eventsArr.length);
            int indexAuthors = rndGenerator.nextInt(authorsArr.length);
            int indexCities = rndGenerator.nextInt(citiesArr.length);

            System.out.printf("%s %s %s - %s%n",phrasesArr[indexPhrase],eventsArr[indexEvents],authorsArr[indexAuthors],citiesArr[indexCities]);
        }

    }
}
