package ObjectsAndClassesEx;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class P05VehicleCatalogue {
    static class Vehicles {
        private String type;
        private String model;
        private String colour;
        private int horsepower;

        public Vehicles(String type, String model, String colour, int horsepower) {
            this.type = type;
            this.model = model;
            this.colour = colour;
            this.horsepower = horsepower;
        }

        public String getColour() {
            return this.colour;
        }

        public String getModel() {
            return this.model;
        }

        public String getType() {
            return this.type;
        }

        public int getHorsepower() {
            return this.horsepower;
        }

        @Override
        public String toString() {
            String formattedType = "";
            if (this.type.equals("car")) {
                formattedType = "Car";
            } else if (this.type.equals("truck")) {
                formattedType = "Truck";
            }
            return String.format("Type: %s%n" +
                    "Model: %s%n" +
                    "Color: %s%n" +
                    "Horsepower: %d", formattedType, this.model, this.colour, this.horsepower);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Vehicles> vehiclesList = new ArrayList<>();
        List<String> modelList = new ArrayList<>();
        while (!input.equals("End")) {
            String currentType = input.split(" ")[0];
            String currentModel = input.split(" ")[1];
            String currentColour = input.split(" ")[2];
            int currentHorsepower = Integer.parseInt(input.split(" ")[3]);
            Vehicles currentVehicle = new Vehicles(currentType, currentModel, currentColour, currentHorsepower);
            vehiclesList.add(currentVehicle);
            modelList.add(currentModel);
            input = scanner.nextLine();
        }
        String modelCommand = scanner.nextLine();
        while (!modelCommand.equals("Close the Catalogue")) {
            Vehicles vehicleOfModel = getVehicle(vehiclesList, modelCommand);
            System.out.println(vehicleOfModel);
            modelCommand = scanner.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", getAverageHP(vehiclesList, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.%n", getAverageHP(vehiclesList, "trucks"));
    }

    public static Vehicles getVehicle(List<Vehicles> vehiclesList, String model) {
        Vehicles vehicleOfModel = null;
        for (Vehicles vehicles : vehiclesList) {
            if (vehicles.getModel().equals(model)) {
                vehicleOfModel = vehicles;
            }
        }
        return vehicleOfModel;
    }

    public static double getAverageHP(List<Vehicles> vehiclesList, String type) {
        double sum = 0;
        int counter = 0;
        if (type.equals("cars")) {
            for (Vehicles vehicle : vehiclesList) {
                if (vehicle.getType().equals("car")) {
                    sum += vehicle.getHorsepower();
                    counter++;
                }
            }
        } else if (type.equals("trucks")) {
            for (Vehicles vehicle : vehiclesList) {
                if (vehicle.getType().equals("truck")) {
                    sum += vehicle.getHorsepower();
                    counter++;
                }
            }
        }
        if (sum == 0) {
            return 0;
        }
        return sum / counter;
    }
}
