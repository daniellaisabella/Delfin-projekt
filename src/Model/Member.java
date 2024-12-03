package Model;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;
import java.time.LocalDate;
import java.time.Period;

public abstract class Member {

    // Attributes
    private String name;
    private String surname;
    private String username;
    private int age; // Used to calculate age
    private String active;
    private String passive;
    private MembershipType membershipType;
    private String address;
    private int phoneNumber;
    private String mail;
    private String Competitive;
    private String fitnessEnthusiast;
    private String swimStroke;
    private double timePerformance;

    // Constructor
    public Member(String name, String surname, int age, String address, int phoneNumber, String mail, String active, String passive, String competitive, String fitnessEnthusiast) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.active = active;
        this.passive = passive;
        this.Competitive = competitive;
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

    // Constructor with fewer attributes
    public Member(String name, String surname, int age, String active) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age;
        this.active = active;
    }

    // Method to capitalize the first letter of a name
    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // Calculate age based on age
    public int getAge() {
        return age;
    }

    // Display member details
    @Override
    public String toString() {
        return String.format(
                "Name: %s %s, Age: %d, Active: %b, Competitive: %b",
                name, surname, age, active, passive, Competitive, fitnessEnthusiast
        );
    }

    // *** GETTERS *** //

    public Model.MembershipType getMembershipType() {
        return membershipType;
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

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public String active() {
        return active;
    }

    public String passing() {
        return passive;
    }

    public String Competitive() {
        return Competitive;
    }

    public String getFitnessEnthusiast() {
        return fitnessEnthusiast;
    }

    public String getSwimStroke() {
        return swimStroke;
    }

    public double getTimePerformance() {
        return timePerformance;
    }

    // *** SETTERS *** //
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

    public void setActive(String active) {
        if (active == null || active.isEmpty()) {
            throw new IllegalArgumentException("Invalid membership type");
        }
        this.active = active;
    }

    public void setPassive(String passive) {
        if (passive == null || passive.isEmpty()) {
            throw new IllegalArgumentException("Invalid membership type");
        }
        this.passive = passive;
    }

    public void setTimePerformance(double timePerformance) {
        if (timePerformance <= 0) {
            throw new IllegalArgumentException("Invalid swim time");
        }
        this.timePerformance = timePerformance;
    }

    public void setCompetitive(String competitive) {
        if (competitive == null || competitive.isEmpty()) {
            throw new IllegalArgumentException("Invalid membership type");
        }
        this.competitive = competitive;
    }

    public void setFitnessEnthusiast(String fitnessEnthusiast) {
        if (fitnessEnthusiast == null || fitnessEnthusiast.isEmpty()) {
            throw new IllegalArgumentException("Invalid membership type");
        }
        this.fitnessEnthusiast = fitnessEnthusiast;
    }
}

