package Model;

public class Membership extends Member {

    private MembershipType membershipType;

    // Constructor updated to use int age instead of LocalDate
    public Membership(String name, String surName, int age, String address, int phoneNumber, String mail, boolean isActive, boolean isCompetitive, MembershipType membershipType) {
        super(name, surName, age, address, phoneNumber, mail, isActive, isCompetitive);
        this.membershipType = membershipType;
    }

    // Getter for membershipType
    public Model.MembershipType getMembershipType() {
        return membershipType;
    }

    // Setter for membershipType
    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    // Override toString for detailed member information
    @Override
    public String toString() {
        return String.format(
                "Name: %s %s, Age: %d, Membership Type: %s, Active: %b, Competitive: %b, Annual Contingent: %d DKK",
                getName(), getSurname(), getAge(), membershipType, isActive(), isCompetitive());
    }

    // Additional methods for payment tracking or contingent calculation can be added here
}
