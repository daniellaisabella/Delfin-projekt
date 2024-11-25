package Model;

    public class Membership extends Member {

        // Enum to categorize membership types
        private MembershipType membershipType;

        // Constructor
        public Membership(String name, int age, boolean active, boolean fitnessEnthusiast, MembershipType membershipType) {
            super(name, age, active, fitnessEnthusiast); // Call to the Member class constructor
            this.membershipType = membershipType;
        }

        // Getter and Setter for membership type
        public MembershipType getMembershipType() {
            return membershipType;
        }

        public void setMembershipType(MembershipType membershipType) {
            this.membershipType = membershipType;
        }

        // Calculate contingent based on membership type
        @Override
        public double calculateContingent() {
            switch (membershipType) {
                case PASSIVE:
                    return 500.0;
                case ACTIVE_JUNIOR:
                    return 1000.0;
                case ACTIVE_SENIOR:
                    return 1600.0;
                case ACTIVE_PENSIONIST:
                    return 1200.0;
                default:
                    throw new IllegalArgumentException("Invalid membership type");
            }

        }

        // Override toString for detailed information
        @Override
        public String toString() {
            return String.format(
                    "Name: %s, Age: %d, Membership Type: %s, Active: %b, Fitness Enthusiast: %b, Contingent: %.2f DKK",
                    getName(), getAge(), membershipType, isActive(), isFitnessEnthusiast(), calculateContingent()
            );
        }
        package Model;




            public int annualContingent(Member member) {
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


