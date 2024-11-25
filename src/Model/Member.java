package Model;

public class Member {

    //Attributes
    private String name;
    private int dob;
    private String address;
    private int phoneNumber;
    private boolean isActive;
    private boolean isCompetetive;
    // Medlemsskabs nr.?

    //Constructor
    public Member(String name, int dob, String address, int phoneNumber, boolean isActive, boolean isCompetetive) {
        this.name = name;
        this.dob = dob;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
        this.isCompetetive = isCompetetive;

    }

    //Constructor - Membership
    public Member( int dob, boolean isActive, boolean isCompetetive) {
        this.dob = dob;
        this.isActive = isActive;
        this.isCompetetive = isCompetetive;
    }

}
