// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.ferry;

// Import the arraylist class from the java utils to get access to dynamic arrays / lists
import java.util.ArrayList;

public class Ferry {
    // The ferry cars capacity
    public static final int CARS_CAPACITY = 3;

    // The ferry name
    private final String name;

    // The ferry cars
    private final ArrayList<Car> cars;

    // The constructor method which sets the ferry name and creates the cars list
    public Ferry(String name) {
        this.name = name;
        cars = new ArrayList<Car>(CARS_CAPACITY);
    }

    // The name getter method which returns the ferry name
    public String getName() {
        return name;
    }

    // The cars getter method which returns the ferry cars
    public ArrayList<Car> getCars() {
        return cars;
    }

    // The add car method which adds a car to the ferry cars if there is room
    public void addCar(Car car) {
        if (cars.size() < CARS_CAPACITY) {
            cars.add(car);
        }
    }

    // The remove car method which removes a car from the ferry cars
    public void removeCar(Car car) {
        cars.remove(car);
    }

    // The print method which prints some information
    public void print() {
        System.out.println("Ferry name: " + name);

        // Check if there are cars and if so print some more information about the cars
        if (cars.size() == 0) {
            System.out.println("There is no car on the ferry");
        } else {
            for (Car car : cars) {
                System.out.println("There is a car on the ferry named: " + car.getName());
            }
        }
    }
}
