package Model;

public class Membership extends Member {
    private String membershipType; // "active" or "passive"

    // Constructor
    public Membership(String name, String surName, int age, String address, String phoneNumber, String mail, String membershipType, String memberType) {
        super(name, surName, age, address, phoneNumber, mail, membershipType, memberType); // Kald til super-konstruktor
        this.membershipType = membershipType.toLowerCase();
    }

    // Getter for membershipType
    public String getMembershipType() {
        return membershipType;
    }

    // Setter for membershipType
    public void setMembershipType(String membershipType) {
        if (!membershipType.equalsIgnoreCase("active") && !membershipType.equalsIgnoreCase("passive")) {
            throw new IllegalArgumentException("Invalid membership type. Must be 'active' or 'passive'.");
        }
        this.membershipType = membershipType.toLowerCase();
    }

    // Override toString for detailed member information
    @Override
    public String toString() {
        return String.format(

                "Name: %s %s, Age: %d, Membership Type: %s, Address: %s, Phone: %d, Email: %s",
                 getName(), getSurname(), getAge(), membershipType, getAddress(), getPhoneNumber(), getMail()
        );
    }
}