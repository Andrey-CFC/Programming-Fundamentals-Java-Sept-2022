package ObjectsAndClassesMoreEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class P03CarSalesman {
    static class Engine {
        private String model;
        private int power;
        private int displacement;
        private String efficiency;

        public Engine(String model, int power, int displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public Engine() {

        }

        public String getModel() {
            return model;
        }

        public int getPower() {
            return power;
        }

        public int getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }

    static class Car {
        private String model;
        private Engine engine;
        private int weight;
        private String color;

        public Car(String model, Engine engine, int weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        public Car() {

        }

        public boolean isCarWeightZero() {
            if (this.weight == 0) {
                return true;
            }
            return false;
        }

        public boolean isEngineDisplacementZero() {
            if (this.engine.getDisplacement() == 0) {
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            String outputForZero = "n/a";
            if (isCarWeightZero() && isEngineDisplacementZero()) {
                return String.format("%s:%n" +
                                " %s:%n" +
                                "  Power: %d%n" +
                                "  Displacement: %s%n" +
                                "  Efficiency: %s%n" +
                                " Weight: %s%n" +
                                " Color: %s"
                        , this.model, engine.getModel(), engine.getPower(), outputForZero, engine.getEfficiency(), outputForZero, this.color);
            } else if (isEngineDisplacementZero()) {
                return String.format("%s:%n" +
                                " %s:%n" +
                                "  Power: %d%n" +
                                "  Displacement: %s%n" +
                                "  Efficiency: %s%n" +
                                " Weight: %d%n" +
                                " Color: %s"
                        , this.model, engine.getModel(), engine.getPower(), outputForZero, engine.getEfficiency(), this.weight, this.color);
            } else if (isCarWeightZero()) {
                return String.format("%s:%n" +
                                " %s:%n" +
                                "  Power: %d%n" +
                                "  Displacement: %d%n" +
                                "  Efficiency: %s%n" +
                                " Weight: %s%n" +
                                " Color: %s"
                        , this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), outputForZero, this.color);
            } else {
                return String.format("%s:%n" +
                                " %s:%n" +
                                "  Power: %d%n" +
                                "  Displacement: %d%n" +
                                "  Efficiency: %s%n" +
                                " Weight: %d%n" +
                                " Color: %s"
                        , this.model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), this.weight, this.color);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linesOfEngines = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();
        List<Car> carList = new ArrayList<>();
        Engine engine = new Engine();
        for (int rows = 1; rows <= linesOfEngines; rows++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 2) {
                engine = new Engine(input[0], Integer.parseInt(input[1]), 0, "n/a");
            } else if (input.length == 3) {
                if (isInteger(input[2])) {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), "n/a");
                } else {
                    engine = new Engine(input[0], Integer.parseInt(input[1]), 0, input[2]);
                }
            } else {
                engine = new Engine(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]), input[3]);
            }

            engineList.add(engine);
        }
        int lineForCars = Integer.parseInt(scanner.nextLine());
        Car car = new Car();
        for (int i = 1; i <= lineForCars; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String engineModel = input[1];
            if (getEngine(engineList, engineModel) != null) {
                engine = getEngine(engineList, engineModel);
            }
            if (input.length == 2) {
                car = new Car(input[0], engine, 0, "n/a");
            } else if (input.length == 3) {
                if (isInteger(input[2])) {
                    car = new Car(input[0], engine, Integer.parseInt(input[2]), "n/a");
                } else {
                    car = new Car(input[0], engine, 0, input[2]);
                }
            } else {
                car = new Car(input[0], engine, Integer.parseInt(input[2]), input[3]);
            }
            carList.add(car);
        }


        for (Car item : carList) {
            System.out.println(item.toString());

        }
    }

    public static boolean isInteger(String input) {
        Pattern pattern = Pattern.compile("[+-]?[0-9][0-9]*");
        return pattern.matcher(input).matches();
    }

    public static Engine getEngine(List<Engine> engineList, String model) {
        for (int j = 0; j < engineList.size(); j++) {
            Engine currentEngine = engineList.get(j);
            String currentModel = currentEngine.getModel();
            if (currentModel.equals(model)) {
                return currentEngine;
            }
        }
        return null;
    }
}
