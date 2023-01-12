package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03OpinionPoll {

    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            String[] currentPersonArr = input.split("\\s+");
            String name = currentPersonArr[0];
            int age = Integer.parseInt(currentPersonArr[1]);
            Person currentPerson = new Person(name,age);
            people.add(currentPerson);
        }
        for (Person person : people) {
            if (person.getAge()>30){
                System.out.printf("%s - %d%n",person.getName(),person.getAge());
            }
        }

    }
}
