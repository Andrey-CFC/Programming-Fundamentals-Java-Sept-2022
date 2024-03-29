package AssociativeArraysMoreEx;

import java.util.*;

public class P05DragonArmy {
    static class Dragon {
        private String name;
        private int damage;
        private int health;
        private int armor;

        public Dragon(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }


        public int getHealth() {
            return health;
        }


        public int getArmor() {
            return armor;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, List<Dragon>> dragonsByType = new LinkedHashMap<>();
        for (int i = 0; i < rows; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String type = inputArr[0];
            String name = inputArr[1];
            String damageString = inputArr[2];
            int damage = 0;
            String healthString = inputArr[3];
            int health = 0;
            String armorString = inputArr[4];
            int armor = 0;
            if (damageString.equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(damageString);
            }
            if (healthString.equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(healthString);
            }
            if (armorString.equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(armorString);
            }
            Dragon dragon = new Dragon(name, damage, health, armor);
            dragonsByType.putIfAbsent(type, new ArrayList<>());
            if (dragonsByType.get(type).size() > 0) {
                boolean exists = false;
                int index = -1;
                for (int j = 0; j < dragonsByType.get(type).size(); j++) {
                    String itemName = dragonsByType.get(type).get(j).getName();
                    if (itemName.equals(name)) {
                        exists = true;
                        index = j;
                        break;
                    }
                }
                if (exists) {
                    dragonsByType.get(type).set(index, dragon);
                } else {
                    dragonsByType.get(type).add(dragon);
                }
            } else {
                dragonsByType.get(type).add(dragon);
            }

        }
        for (Map.Entry<String, List<Dragon>> entry : dragonsByType.entrySet()) {
            int sumDamage = 0;
            int sumHealth = 0;
            int sumArmor = 0;
            for (Dragon dragon : entry.getValue()) {
                sumDamage += dragon.getDamage();
                sumHealth += dragon.getHealth();
                sumArmor += dragon.getArmor();
            }
            double averageDamage = sumDamage * 1.0 / entry.getValue().size();
            double averageHealth = sumHealth * 1.0 / entry.getValue().size();
            double averageArmor = sumArmor * 1.0 / entry.getValue().size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageDamage, averageHealth, averageArmor);
            Map<String, Dragon> dragonsByName = new TreeMap<>();
            for (Dragon dragon : entry.getValue()) {
                dragonsByName.putIfAbsent(dragon.getName(), dragon);
            }
            for (Map.Entry<String, Dragon> dragonEntry : dragonsByName.entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", dragonEntry.getKey(), dragonEntry.getValue().getDamage(), dragonEntry.getValue().getHealth(), dragonEntry.getValue().getArmor());
            }
        }
    }
}
