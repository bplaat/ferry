package ml.bastiaan.ferry;

public class River {
    // The river name
    private final String name;

    // The river ferry
    private Ferry ferry;

    // The constructor method which sets the river name
    public River(String name) {
        this.name = name;
    }

    // The name getter method which returns the river name
    public String getName() {
        return name;
    }

    // The ferry getter method which returns the river ferry
    public Ferry getFerry() {
        return ferry;
    }

    // The ferry setter methods which sets the river ferry
    public void setFerry(Ferry ferry) {
        this.ferry = ferry;
    }

    // The print method which prints some information
    public void print() {
        System.out.println("River name: " + name);

        // Check if there is a ferry and if so print some more information about the ferry
        if (ferry == null) {
            System.out.println("There is no ferry on the river");
        } else {
            System.out.println("There is a ferry on the river named: " + ferry.getName());
        }
    }
}
