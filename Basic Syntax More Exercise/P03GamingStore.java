package BasicSyntaxMoreEx;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double spent = 0;
        String input = scanner.nextLine();
        while(!input.equals("Game Time")){
            switch (input){
                case "OutFall 4":
                    if (budget>=39.99){
                        budget -= 39.99;
                        spent += 39.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                case "CS: OG":
                    if (budget>=15.99){
                        budget -= 15.99;
                        spent += 15.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                case "Zplinter Zell":
                    if (budget>=19.99){
                        budget -= 19.99;
                        spent += 19.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                case "Honored 2":
                    if (budget>=59.99){
                        budget -= 59.99;
                        spent += 59.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                case "RoverWatch":
                    if (budget>=29.99){
                        budget -= 29.99;
                        spent += 29.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                case "RoverWatch Origins Edition":
                    if (budget>=39.99){
                        budget -= 39.99;
                        spent += 39.99;
                        System.out.printf("Bought %s%n",input);
                    } else {
                        System.out.printf("Too Expensive%n");
                    }
                    break;
                default:
                    System.out.printf("Not Found%n");
                    break;
            }
            if (budget==0){
                System.out.printf("Out of money!%n");
                break;
            } else {
                input = scanner.nextLine();
            }
        }
        if (budget!=0){
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f%n",spent, budget);
        }
    }
}
