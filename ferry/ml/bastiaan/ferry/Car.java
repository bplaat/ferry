// Made by Bastiaan van der Plaat (0983259) uit TINPRO02-2

package ml.bastiaan.ferry;

public class Car {
    // The cars name variable
    private final String name;

    // The cars start shore name variable
    private String start;

    // The cars destination shore name variable
    private String destination;

    // The constructor method which sets the cars name
    public Car(String name) {
        this.name = name;
    }

    // The name getter method which returns the cars name
    public String getName() {
        return name;
    }

    // The start getter method which returns the cars start
    public String getStart() {
        return start;
    }

    // The start setter methods which sets the cars start
    public void setStart(String start) {
        this.start = start;
    }

    // The destination getter method which returns the cars destination
    public String getDestination() {
        return destination;
    }

    // The destination setter methods which sets the cars destination
    public void setDestination(String destination) {
        this.destination = destination;
    }

    // The print method which prints some information
    public void print() {
        System.out.println("Car name: " + name + ", start shore: " + start + " and destination shore: " + destination);
    }
}
