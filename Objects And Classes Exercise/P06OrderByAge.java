package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06OrderByAge {
    static class People {
        private String name;
        private String id;
        private int age;

        public People(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return this.name;
        }

        public String getId() {
            return this.id;
        }

        public int getAge() {
            return this.age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", this.name, this.id, this.age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<People> peopleList = new ArrayList<>();
        List<Integer> ageList = new ArrayList<>();
        while (!input.equals("End")) {
            String currentName = input.split(" ")[0];
            String currentId = input.split(" ")[1];
            int currentAge = Integer.parseInt(input.split(" ")[2]);
            People currentPerson = new People(currentName, currentId, currentAge);
            peopleList.add(currentPerson);
            ageList.add(currentAge);
            input = scanner.nextLine();
        }
        Collections.sort(ageList);
        for (int i = 0; i < ageList.size(); i++) {
            People personOfAge = getPerson(peopleList, ageList.get(i));
            System.out.println(personOfAge);
        }
    }

    public static People getPerson(List<People> peopleList, int age) {
        People personOfAge = null;
        for (People person : peopleList) {
            if (person.getAge() == age) {
                personOfAge = person;
            }
        }
        return personOfAge;
    }
}
