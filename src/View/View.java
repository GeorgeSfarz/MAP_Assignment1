package View;

import Exceptions.MyException;
import Model.Bicycle;
import Model.Car;
import Model.Motorcycle;
import Model.IVehicle;
import Service.Service;
import java.util.Scanner;
public class View {
    Service service;
    int capacity;
    private final Scanner scanner = new Scanner(System.in);

    public void setUp() {
        System.out.println("Enter maximum capacity:");
        capacity = scanner.nextInt();
        service = new Service(capacity);
        this.runApp();
    }
    private void mainMenu(){
        System.out.println("Commands:");
        System.out.println("1. Add vehicle.");
        System.out.println("2. Delete vehicle.");
        System.out.println("3. Show vehicles.");
        System.out.println("4. Filter vehicles.");
        System.out.println("5. Exit.");
    }

    private IVehicle vehicleCreator(String type, int id, String color) throws MyException{
        switch (type) {
            case "Bicycle", "bicycle" -> {
                return new Bicycle(id, color);
            }
            case "Car", "car" -> {
                return new Car(id, color);
            }
            case "Motorcycle", "motorcycle" -> {
                return new Motorcycle(id, color);
            }
            default -> throw new MyException("Vehicle type does not exist.");
        }
    }

    private void addVehicle() throws MyException {
        String type, color;
        int id;
        System.out.print("Type of vehicle: ");
        type = scanner.nextLine();
        System.out.print("Color of vehicle: ");
        color = scanner.nextLine();
        System.out.print("Id of vehicle: ");
        id = scanner.nextInt();
        IVehicle vehicle = vehicleCreator(type, id, color);
        try {
            service.addVehicle(vehicle);
        }
        catch (MyException error) {
            System.out.println(error.getMessage());
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private void deleteVehicle() throws MyException{
        String type;
        int id;
        System.out.print("Type of vehicle: ");
        type = scanner.nextLine();
        System.out.print("Id of vehicle: ");
        id = scanner.nextInt();
        IVehicle vehicle = vehicleCreator(type, id, "");
        try{
            service.deleteVehicle(vehicle);
        }
        catch (MyException error) {
            System.out.println(error.getMessage());
        }
        catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    private void showVehicles() {
        IVehicle[] vehicles = service.getVehicles();
        for(int index = 0; index < service.getSize(); index++) {
            System.out.println(vehicles[index].getClass().getName() + " Id:" + vehicles[index].getId() + " Color:" + vehicles[index].getColor());
        }
    }

    private void filterVehicles() throws MyException{
        IVehicle[] vehicles = service.colorFilter();
        for (IVehicle vehicle : vehicles) {
            if(vehicle != null){
                System.out.println(vehicle.getClass().getName() + " Id:" + vehicle.getId() + " Color:" + vehicle.getColor());
            }
        }
    }

    private void runApp(){
        int command;
        mainMenu();
        while(true){
            System.out.print("Enter command number: ");
            while(true) {
                try {
                    command = scanner.nextInt();
                    if (command > capacity || command < 1) {
                        throw new Exception();
                    }
                    scanner.nextLine();
                    break;
                } catch (Exception exception) {
                    System.out.println("Invalid command.");
                }
            }
            try {
                if (command == 1) {
                    addVehicle();
                }
                if (command == 2) {
                    deleteVehicle();
                }
                if (command == 3) {
                    showVehicles();
                }
                if (command == 4) {
                    filterVehicles();
                }
                if (command == 5) {
                    System.out.print("Application terminated...");
                    break;
                }
            }
            catch (MyException error){
                System.out.println(error.getMessage());
            }
            catch (Exception error){
                System.out.println(error.getLocalizedMessage());
            }
        }
    }
}
