package Model;
import java.time.LocalDate;
import java.time.Period;

import static Model.MembershipType.*;

public class Contingent {
    private final LocalDate age;
    private final boolean isActive;
    Contingent contingent = new Contingent();
    int annualContingent = contingent.calculateAnnualContingent();

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
       public Contingent() {
            this.age = LocalDate.now();
            this.isActive = true;
        }

        public int calculateAnnualContingent() {
            int juniorContingent = 1000;
            int seniorContingent = 1600;
            int pensionistContingent = 1200;
            int passiveContingent = 500;
            int age = calculateAge(this.age);

            if (isActive) {
                if (age < 18) return juniorContingent;
                if (age < 60 && age >= 18) return seniorContingent;
                return pensionistContingent;
            } else {
                return passiveContingent;
            }
        }

        private int calculateAge(LocalDate age) {
            LocalDate today = LocalDate.now();
            Period Period;
            return java.time.Period.between(this.age, today).getYears();
        }
    }




