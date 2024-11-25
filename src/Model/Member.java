package Model;

public abstract class Member {

    // Attributes
    private String name;
    private int age; // Determines if the member is junior or senior
    private boolean active; // Determines if the member participates actively
    private boolean fitnessEnthusiast;


    // Constructor
    public Member(String name, int age, boolean active, boolean fitnessEnthusiast) {
        this.name = name;
        setAge(age); // Use setter to validate age
        this.active = active;
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

    // Abstract method to calculate Contingent
    public abstract double calculateContingent();

    // *** GETTERS *** //
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return active;
    }

    public boolean isFitnessEnthusiast() {
        return fitnessEnthusiast;
    }

    // Determines if the member is a junior based on age
    public boolean isJunior() {
        return age < 18;
    }

    // *** SETTERS *** //
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        this.age = age;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setFitnessEnthusiast(boolean fitnessEnthusiast) {
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

    // Display member details
    @Override
    public String toString() {
        return String.format(
                "Name: %s, Age: %d, Active: %b, Junior: %b, Fitness Enthusiast: %b",
                name, age, active, isJunior(), fitnessEnthusiast
        );
    }

}
