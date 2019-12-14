// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.ferry;

// Import the arraylist class from the java utils to get access to dynamic arrays / lists
import java.util.ArrayList;

public class Simulation {
    // The simulations left shore
    private final Shore shoreLeft;

    // The simulations right shore
    private final Shore shoreRight;

    // The simulations river
    private final River river;

    // The simulations ferry
    private final Ferry ferry;

    // The constructor method which sets the left and right shore, the river and the ferry
    public Simulation(Shore shoreLeft, Shore shoreRight, River river, Ferry ferry) {
        this.shoreLeft = shoreLeft;
        this.shoreRight = shoreRight;
        this.river = river;
        this.ferry = ferry;
    }

    // The print private method which prints some information about the simulation situation every simulation step
    private void print() {
        shoreLeft.print();
        shoreRight.print();
        river.print();
        ferry.print();
        System.out.println();
    }

    // The move ferry private method which moves the ferry to another shore in the simulation
    private void moveFerry(Shore shoreStart, Shore shoreDestination) {
        // The ferry sails on the river
        river.setFerry(ferry);
        shoreStart.setFerry(null);
        print();

        // The ferry sails to the destination shore
        shoreDestination.setFerry(ferry);
        river.setFerry(null);
        print();
    }

    // The move cars private method which moves the cars via the ferry to another shore in the simulation
    private void moveCars(Shore shoreStart, Shore shoreDestination) {
        // Move all the cars from the start shore to the ferry if there is room
        ArrayList<Car> shoreStartCars = shoreStart.getCars();
        for (int i = 0; i < shoreStartCars.size(); i++) {
            Car car = shoreStartCars.get(i);
            if (
                car.getDestination() == shoreDestination.getName() &&
                ferry.getCars().size() < Ferry.CARS_CAPACITY
            ) {
                ferry.addCar(car);
                shoreStart.removeCar(car);
                i--;
            }
        }
        print();

        // Move the ferry from the start to the destination shore
        moveFerry(shoreStart, shoreDestination);

        // Move all the cars from the ferry to the destination shore
        ArrayList<Car> ferryCars = ferry.getCars();
        for (int i = 0; i < ferryCars.size(); i++) {
            Car car = ferryCars.get(i);
            shoreDestination.addCar(car);
            ferry.removeCar(car);
            i--;
        }
        print();
    }

    // The pass river method which simulates the cars passing the river
    public void passRiver(ArrayList<Car> cars) {
        // Initialize the simulation with the cars and the ferry
        for (Car car : cars) {
            // When the car start shore is the left shore add it to that
            if (car.getStart() == shoreLeft.getName()) {
                shoreLeft.addCar(car);
            }

            // When the car start shore is the right shore add it to that
            if (car.getStart() == shoreRight.getName()) {
                shoreRight.addCar(car);
            }
        }
        shoreLeft.setFerry(ferry);
        print();

        // Check if there are any cars that what to move from the left to the right shore
        boolean moveToShoreRight = false;
        for (Car car : shoreLeft.getCars()) {
            if (car.getDestination() == shoreRight.getName()) {
                moveToShoreRight = true;
                break;
            }
        }

        // Check if there are cars that want to move from the right to the left shore
        for (Car car : shoreRight.getCars()) {
            if (car.getDestination() == shoreLeft.getName()) {
                moveToShoreRight = true;
                break;
            }
        }

        // Move the cars from the left shore to the right
        if (moveToShoreRight) {
            moveCars(shoreLeft, shoreRight);

            // Check if there are any cars that what to move to the left shore
            boolean moveToShoreLeft = false;
            for (Car car : shoreRight.getCars()) {
                if (car.getDestination() == shoreLeft.getName()) {
                    moveToShoreLeft = true;
                    break;
                }
            }

            // Move the cars from the right shore to the left
            if (moveToShoreLeft) {
                moveCars(shoreRight, shoreLeft);
            }
        }
    }

    // The clear cars method which removes all the cars from the simulation
    public void clearCars() {
        shoreLeft.getCars().clear();
        shoreRight.getCars().clear();
        ferry.getCars().clear();
    }
}
