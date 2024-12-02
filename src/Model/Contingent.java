package Model;

import static Model.MembershipType.*;

public class Contingent {
    private final int age;
    private final boolean isActive;

    // Constants for fees
    private static final double PASSIVE_FEE = 500.0;
    private static final double ACTIVE_JUNIOR_FEE = 1000.0;
    private static final double ACTIVE_SENIOR_FEE = 1600.0;
    private static final double ACTIVE_RETIREES_FEE = 1200.0;

    public Contingent(int age, boolean isActive) {
        this.age = age;
        this.isActive = isActive;
    }

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

    public int calculateAnnualContingent() {
        int juniorContingent = 1000;
        int seniorContingent = 1600;
        int pensionistContingent = 1200;
        int passiveContingent = 500;

        if (isActive) {
            if (age < 18) return juniorContingent;
            if (age < 60 && age >= 18) return seniorContingent;
            return pensionistContingent;
        } else {
            return passiveContingent;
        }
    }

    // Getters for age and isActive (if needed)
    public int getAge() {
        return age;
    }

    public boolean isActive() {
        return isActive;
    }
}
