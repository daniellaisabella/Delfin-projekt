package Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Member {

    // Attributes
    private String name;
    private String surname;
    private String username;
    private LocalDate age; // Used to calculate age
    private boolean isActive; // Determines if the member participates actively
    private MembershipType membershipType;
    private String address;
    private int phoneNumber;
    private String mail;
    private boolean isCompetitive;
    private String swimStroke;
    private double timePerformance;
    private String MembershipType;

    // Constructor
    public Member(String name, String surname, LocalDate age, String address, int phoneNumber, String mail, boolean isActive, boolean isCompetitive) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.isActive = isActive;
        this.isCompetitive = isCompetitive;
    }

    // Constructor with fewer attributes
    public Member(String name, String surname, LocalDate age, boolean isActive) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.isActive = isActive;
    }

    // Method to capitalize the first letter of a name
    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // Calculate age based on age
    public int getAge() {
        return Period.between(age, LocalDate.now()).getYears();
    }

    // Display member details
    @Override
    public String toString() {
        return String.format(
                "Name: %s %s, Age: %d, Active: %b, Competitive: %b",
                name, surname, age, isActive, isCompetitive
        );
    }

    // *** GETTERS *** //

    public String getMembershipType() {
        return MembershipType;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }



    /*public LocalDate getAge() {
        return age;*\

     */


    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public boolean isActive() {
        return isActive;
    }

    public boolean isCompetitive() {
        return isCompetitive;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePerformance() {
        return timePerformance;
    }

    // *** SETTERS *** //

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = capitalizeFirstLetter(name);
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Invalid surname");
        }
        this.surname = capitalizeFirstLetter(surname);
    }

    public void setUsername(String username) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Invalid username");
        }
        this.username = username;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Invalid address");
        }
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setMail(String mail) {
        if (mail == null || mail.isEmpty() || !mail.contains("@")) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        this.mail = mail;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setIsCompetitive(boolean isCompetitive) {
        this.isCompetitive = isCompetitive;
    }

    public void setSwimStroke(String swimStroke) {
        if (swimStroke == null || swimStroke.isEmpty()) {
            throw new IllegalArgumentException("Swim stroke cannot be null or empty.");
        }
        this.swimStroke = swimStroke;
    }

    public void setTimePerformance(double timePerformance) {
        if (timePerformance <= 0) {
            throw new IllegalArgumentException("Swim time must be greater than zero.");
        }
        this.timePerformance = timePerformance;
    }
}

