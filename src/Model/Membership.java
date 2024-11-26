package Model;
public class Membership extends Member {

    private MembershipType membershipType;

    public Membership(String name, String surName, int age, boolean isActive, boolean isCompetetive, MembershipType membershipType) {
        super(name, surName, age, isActive, isCompetetive);
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
                    "Name: %s, Age: %d, Membership Type: %s, Active: %b, Competetive: %b, Contingent: %.2f DKK",
                    getName(), getAge(), membershipType, isActive(), isCompetetive(), calculateContingent()
            );
        }
    public int annualContingent;
    private boolean hasPaid;
    public int AnnualContingent(Member member) {
        int Junior = 1000;
        int Senior = 1600;
        int Pensionist = 1200;
        int passiveMembership = 500;
        int annualContingent = 0;
        int age = member.getAge();

        if (!member.isActive) {
            annualContingent = passiveMembership;

        } else if (age < 18 && member.isActive) {
            annualContingent = Junior;

        } else if (age > 18 && age < 59 && member.isActive){
            annualContingent = Senior;

        }else if (age > 59 && member.isActive) {
            annualContingent = Pensionist;

        }
        return annualContingent;
    }

}
public boolean hasPaid() {
    if(hasPaid) {
        return true;
    } else return ("Your outstanding fee is: " + getAnnualContingent());
}

    }





