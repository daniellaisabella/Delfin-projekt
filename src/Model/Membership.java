package Model;

import java.time.LocalDate;

public class Membership extends Member {

    private MembershipType membershipType;

    public Membership(String name, String surName, LocalDate age, String address, int phoneNumber, String mail, boolean isActive, boolean isCompetitive, MembershipType membershipType) {
        super(name, surName, age, address, phoneNumber, mail, isActive, isCompetitive);
        this.membershipType = membershipType;
    }

    // Getter for membershipType
    public MembershipType getMembershipType() {
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
                getName(), getSurname(), getAge(), membershipType, isActive(), isCompetitive(), calculateAnnualContingent());
    }

    //calculating contingent based on age & active/passive
    public int calculateAnnualContingent() {
        int juniorContingent = 1000;
        int seniorContingent = 1600;
        int pensionistContingent = 1200;
        int passiveContingent = 500;
        int age = getAge();

        if (isActive()) {
            if (age <= 17) return juniorContingent;
            if (age <= 59) return seniorContingent;
            return pensionistContingent;
        } else {
            return passiveContingent;
        }
    }
}

    // Method to check payment status (commented out as it needs additional logic)
    // This method assumes there is an `outstandingFee` attribute to track payment status
    /*
    public boolean hasPaid() {
        if (outstandingFee == 0) {
            return true;
        } else {
            System.out.println("Member has outstanding fee: " + outstandingFee);
            return false;
        }
    }
    */

