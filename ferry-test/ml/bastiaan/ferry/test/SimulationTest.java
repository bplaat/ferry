package ml.bastiaan.ferry.test;

// Import the arraylist class from the java utils to get access to dynamic arrays / lists
import java.util.ArrayList;

// Import the classes from the ferry simulator to use them in the tests
import ml.bastiaan.ferry.Car;
import ml.bastiaan.ferry.Ferry;
import ml.bastiaan.ferry.River;
import ml.bastiaan.ferry.Shore;
import ml.bastiaan.ferry.Simulation;

public class SimulationTest {
    // The test simulations left shore
    private Shore shoreLeft;

    // The test simulations right shore
    private Shore shoreRight;

    // The test simulations river
    private River river;

    // The test simulations ferry
    private Ferry ferry;

    // The test simulation
    private Simulation simulation;

    // The constructor method which creates the test objects for the simulation
    public SimulationTest() {
        shoreLeft = new Shore("The left test Shore");
        shoreRight = new Shore("The right test Shore");
        river = new River("The test River");
        ferry = new Ferry("The test Ferry");
        simulation = new Simulation(shoreLeft, shoreRight, river, ferry);
    }

    // A test that tests that a car can not be on the shor or on the ferry on the same time
    public boolean testTheCarNotOnTheFerryAndTheShoreAtTheSameTime() {
        Shore shoreStart = shoreLeft;
        Shore shoreDestination = shoreRight;

        ArrayList<Car> cars = new ArrayList<Car>();
        Car car = new Car("The test Car");
        car.setStart(shoreStart.getName());
        car.setDestination(shoreDestination.getName());
        cars.add(car);

        simulation.passRiver(cars);

        if (shoreDestination.getCars().size() != 1) return false;
        if (shoreDestination.getFerry().getCars().size() != 0) return false;
        return true;
    }

    // A test that tests that the car can on max one shore at the time
    public boolean testTheCarMaxOnOneShore() {
        Shore shoreStart = shoreLeft;
        Shore shoreDestination = shoreRight;

        ArrayList<Car> cars = new ArrayList<Car>();
        Car car = new Car("The test Car");
        car.setStart(shoreStart.getName());
        car.setDestination(shoreDestination.getName());
        cars.add(car);

        simulation.passRiver(cars);

        if (shoreDestination.getCars().size() != 1) return false;
        if (shoreStart.getCars().size() != 0) return false;
        return true;
    }

    // A test the tests that the ferry is only at one shore at the time
    public boolean testTheFerryMaxOnOneShore() {
        Shore shoreStart = shoreLeft;
        Shore shoreDestination = shoreRight;

        ArrayList<Car> cars = new ArrayList<Car>();
        Car car = new Car("The test Car");
        car.setStart(shoreStart.getName());
        car.setDestination(shoreDestination.getName());
        cars.add(car);

        simulation.passRiver(cars);

        if (shoreDestination.getFerry() == null) return false;
        if (shoreStart.getFerry() != null) return false;
        return true;
    }

    // A test that tests if there are more then three cars put on the ferry
    public boolean testMaxThreeCarsOnTheFerry() {
        Shore shoreStart = shoreLeft;
        Shore shoreDestination = shoreRight;

        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 1; i <= 4; i++) {
            Car car = new Car("The test Car " + i);
            car.setStart(shoreStart.getName());
            car.setDestination(shoreDestination.getName());
            cars.add(car);
        }

        simulation.passRiver(cars);

        if (shoreDestination.getCars().size() == 4) return false;
        if (shoreStart.getCars().size() == 0) return false;
        return true;
    }

    // The run tests method run the above tests and exists when a test fails
    public void runTests() {
        // Run a test and exit when it fails clear the cars when succesfull
        if (!testTheCarNotOnTheFerryAndTheShoreAtTheSameTime()) {
            System.out.println("The car not on the ferry and the shore at the same time failed");
            System.exit(0);
        }
        simulation.clearCars();

        // Run a test and exit when it fails clear the cars when succesfull
        if (!testTheCarMaxOnOneShore()) {
            System.out.println("The test the car max one shore failed");
            System.exit(0);
        }
        simulation.clearCars();

        // Run a test and exit when it fails clear the cars when succesfull
        if (!testTheFerryMaxOnOneShore()) {
            System.out.println("The test the ferry max one shore failed");
            System.exit(0);
        }
        simulation.clearCars();

        // Run a test and exit when it fails clear the cars when succesfull
        if (!testMaxThreeCarsOnTheFerry()) {
            System.out.println("The test max three cars on the ferry failed");
            System.exit(0);
        }
        simulation.clearCars();

        // Print a message that says that all tests are passed
        System.out.println("All tests passed");
    }
}
