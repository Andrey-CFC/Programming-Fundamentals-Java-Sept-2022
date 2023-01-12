package MethodsMoreEx;

import java.util.Arrays;
import java.util.Scanner;

public class P06ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] inputArr = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] commandArr = command.split("\\s+");
            if (commandArr[0].equals("exchange")) {
                exchangeElementsInAnArray(inputArr, command);
            } else if (commandArr[0].equals("max")) {
                maxOddOrEven(inputArr, command);
            } else if (commandArr[0].equals("min")) {
                minOddOrEven(inputArr, command);
            } else if (commandArr[0].equals("first")) {
                firstNOddOrEven(inputArr, command);
            } else if (commandArr[0].equals("last")) {
                int count = Integer.parseInt(commandArr[1]);
                if (count > inputArr.length) {
                    System.out.println("Invalid count");
                } else {
                    if (commandArr[2].equals("even")) {
                        lastNEven(inputArr, command);
                    } else {
                        lastNOdd(inputArr, command);
                    }
                }
            }
            command = scanner.nextLine();
        }

        System.out.printf("[");
        if (inputArr.length != 0) {
            if (inputArr.length > 1) {
                for (int i = 0; i < inputArr.length - 1; i++) {
                    System.out.printf("%d, ", inputArr[i]);
                }
            }
            System.out.printf("%d", inputArr[inputArr.length - 1]);
        }

        System.out.printf("]");

    }

    public static void exchangeElementsInAnArray(int[] array, String commandExchange) {
        String[] commandArr = commandExchange.split("\\s+");
        int elements = Integer.parseInt(commandArr[1]);
        int repeats = array.length - elements - 1;
        if (elements >= array.length || elements < 0) {
            System.out.println("Invalid index");
        } else if (repeats >= 1) {

            int spareEl = 0;
            for (int i = 1; i <= repeats; i++) {
                spareEl = array[array.length - 1];
                for (int j = array.length - 2; j >= 0; j--) {
                    array[j + 1] = array[j];
                }
                array[0] = spareEl;
            }
        }
    }


    public static void maxOddOrEven(int[] array, String commandExchange) {
        int maxOdd = Integer.MIN_VALUE;
        int maxOddIndex = -1;
        int maxEven = Integer.MIN_VALUE;
        int maxEvenIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] >= maxEven) {
                    maxEven = array[i];
                    maxEvenIndex = i;
                }
            } else {
                if (array[i] >= maxOdd) {
                    maxOdd = array[i];
                    maxOddIndex = i;
                }
            }
        }
        if (commandExchange.equals("max even") && maxEvenIndex != -1) {
            System.out.println(maxEvenIndex);
        } else if (commandExchange.equals("max odd") && maxOddIndex != -1) {
            System.out.println(maxOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void minOddOrEven(int[] array, String commandExchange) {
        int minOdd = Integer.MAX_VALUE;
        int minOddIndex = -1;
        int minEven = Integer.MAX_VALUE;
        int minEvenIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                if (array[i] <= minEven) {
                    minEven = array[i];
                    minEvenIndex = i;
                }
            } else {
                if (array[i] <= minOdd) {
                    minOdd = array[i];
                    minOddIndex = i;
                }
            }
        }
        if (commandExchange.equals("min even") && minEvenIndex != -1) {
            System.out.println(minEvenIndex);
        } else if (commandExchange.equals("min odd") && minOddIndex != -1) {
            System.out.println(minOddIndex);
        } else {
            System.out.println("No matches");
        }
    }

    public static void firstNOddOrEven(int[] array, String commandExchange) {
        String[] commandArr = commandExchange.split("\\s+");
        int count = Integer.parseInt(commandArr[1]);
        int[] countArrOdd = new int[count];
        int[] countArrEven = new int[count];
        int indexOdd = 0;
        int indexEven = 0;
        if (count > array.length) {
            System.out.println("Invalid count");
        } else {
            System.out.printf("[");
            for (int i = 0; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    if (indexEven < count) {
                        countArrEven[indexEven] = array[i];
                        indexEven++;
                    }
                } else {
                    if (indexOdd < count) {
                        countArrOdd[indexOdd] = array[i];
                        indexOdd++;
                    }
                }
            }
            if (commandArr[2].equals("odd")) {
                if (indexOdd != 0) {
                    int[] totalArrOdd = new int[indexOdd];
                    if (indexOdd > 1) {
                        totalArrOdd[0] = countArrOdd[0];
                        System.out.printf("%d, ", totalArrOdd[0]);
                        for (int i = 1; i < indexOdd - 1; i++) {
                            totalArrOdd[i] = countArrOdd[i];
                            System.out.printf("%d, ", totalArrOdd[i]);
                        }
                    }
                    totalArrOdd[indexOdd - 1] = countArrOdd[indexOdd - 1];
                    System.out.printf("%d", totalArrOdd[indexOdd - 1]);
                }
            } else {
                if (indexEven != 0) {
                    int[] totalArrEven = new int[indexEven];
                    if (indexEven > 1) {
                        totalArrEven[0] = countArrEven[0];
                        System.out.printf("%d, ", totalArrEven[0]);
                        for (int i = 1; i < indexEven - 1; i++) {
                            totalArrEven[i] = countArrEven[i];
                            System.out.printf("%d, ", totalArrEven[i]);
                        }
                    }
                    totalArrEven[indexEven - 1] = countArrEven[indexEven - 1];
                    System.out.printf("%d", totalArrEven[indexEven - 1]);
                }
            }
            System.out.printf("]%n");
        }

    }

    public static void lastNOdd(int[] array, String command) {
        String[] commandArr = command.split("\\s+");
        int count = Integer.parseInt(commandArr[1]);
        int[] bufferArr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 != 0 && count > 0) {
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }

    public static void lastNEven(int[] array, String command) {
        String[] commandArr = command.split("\\s+");
        int count = Integer.parseInt(commandArr[1]);
        int[] bufferArr = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0 && count > 0) {
                bufferArr[i] = array[i];
                count--;
            } else {
                bufferArr[i] = -1;
            }
        }
        printArr(bufferArr);
    }
    public static void printArr(int[] array) {
        System.out.print("[");
        boolean printFirst = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != -1) {
                if (printFirst) {
                    System.out.print(array[i]);
                    printFirst = false;
                } else {
                    System.out.print(", " + array[i]);
                }
            }

        }
        System.out.println("]");
    }
}