package Model;
public class Membership extends Member {

    private MembershipType membershipType;

    public Membership(String name, String surName, int age, boolean active, boolean fitnessEnthusiast, MembershipType membershipType) {
        super(name, surName, age, active, fitnessEnthusiast);
        this.membershipType = membershipType;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

    @Override
    public double calculateContingent() {
        return Contingent.calculateContingent(membershipType);
    }

        // Override toString for detailed information
        @Override
        public String toString() {
            return String.format(
                    "Name: %s, Age: %d, Membership Type: %s, Active: %b, Fitness Enthusiast: %b, Contingent: %.2f DKK",
                    getName(), getAge(), membershipType, isActive(), isFitnessEnthusiast(), calculateContingent()
            );
        }
    }


