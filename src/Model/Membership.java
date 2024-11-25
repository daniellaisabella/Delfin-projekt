package Model;
public class Membership extends Member {

    private MembershipType membershipType;

    public Membership(String name, int age, boolean active, boolean fitnessEnthusiast, MembershipType membershipType) {
        super(name, age, active, fitnessEnthusiast);
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
        return Contingent.calculateFee(membershipType);
    }

    @Override
    public String toString() {
        return String.format(
                "Name: %s, Age: %d, Active: %b, Junior: %b, Fitness Enthusiast: %b, Membership Type: %s, Contingent: %.2f",
                getName(), getAge(), isActive(), isJunior(), isFitnessEnthusiast(), membershipType, calculateContingent()
        );
    }
}


