package Model;

public abstract class Member {

    // Attributes
    private String name;
    private String surname;
    private String username;
    private int age; // Determines if the member is junior or senior
    private boolean isActive; // Determines if the member participates actively
    private String address;
    private int phoneNumber;
    private boolean isCompetetive;
    private String swimDiscipline;
    private String swimTime;
    private boolean isCompetitive;


    //Constructor
    public Member(String name, String surName, int age, String address, int phoneNumber, boolean isActive, boolean isCompetetive) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surName);
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isCompetetive = isCompetetive;
    }

    // Constructor
    public Member(String name, String surName, int age, boolean isActive) {
        this.name = name;
        this.surname = surName;
        this.age = age;
        this.isActive = isActive;
    }


    public Member(String swimDiscipline, double time) {
        this.swimDiscipline = swimDiscipline;
        this.time = time;
    }

    //Method to capitalize first letter in name
    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    //
    public double calculateContingent() {
        return 0;
    }

    // *** GETTERS *** //
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

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

    public void setUsername(String username) {
        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException(("Username can not be empty"));
        }
        this.username = username;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Surname cannot be null or empty.");
        }
        this.surname = surname;
    }

    public void setSwimTime(String swimTime) {
        this.swimTime = swimTime;
    }

    public void setIsCompetitive(boolean isCompetitive) {
        this.isCompetitive = isCompetitive;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Address cannot be null or empty.");
        }
        this.address = address;
    }

    public void setSwimDiscipline(String swimDiscipline) {
        if (swimDiscipline == null || swimDiscipline.isEmpty()) {
            throw new IllegalArgumentException("Swim discipline cannot be null or empty.");
        }
        this.swimDiscipline = swimDiscipline;
    }

    public void setSwimTime(double swimTime) {
        if (swimTime <= 0) {
            throw new IllegalArgumentException("Swim time must be greater than zero.");
        }
        this.swimTime = swimTime;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero.");
        }
        this.age = age;
    }

    public void setPhoneNumber(int age) {
        if (phoneNumber <= 0) {
            throw new IllegalArgumentException("Phone number must be greater than zero.");
        }
        this.phoneNumber = phoneNumber;
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
                name, age, isActive, isJunior(), isCompetetive
        );
    }
}


