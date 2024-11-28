package Model;
public class Contingent {

    // Constants for fees
    private static final double PASSIVE_FEE = 500.0;
    private static final double ACTIVE_JUNIOR_FEE = 1000.0;
    private static final double ACTIVE_SENIOR_FEE = 1600.0;
    private static final double ACTIVE_RETIREES_FEE = 1200.0;

    // Calculate contingent based on MembershipType
    public static double calculateContingent(MembershipType type) {
        switch (type) {
            case PASSIVE:
                return PASSIVE_FEE;
            case ACTIVE_JUNIOR:
                return ACTIVE_JUNIOR_FEE;
            case ACTIVE_SENIOR:
                return ACTIVE_SENIOR_FEE;
            case ACTIVE_RETIREE:
                return ACTIVE_RETIREES_FEE;
            default:
                throw new IllegalArgumentException("Invalid membership type");
        }
    }
}

//add method to determine membership type based on age, and active/pasive

