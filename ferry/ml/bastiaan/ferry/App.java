package ml.bastiaan.ferry;

// Import the arraylist class from the java utils to get access to dynamic arrays / lists
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        // Create the left shore object
        Shore shoreLeft = new Shore("Left Shore");

        // Create the right shore object
        Shore shoreRight = new Shore("Right Shore");

        // Create the river object
        River river = new River("The mighty River");

        // Create the ferry object
        Ferry ferry = new Ferry("The big Ferry");

        // Create the cars list object
        ArrayList<Car> cars = new ArrayList<Car>();

        // Create the left car A object and add it to cars
        Car carLeftA = new Car("The left Car A");
        carLeftA.setStart(shoreLeft.getName());
        carLeftA.setDestination(shoreRight.getName());
        cars.add(carLeftA);

        // Create the left car B object and add it to cars
        Car carLeftB = new Car("The left Car B");
        carLeftB.setStart(shoreLeft.getName());
        carLeftB.setDestination(shoreRight.getName());
        cars.add(carLeftB);

        // Create the left car C object and add it to cars
        Car carLeftC = new Car("The left Car C");
        carLeftC.setStart(shoreLeft.getName());
        carLeftC.setDestination("Don't Move");
        cars.add(carLeftC);

        // Create the right car A object and add it to cars
        Car carRightA = new Car("The right Car A");
        carRightA.setStart(shoreRight.getName());
        carRightA.setDestination(shoreLeft.getName());
        cars.add(carRightA);

        // Create the right car B object and add it to cars
        Car carRightB = new Car("The right Car B");
        carRightB.setStart(shoreRight.getName());
        carRightB.setDestination(shoreLeft.getName());
        cars.add(carRightB);

        // Create a simulation object with the shores, the river and the ferry
        Simulation simulation = new Simulation(shoreLeft, shoreRight, river, ferry);

        // Run the simulation with the cars
        simulation.passRiver(cars);
    }
}
