import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;

public class example3 {
    private static final Logger logger = Logger.getLogger(example3.class.getName());
    private String name;
    private int value;

    // Constructor
    public example3(String name, int value) {
        this.name = name;
        this.value = value;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for value
    public int getValue() {
        return value;
    }

    // Setter for value
    public void setValue(int value) {
        this.value = value;
    }

    // Example method
    public void displayInfo() {
        logger.log(Level.INFO, "Name: {0}, Value: {1}", new Object[] { name, value });
    }

    // Main method for testing
    public static void main(String[] args) {
        example3 obj = new example3("TestObject", 42);
        obj.displayInfo();
    }
}