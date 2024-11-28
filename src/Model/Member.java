package Model;
import java.time.LocalDate;
import java.time.Period;
public abstract class Member {

    // Attributes
    private String name;
    private String surName;
    private boolean isActive; // Determines if the member participates actively
    private String address;
    private int phoneNumber;
    private boolean isCompetetive;
    private String swimStroke;
    private double timePreformance;
    private LocalDate age;


    //Constructor
    public Member(String name, String surName, LocalDate age, String address, int phoneNumber, boolean isActive, boolean isCompetetive) {
        this.name = capitalizeFirstLetter(name);
        this.surName = capitalizeFirstLetter(surName);
        this.age = age;
        this.address = address;

        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isCompetetive = isCompetetive;
    }

    // Constructor
    public Member(String name, String surName, LocalDate age, boolean isActive) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.isActive = isActive;
    }


    public Member(String swimStroke, double timePreformance) {
        this.swimStroke = swimStroke;
        this.timePreformance = timePreformance;
    }

    //Method to capitalize first letter in name
    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    //-----suggestion to remove and be handled by contingent class instead
    public double calculateContingent() {
        return 0;
    }


    // *** GETTERS *** //
    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return Period.between(age, LocalDate.now()).getYears();
    }
    /*public LocalDate getAge() {
        return age;*\

     */


    public boolean isActive() {
        return isActive;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isCompetetive() {
        return isCompetetive;
    }

    // Determines if the member is a junior based on age
    //-------------suggestion to remove this method and use membershipType method instead
   /* public boolean isJunior() {
        return age < 18;\

    */

    // *** SETTERS *** //
    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setAge(LocalDate age) {
        if (age == null ||age.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        this.age = age;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsCompetetive(boolean isCompetetive) {
        this.isCompetetive = isCompetetive;
    }

    // Display member details
    @Override
    public String toString() {
        return String.format(
                "Name: %s, Age: %d, Active: %b, Junior: %b, Competetive: %b",
                name, age, isActive, isCompetetive
        );
    }
}


