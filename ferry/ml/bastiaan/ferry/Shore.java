// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.ferry;

// Import the arraylist class from the java utils to get access to dynamic arrays / lists
import java.util.ArrayList;

public class Shore {
    // The shores cars capacity
    public static final int CARS_CAPACITY = 5;

    // The shores name
    private final String name;

    // The shore cars
    private final ArrayList<Car> cars;

    // The shores ferry
    private Ferry ferry;

    // The constructor method which sets the shores name and creates the cars list
    public Shore(String name) {
        this.name = name;
        cars = new ArrayList<Car>(CARS_CAPACITY);
    }

    // The name getter method which returns the shores name
    public String getName() {
        return name;
    }

    // The cars getter method which returns the shores cars
    public ArrayList<Car> getCars() {
        return cars;
    }

    // The add car method which adds a car to the shores cars if there is room
    public void addCar(Car car) {
        if (cars.size() < CARS_CAPACITY) {
            cars.add(car);
        }
    }

    // The remove car method which removes a car from the shores cars
    public void removeCar(Car car) {
        cars.remove(car);
    }

    // The ferry getter method which returns the shores ferry
    public Ferry getFerry() {
        return ferry;
    }

    // The ferry setter methods which sets the shores ferry
    public void setFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    // The print method which prints some information
    public void print() {
        System.out.println("Shore name: " + name);

        // Check if there are cars and if so print some more information about the cars
        if (cars.size() == 0) {
            System.out.println("There is no car on the ferry");
        } else {
            for (Car car : cars) {
                System.out.println("There is a car on the shore named: " + car.getName());
            }
        }

        // Check if there is a ferry and if so print some more information about the ferry
        if (ferry == null) {
            System.out.println("There is no ferry on the shore");
        } else {
            System.out.println("There is a ferry on the shore named: " + ferry.getName());
        }
    }
}
