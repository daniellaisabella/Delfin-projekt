package Model;

public abstract class Member {

    //Attributes
    private String name;
    private int age;
    private String address;
    private boolean phoneNumber;
    private boolean isActive;
    private boolean isCompetetive;
    // Medlemsskabs nr.?

    //Constructor
    public Member(String name, int age, String address, int phoneNumber, boolean isActive, boolean isCompetetive) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isCompetetive = isCompetetive;

    }

    //Constructor - Membership
    public Member( int age, boolean active, boolean junior, boolean fitnessEnthusiast) {
        this.age = age;
        this.active = active;
        this.junior = junior;
        this.fitnessEnthusiast = fitnessEnthusiast;
    }

}
