package ArraysMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class P05KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int[] bestArray = new int[length];
        int sequence = 0;
        int bestSequence = 0;
        int currentSum = 0;
        int maxSum = 0;
        int maxCounter = 0;
        int maxIndex = Integer.MAX_VALUE;
        String nextLine = scanner.nextLine();
        while (!nextLine.equals("Clone them!")) {
            int[] lineArr = Arrays.stream(nextLine.split("!+")).mapToInt(Integer::parseInt).toArray();
            sequence++;
            int currentMaxCounter = 0;
            int currentIndex = Integer.MAX_VALUE;
            for (int i = 0; i < lineArr.length; i++) {
                int counter = 0;
                for (int j = i; j < lineArr.length; j++) {
                    if (lineArr[i] == lineArr[j] && lineArr[i] == 1) {
                        counter++;
                        if (counter > currentMaxCounter) {
                            currentMaxCounter = counter;
                            currentIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (currentMaxCounter > maxCounter) {
                maxCounter = currentMaxCounter;
                maxIndex = currentIndex;
                bestSequence = sequence;
                bestArray = lineArr;
            } else if (currentMaxCounter == maxCounter){
                if(currentIndex < maxIndex) {
                    bestSequence = sequence;
                    bestArray = lineArr;
                    maxIndex = currentIndex;
                } else if (currentIndex == maxIndex) {
                    for (int i = 0; i < bestArray.length; i++) {
                        currentSum += lineArr[i];
                        maxSum += bestArray[i];
                    }
                    if (currentSum>maxSum){
                        bestArray = lineArr;
                        bestSequence = sequence;
                        maxSum = currentSum;
                    }
                }
            }
            nextLine = scanner.nextLine();
        }
        maxSum = 0;
        for (int i = 0; i < bestArray.length; i++) {
            maxSum += bestArray[i];
        }
        if (maxSum==0){
            bestSequence = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequence, maxSum);
        for (int element : bestArray) {
            System.out.print(element + " ");
        }
    }
}
