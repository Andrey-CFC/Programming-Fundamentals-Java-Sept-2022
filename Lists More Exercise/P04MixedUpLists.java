package ListsMoreEx;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> mixedList = new ArrayList<>();
        int sizeOfSmallerList = 0;
        int firstRangeNum = 0;
        int secondRangeNum = 0;
        int spareNum = 0;
        if (firstList.size() > secondList.size()) {
            sizeOfSmallerList = secondList.size();
            firstRangeNum = firstList.get(sizeOfSmallerList);
            secondRangeNum = firstList.get(sizeOfSmallerList + 1);
        } else {
            sizeOfSmallerList = firstList.size();
            firstRangeNum = secondList.get(0);
            secondRangeNum = secondList.get(1);
        }
        for (int i = 0; i < sizeOfSmallerList; i++) {
            mixedList.add(firstList.get(i));
            mixedList.add(secondList.get(secondList.size() - 1 - i));
        }
        if (firstRangeNum > secondRangeNum) {
            spareNum = firstRangeNum;
            firstRangeNum = secondRangeNum;
            secondRangeNum = spareNum;
        }
        for (int i = 0; i < mixedList.size(); i++) {
            if (!(mixedList.get(i)>firstRangeNum&&mixedList.get(i)<secondRangeNum)){
                mixedList.remove(i);
                i--;
            }
        }
        Collections.sort(mixedList);
        for (int i = 0; i < mixedList.size(); i++) {
            System.out.printf("%d ", mixedList.get(i));
        }

    }
}
