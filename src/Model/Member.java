package Model;

public abstract class Member {

    // Attributes
    private String name;
    private String surname;
    private String username;
    private int age; // Changed to int to store age directly
    private boolean isActive; // Determines if the member participates actively
    private MembershipType membershipType;
    private String address;
    private int phoneNumber;
    private String mail;
    private boolean isCompetitive;
    private String swimStroke;
    private double timePerformance;

    // Constructor with full attributes
    public Member(String name, String surname, int age, String address, int phoneNumber, String mail, boolean isActive, boolean isCompetitive) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age; // Assign age as int
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.isActive = isActive;
        this.isCompetitive = isCompetitive;
    }

    // Constructor with fewer attributes
    public Member(String name, String surname, int age, boolean isActive) {
        this.name = capitalizeFirstLetter(name);
        this.surname = capitalizeFirstLetter(surname);
        this.age = age; // Assign age as int
        this.isActive = isActive;
    }

    // Method to capitalize the first letter of a name
    private String capitalizeFirstLetter(String word) {
        return word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
    }

    // Getter for age
    public int getAge() {
        return age; // Returns age directly
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

    public MembershipType getMembershipType() {
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
            throw new IllegalArgumentException("Invalid swim stroke");
        }
        this.swimStroke = swimStroke;
    }

    public void setTimePerformance(double timePerformance) {
        if (timePerformance <= 0) {
            throw new IllegalArgumentException("Invalid swim time");
        }
        this.timePerformance = timePerformance;
    }
}
